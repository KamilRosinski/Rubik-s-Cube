package pl.konar.rubikscube.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import pl.konar.rubikscube.model.RubiksCubeModel;

public class CubeSolverController {

	private static final double BUTTON_SIZE = 30;
	private static final int NUMBER_OF_ROWS = 3;
	private static final int NUMBER_OF_COLUMNS = 3;
	private static final int NUMBER_OF_WALLS = 6;
	private static final int[] FACETS_ORDER = { 5, 14, 23, 32, 41, 50, 38, 2, 6, 29, 20, 8, 4, 11, 42, 13, 40, 33, 24,
			31, 22, 15, 44, 53, 51, 35, 26, 47, 49, 17, 39, 1, 10, 37, 30, 3, 21, 9, 28, 19, 12, 7, 45, 52, 16, 43, 54,
			36, 27, 34, 48, 25, 46, 18 };
	private static final int[] WALL_X_OFFSETS = { 1, 0, 1, 2, 3, 1 };
	private static final int[] WALL_Y_OFFSETS = { 0, 1, 1, 1, 1, 2 };
	private RubiksCubeModel model = new RubiksCubeModel();

	@FXML
	private URL location;

	@FXML
	private ResourceBundle resources;

	@FXML
	private GridPane cubeLayout;

	@FXML
	private void initialize() {
		for (int wall = 0; wall < NUMBER_OF_WALLS; ++wall) {
			for (int row = 0; row < NUMBER_OF_COLUMNS; ++row) {
				for (int column = 0; column < NUMBER_OF_ROWS; ++column) {
					Button button = new Button();
					initializeButton(button, wall, row, column);
					cubeLayout.add(button, NUMBER_OF_ROWS * WALL_X_OFFSETS[wall] + column,
							NUMBER_OF_COLUMNS * WALL_Y_OFFSETS[wall] + row);
				}
			}
		}
	}

	private void initializeButton(Button button, int wall, int row, int column) {
		button.setMinSize(10, 10);
		button.setMaxSize(50, 50);
		button.setPrefSize(BUTTON_SIZE, BUTTON_SIZE);
		int facetNumber = FACETS_ORDER[NUMBER_OF_ROWS * NUMBER_OF_COLUMNS * wall
				+ NUMBER_OF_COLUMNS * row + column] - 1;
		button.setOnAction(event -> model.setNextColour(facetNumber));
		bindButtonToFacet(button, facetNumber);
	}

	private void bindButtonToFacet(Button button, int buttonFacetNumber) {
		button.styleProperty()
				.bind(Bindings.concat(
						"-fx-border-color: black; -fx-border-radius: 4px; -fx-background-insets: 2; -fx-background-radius: 4px; -fx-background-color: ",
						model.getFacetColour(buttonFacetNumber)));
	}

}
