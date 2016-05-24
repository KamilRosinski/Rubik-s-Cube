package pl.konar.rubikscube.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import pl.konar.rubikscube.model.RubiksCubeModel;

public class CubeSolverController {

	private RubiksCubeModel model = new RubiksCubeModel();

	@FXML
	private URL location;

	@FXML
	private ResourceBundle resources;

	@FXML
	private Label myLabel;

	@FXML
	private Button myButton;

	@FXML
	private void initialize() {
//		myButton.setStyle("-fx-background-color: TRANSPARENT");
		myButton.styleProperty().bind(Bindings.concat("-fx-background-color: ", model.getFacetColour(0)));
	}

	@FXML
	public void buttonAction() {
		model.setNextColour(0);
	}

}
