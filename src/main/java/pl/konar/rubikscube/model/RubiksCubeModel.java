package pl.konar.rubikscube.model;

import java.util.ArrayList;
import java.util.List;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

public class RubiksCubeModel {

	private static final int NUMBER_OF_FACETS = 54;
	private List<ObjectProperty<Colour>> facetColours = new ArrayList<>();

	public RubiksCubeModel() {
		for (int i = 0; i < NUMBER_OF_FACETS; ++i) {
			facetColours.add(new SimpleObjectProperty<Colour>(Colour.TRANSPARENT));
		}
	}

	public ObjectProperty<Colour> getFacetColour(int index) {
		return facetColours.get(index);
	}

	public void setNextColour(int index) {
		facetColours.get(index).set(facetColours.get(index).get().getNextColour());
	}

}
