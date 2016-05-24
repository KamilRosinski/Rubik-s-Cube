package pl.konar.rubikscube.model;

import java.util.ArrayList;
import java.util.List;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

public class RubiksCubeModel {

	private static final int NUMBER_OF_FACETS_PER_FACE = 9;
	// private ObservableList<ObservableStringValue> colours =
	// FXCollections.observableArrayList(new
	// ArrayList<ObservableStringValue>());
	// private ListProperty<ObservableStringValue> facets = new
	// SimpleListProperty<ObservableStringValue>();

	private List<ObjectProperty<Colour>> facetColours = new ArrayList<>();

	public RubiksCubeModel() {
		for (Colour colour : Colour.values()) {
			for (int i = 0; i < NUMBER_OF_FACETS_PER_FACE; ++i) {
				facetColours.add(new SimpleObjectProperty<Colour>(colour));
//				facetColours.add(new SimpleStringProperty(colour.toString()));
				// colours.add(new
				// SimpleStringProperty(colour.getColourName()));
			}
		}
		// facets.set(colours);
	}

	public ObjectProperty<Colour> getFacetColour(int index) {
		return facetColours.get(index);
	}

	// public ObservableList<ObservableStringValue> getFacets() {
	// return facets.get();
	// }

	// public ListProperty<ObservableStringValue> facetsProperty() {
	// return facets;
	// }

	public void setNextColour(int index) {
		facetColours.get(index).set(facetColours.get(index).get().getNextColour());
//		ObservableStringValue oldColour = facetColours.get(index);
//		String newColour = Colour.valueOf(oldColour.get()).getNextColour().toString();
//		facetColours.get(index).set(newColour);
//		System.err.println(facetColours.get(0));
		// colours.set(index,
		// Colour.valueOf(colours.get(index).toString().toUpperCase()).getNextColour().getColourName());
	}

}
