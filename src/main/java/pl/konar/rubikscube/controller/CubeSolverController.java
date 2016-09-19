package pl.konar.rubikscube.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.beans.binding.Bindings;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
//import javafx.scene.control.Alert;
//import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import pl.konar.rubikscube.model.colour.Colour;
import pl.konar.rubikscube.model.cube.Angle;
import pl.konar.rubikscube.model.cube.CubeConstants;
import pl.konar.rubikscube.model.cube.Face;
import pl.konar.rubikscube.model.cube.SolverModel;
import pl.konar.rubikscube.model.cube.ThistlethwaiteMove;
import pl.konar.rubikscube.model.cube.exception.CubeNotMappableException;
import pl.konar.rubikscube.model.cube.exception.CubeNotSolvableException;

public class CubeSolverController {

	private static final int[] FACE_X_OFFSETS = { 4, 12, 8, 4, 0, 4 };
	private static final int[] FACE_Y_OFFSETS = { 0, 4, 4, 4, 4, 8 };

	private SolverModel model = new SolverModel();

	// private Alert alert = new Alert(AlertType.INFORMATION);
	private Stage alert = new Stage();

	@FXML
	private URL location;

	@FXML
	private ResourceBundle resources;

	@FXML
	private GridPane cubeLayout;

	@FXML
	private Button solveButton;

	@FXML
	private Button scrambleButton;

	@FXML
	private ListView<ThistlethwaiteMove> solutionList;

	@FXML
	private VBox colourSelectionBox;

	@FXML
	private void initialize() {
		initializeCubeLayout();
		initializeSolveButton();
		initializeSolutionList();
		initializeFillButton();
		initializeAlert();
		initializeColourSelection();
	}

	private void initializeColourSelection() {
		colourSelectionBox.disableProperty().bind(model.isSolvedProperty());
		ToggleGroup colourGroup = new ToggleGroup();
		for (Colour colour : Colour.getAllNonTransparentList()) {
			ToggleButton button = new ToggleButton();
			button.setToggleGroup(colourGroup);
			button.setOnAction(event -> model.setCurrentColour(button.isSelected() ? colour : Colour.TRANSPARENT));
			button.getStyleClass().add("facet");
			button.getStyleClass().add("colour-picker");
			button.setStyle("-fx-background-color: " + colour);
			colourSelectionBox.getChildren().add(button);
		}
	}

	private void initializeCubeLayout() {
		cubeLayout.disableProperty().bind(model.isSolvedProperty());
		for (int face = 0; face < CubeConstants.NUMBER_OF_FACES; ++face) {
			for (int row = 0; row < CubeConstants.NUMBER_OF_ROWS_PER_FACE; ++row) {
				for (int column = 0; column < CubeConstants.NUMBER_OF_COLUMNS_PER_FACE; ++column) {
					Button button = new Button();
					initializeFacetButton(button, face, row, column);
					cubeLayout.add(button, FACE_X_OFFSETS[face] + column, FACE_Y_OFFSETS[face] + row);
				}
			}
		}
	}

	private void initializeFacetButton(Button button, int wall, int row, int column) {
		button.getStyleClass().add("facet");
		button.getStyleClass().add("cube-layout");
		int facetNumber = model.getCubeNthFacetNumber(CubeConstants.NUMBER_OF_FACETS_PER_FACE * wall
				+ CubeConstants.NUMBER_OF_COLUMNS_PER_FACE * row + column);
		button.setOnAction(event -> {
			model.changeColour(facetNumber);
		});
		bindButtonToFacet(button, facetNumber);
	}

	private void bindButtonToFacet(Button button, int buttonFacetNumber) {
		button.styleProperty().bind(Bindings.concat("-fx-background-color: ",
				Bindings.valueAt(model.cubeFacetsProperty(), buttonFacetNumber)));
	}

	private void initializeSolveButton() {
		solveButton.disableProperty().bind(Bindings.not(model.isSolvableProperty()));
	}

	private void initializeSolutionList() {
		solutionList.disableProperty().bind(Bindings.not(model.isSolvedProperty()));
		solutionList.itemsProperty().bind(model.solutionProperty());
		solutionList.setCellFactory(param -> {
			return new ListCell<ThistlethwaiteMove>() {
				@Override
				protected void updateItem(ThistlethwaiteMove move, boolean empty) {
					super.updateItem(move, empty);
					if (empty) {
						setText("");
					} else {
						String text = resources.getString("move.empty");
						Colour colour = Colour.TRANSPARENT;
						if (move != null) {
							Face face = move.getFace();
							colour = model.getCube().getColour(face.ordinal());
							Angle angle = move.getAngle();
							text = resources.getString("colour." + colour) + " "
									+ resources.getString("angle." + angle);
						}
						setText(text);
					}
				}
			};
		});
		solutionList.getSelectionModel().selectedIndexProperty().addListener((obs, oldVal, newVal) -> {
			model.applyPartialSolution(oldVal.intValue(), newVal.intValue());
		});
	}

	private void initializeFillButton() {
		scrambleButton.disableProperty().bind(model.isSolvedProperty());
	}

	private void initializeAlert() {
		Button abortButton = new Button(resources.getString("alert.abort"));
		abortButton.setOnAction(event -> alert.hide());
		alert.initStyle(StageStyle.UTILITY);
		VBox vBox = new VBox(new Text(resources.getString("alert.content")), new ProgressIndicator(), abortButton);
		vBox.setAlignment(Pos.CENTER);
		vBox.setPadding(new Insets(5));
		vBox.setSpacing(10);
		Scene scene = new Scene(vBox);
		alert.initModality(Modality.APPLICATION_MODAL);
		alert.setScene(scene);

		// alert.setHeaderText(resources.getString("alert.header"));
		// alert.setContentText(resources.getString("alert.content"));
		// alert.getButtonTypes().setAll(ButtonType.CANCEL);
		// alert.setGraphic(new ProgressIndicator());
	}

	@FXML
	private void solveButtonAction() {
		Task<List<ThistlethwaiteMove>> solverTask = new Task<List<ThistlethwaiteMove>>() {

			@Override
			protected List<ThistlethwaiteMove> call() {
				return model.solve();
			}

			@Override
			protected void succeeded() {
				model.setSolution(getValue());
				model.setIsSolved(true);
				model.setIsSolvable(false);
				solutionList.getSelectionModel().select(0);
				alert.hide();
				for (Node node : colourSelectionBox.getChildren()) {
					if (node instanceof ToggleButton) {
						((ToggleButton) node).setSelected(false);
					}
				}
			}

			@Override
			protected void failed() {
				alert.hide();
				Throwable exception = getException();
				if (exception instanceof CubeNotMappableException) {
					// TODO: Show error message.
					System.err.println("Exception while mapping Cube: " + exception.getMessage());
				} else if (exception instanceof CubeNotSolvableException) {
					// TODO: Show error message.
					System.err.println("Exception while solving Cube: " + exception.getMessage());
				} else {
					System.err.println("Something went wrong :(");
					exception.printStackTrace();
				}
			}

		};
		new Thread(solverTask).start();
		// Optional<ButtonType> alertResult = alert.showAndWait();
		alert.showAndWait();
		if (/* alertResult.isPresent() && */ solverTask.isRunning()) {
			solverTask.cancel();
		}

	}

	@FXML
	private void resetButtonAction() {
		model.reset();
	}

	@FXML
	private void scrambleButtonAction() {
		model.scrambleCube();
	}

}
