package pl.konar.rubikscube.application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Startup extends Application {

	private static final String BUNDLE_PATH = "pl/konar/rubikscube/bundle/base";
	private static final String FXML_PATH = "pl/konar/rubikscube/view/solver.fxml";
	private static final String CSS_PATH = "pl/konar/rubikscube/css/standard.css";

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws IOException {
		URL resource = getClass().getClassLoader().getResource(FXML_PATH);
		ResourceBundle bundle = ResourceBundle.getBundle(BUNDLE_PATH);
		primaryStage.setTitle(bundle.getString("application.title"));
		Parent root = FXMLLoader.load(resource, bundle);
		Scene scene = new Scene(root);
		scene.getStylesheets().add(CSS_PATH);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
