package pl.konar.rubikscube.model.cube;

import java.util.ArrayList;
import java.util.List;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import pl.konar.rubikscube.model.colour.Colour;

public class ObservableCube {

	private static final int NUMBER_OF_FACETS = 54;
	private List<ObjectProperty<Colour>> facetColours = new ArrayList<>();
	private BooleanProperty isSolvable = new SimpleBooleanProperty(false);

	public ObservableCube() {
		for (int i = 0; i < NUMBER_OF_FACETS; ++i) {
			facetColours.add(new SimpleObjectProperty<Colour>(Colour.TRANSPARENT));
		}
	}

	public void changeColour(int facetNumber) {
		setNextColour(facetNumber);
		checkIfSolvable();
	}
	
	private void setNextColour(int index) {
		facetColours.get(index).set(facetColours.get(index).get().getNextColour());
	}
	
	private void checkIfSolvable() {
		isSolvable.set(true);
	}
	
	public void reset() {
		for (ObjectProperty<Colour> facetColour : facetColours) {
			facetColour.set(Colour.TRANSPARENT);
		}
		isSolvable.set(false);
	}

	public ObjectProperty<Colour> getFacetColour(int index) {
		return facetColours.get(index);
	}

	public BooleanProperty isSolvableProperty() {
		return isSolvable;
	}

}
