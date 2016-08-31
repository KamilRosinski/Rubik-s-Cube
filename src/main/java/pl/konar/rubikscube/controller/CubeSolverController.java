package pl.konar.rubikscube.controller;

import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.beans.binding.Bindings;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Shape;
import javafx.util.Callback;
import pl.konar.rubikscube.model.colour.Colour;
import pl.konar.rubikscube.model.controller.shape.CubeFacet;
import pl.konar.rubikscube.model.cube.Angle;
import pl.konar.rubikscube.model.cube.CubeConstants;
import pl.konar.rubikscube.model.cube.Face;
import pl.konar.rubikscube.model.cube.SolverModel;
import pl.konar.rubikscube.model.cube.ThistlethwaiteMove;
import pl.konar.rubikscube.model.cube.exception.CubeNotMappableException;
import pl.konar.rubikscube.model.cube.exception.CubeNotSolvableException;

public class CubeSolverController {

	// private static final double BUTTON_SIZE = 40;
	private static final int[] FACE_X_OFFSETS = { 4, 12, 8, 4, 0, 4 };
	private static final int[] FACE_Y_OFFSETS = { 0, 4, 4, 4, 4, 8 };

	private SolverModel model = new SolverModel();

	private Alert alert = new Alert(AlertType.INFORMATION);

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
		for (Colour colour : Colour.values()) {
			RadioButton button = new RadioButton();
			button.setOnAction(event -> model.setCurrentColour(colour));
			button.setSelected(Colour.TRANSPARENT == colour);
			button.setToggleGroup(colourGroup);
			button.setStyle("-fx-color: " + colour);
			Shape shape = new CubeFacet();
			button.setShape(shape);
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
		// button.setPrefSize(BUTTON_SIZE, BUTTON_SIZE);
		int facetNumber = model.getCubeNthFacetNumber(CubeConstants.NUMBER_OF_FACETS_PER_FACE * wall
				+ CubeConstants.NUMBER_OF_COLUMNS_PER_FACE * row + column);
		button.setOnAction(event -> {
			model.changeColour(facetNumber);
		});
		bindButtonToFacet(button, facetNumber);
	}

	private void bindButtonToFacet(Button button, int buttonFacetNumber) {
		button.styleProperty()
				.bind(Bindings.concat(
						"-fx-border-color: black; -fx-border-radius: 4px; -fx-background-insets: 2; -fx-background-radius: 4px; -fx-background-color: ",
						Bindings.valueAt(model.cubeFacetsProperty(), buttonFacetNumber)));
	}

	private void initializeSolveButton() {
		solveButton.disableProperty().bind(Bindings.not(model.isSolvableProperty()));
	}

	private void initializeSolutionList() {
		solutionList.disableProperty().bind(Bindings.not(model.isSolvedProperty()));
		solutionList.itemsProperty().bind(model.solutionProperty());
		solutionList.setCellFactory(new Callback<ListView<ThistlethwaiteMove>, ListCell<ThistlethwaiteMove>>() {

			@Override
			public ListCell<ThistlethwaiteMove> call(ListView<ThistlethwaiteMove> param) {
				return new ListCell<ThistlethwaiteMove>() {

					@Override
					protected void updateItem(ThistlethwaiteMove move, boolean empty) {
						super.updateItem(move, empty);
						if (empty) {
							setText("");
						} else {
							String text = "";
							Colour colour = Colour.TRANSPARENT;
							if (move == null) {
								text = resources.getString("move.empty");
							} else {
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
			}
		});
		solutionList.getSelectionModel().selectedIndexProperty().addListener((obs, oldVal, newVal) -> {
			model.applyPartialSolution(oldVal.intValue(), newVal.intValue());
		});
	}

	private void initializeFillButton() {
		scrambleButton.disableProperty().bind(model.isSolvedProperty());
	}

	private void initializeAlert() {
		alert.setTitle(resources.getString("alert.title"));
		alert.setHeaderText(resources.getString("alert.header"));
		alert.setContentText(resources.getString("alert.content"));
		alert.getButtonTypes().setAll(ButtonType.CANCEL);
		alert.setGraphic(new ProgressIndicator());
	}

	@FXML
	private void solveButtonAction() {
		Task<List<ThistlethwaiteMove>> solverTask = new Task<List<ThistlethwaiteMove>>() {
			// Task<Void> solverTask = new Task<Void>() {

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
		Optional<ButtonType> alertResult = alert.showAndWait();
		if (alertResult.isPresent() && solverTask.isRunning()) {
			solverTask.cancel();
		}

	}

	@FXML
	private void resetButtonAction() {
		model.resetCube();
	}

	@FXML
	private void scrambleButtonAction() {
		model.scrambleCube();
	}

}
