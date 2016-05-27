package pl.konar.rubikscube.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import pl.konar.rubikscube.model.cube.Move;
import pl.konar.rubikscube.model.cube.ObservableCube;

public class CubeSolverController {

	private static final double BUTTON_SIZE = 40;
	private static final int NUMBER_OF_ROWS = 3;
	private static final int NUMBER_OF_COLUMNS = 3;
	private static final int NUMBER_OF_FACES = 6;
	private static final int[] FACE_X_OFFSETS = { 4, 0, 4, 8, 12, 4 };
	private static final int[] FACE_Y_OFFSETS = { 0, 4, 4, 4, 4, 8 };
	private ObservableCube model = new ObservableCube();

	@FXML
	private URL location;

	@FXML
	private ResourceBundle resources;

	@FXML
	private GridPane cubeLayout;

	@FXML
	private Button solveButton;

	@FXML
	private Button fillButton;

	@FXML
	private ListView<Move> solutionList;

	@FXML
	private void initialize() {
		initializeCubeLayout();
		initializeSolveButton();
		initializeSolutionList();
		initializeFillButton();
	}

	private void initializeCubeLayout() {
		cubeLayout.disableProperty().bind(model.isSolvedProperty());
		for (int face = 0; face < NUMBER_OF_FACES; ++face) {
			for (int row = 0; row < NUMBER_OF_ROWS; ++row) {
				for (int column = 0; column < NUMBER_OF_COLUMNS; ++column) {
					Button button = new Button();
					initializeFacetButton(button, face, row, column);
					cubeLayout.add(button, FACE_X_OFFSETS[face] + column, FACE_Y_OFFSETS[face] + row);
				}
			}
		}
	}

	private void initializeFacetButton(Button button, int wall, int row, int column) {
		button.setPrefSize(BUTTON_SIZE, BUTTON_SIZE);
		int facetNumber = model
				.getNthFacetNumber(NUMBER_OF_ROWS * NUMBER_OF_COLUMNS * wall + NUMBER_OF_COLUMNS * row + column);
		button.setOnAction(event -> model.changeColour(facetNumber));
		bindButtonToFacet(button, facetNumber);
	}

	private void bindButtonToFacet(Button button, int buttonFacetNumber) {
		button.styleProperty()
		.bind(Bindings.concat(
				"-fx-border-color: black; -fx-border-radius: 4px; -fx-background-insets: 2; -fx-background-radius: 4px; -fx-background-color: ",
				Bindings.valueAt(model.facetsProperty(), buttonFacetNumber)));
	}
	
	private void initializeSolveButton() {
		solveButton.disableProperty().bind(Bindings.not(model.isSolvableProperty()));
	}

	private void initializeSolutionList() {
		solutionList.disableProperty().bind(Bindings.not(model.isSolvedProperty()));
		solutionList.itemsProperty().bind(model.solutionProperty());
		solutionList.getSelectionModel().selectedIndexProperty().addListener((obs, oldVal, newVal) -> {
			if (!newVal.equals(-1)) {
				model.applyPartialSolution(oldVal.equals(-1) ? 0 : oldVal.intValue(), newVal.intValue());
			}
		});
	}

	private void initializeFillButton() {
		fillButton.disableProperty().bind(model.isSolvedProperty());
	}

	@FXML
	private void solveButtonAction() {
		model.solve();
		solutionList.getSelectionModel().select(0);
	}

	@FXML
	private void resetButtonAction() {
		model.reset();
	}

	@FXML
	private void fillBUttonAction() {
		model.fill();
	}

}
