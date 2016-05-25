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
	private static final int[] FACETS_ORDER = { 4, 13, 22, 31, 40, 49, 39, 1, 5, 28, 19, 7, 3, 10, 41, 12, 37, 32, 23,
			30, 21, 14, 43, 52, 50, 34, 25, 46, 48, 16, 38, 0, 9, 36, 29, 2, 20, 8, 27, 18, 11, 6, 44, 51, 15, 42, 53,
			35, 26, 33, 47, 24, 45, 17 };
	private static final int[] WALL_X_OFFSETS = { 4, 0, 4, 8, 12, 4 };
	private static final int[] WALL_Y_OFFSETS = { 0, 4, 4, 4, 4, 8 };
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
	private ListView<Move> solutionList;

	@FXML
	private void initialize() {
		initializeCubeLayout();
		solveButton.disableProperty().bind(Bindings.not(model.isSolvableProperty()));
		solutionList.itemsProperty().bind(model.solutionProperty());
		solutionList.getSelectionModel().selectedIndexProperty().addListener((obs, oldVal, newVal) -> {
			System.err.println(oldVal + "\t" + newVal);
		});
		solutionList.setDisable(true);
	}

	private void initializeCubeLayout() {
		for (int face = 0; face < NUMBER_OF_FACES; ++face) {
			for (int row = 0; row < NUMBER_OF_COLUMNS; ++row) {
				for (int column = 0; column < NUMBER_OF_ROWS; ++column) {
					Button button = new Button();
					initializeButton(button, face, row, column);
					cubeLayout.add(button, WALL_X_OFFSETS[face] + column, WALL_Y_OFFSETS[face] + row);
				}
			}
		}
	}

	private void initializeButton(Button button, int wall, int row, int column) {
		button.setPrefSize(BUTTON_SIZE, BUTTON_SIZE);
		int facetNumber = FACETS_ORDER[NUMBER_OF_ROWS * NUMBER_OF_COLUMNS * wall + NUMBER_OF_COLUMNS * row + column];
		button.setOnAction(event -> model.changeColour(facetNumber));
		bindButtonToFacet(button, facetNumber);
	}

	private void bindButtonToFacet(Button button, int buttonFacetNumber) {
		button.styleProperty()
				.bind(Bindings.concat(
						"-fx-border-color: black; -fx-border-radius: 4px; -fx-background-insets: 2; -fx-background-radius: 4px; -fx-background-color: ",
						model.getFacetColour(buttonFacetNumber)));
	}

	@FXML
	private void solveButtonAction() {
		model.solve();
		cubeLayout.setDisable(true);
		solutionList.setDisable(false);
	}

	@FXML
	private void resetButtonAction() {
		model.reset();
		cubeLayout.setDisable(false);
		solutionList.setDisable(true);
		model.getSolution().clear();
	}

}
