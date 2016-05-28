package pl.konar.rubikscube.model.cube;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import pl.konar.rubikscube.model.colour.Colour;

public class ObservableCube {

	private static final int[][][] ROTATE_PERMUTATIONS = {
			{ { 34, 52, 30, 14 }, { 50, 25, 21, 23 }, { 41, 53, 38, 1 }, { 42, 36, 5, 7 }, { 35, 46, 39, 32 } },
			{ { 34, 52, 30, 14 }, { 50, 25, 21, 23 }, { 41, 53, 38, 1 }, { 42, 36, 5, 7 }, { 35, 46, 39, 32 } },
			{ { 34, 52, 30, 14 }, { 50, 25, 21, 23 }, { 41, 53, 38, 1 }, { 42, 36, 5, 7 }, { 35, 46, 39, 32 } },
			{ { 34, 52, 30, 14 }, { 50, 25, 21, 23 }, { 41, 53, 38, 1 }, { 42, 36, 5, 7 }, { 35, 46, 39, 32 } },
			{ { 34, 52, 30, 14 }, { 50, 25, 21, 23 }, { 41, 53, 38, 1 }, { 42, 36, 5, 7 }, { 35, 46, 39, 32 } },
			{ { 14, 30, 52, 34 }, { 23, 21, 25, 50 }, { 1, 38, 53, 41 }, { 7, 5, 36, 42 }, { 32, 39, 46, 35 } } };
	private static final int[] FACETS_ORDER = { 31, 7, 35, 12, 0, 8, 41, 11, 37, 32, 13, 40, 15, 1, 21, 44, 29, 53, 39,
			10, 36, 20, 2, 18, 51, 26, 48, 38, 9, 34, 19, 3, 17, 49, 25, 47, 33, 6, 30, 16, 4, 14, 45, 22, 42, 52, 27,
			50, 28, 5, 24, 43, 23, 46 };

	private ListProperty<Colour> facets = new SimpleListProperty<>(FXCollections.observableArrayList());

	public ObservableCube() {
		for (int i = 0; i < CubeConstants.NUMBER_OF_FACETS; ++i) {
			facets.add(Colour.TRANSPARENT);
		}
	}

	public ListProperty<Colour> facetsProperty() {
		return facets;
	}
	
	public Colour getColour(int facetNumber) {
		return facets.get(facetNumber);
	}
	
	public void setColour(int facetNumber, Colour colour) {
		facets.set(facetNumber, colour);
	}
	
	public void setNextColour(int facetNumber) {
		setColour(facetNumber, getColour(facetNumber).getNextColour());
	}

	public void reset() {
		for (int i = 0; i < CubeConstants.NUMBER_OF_FACETS; ++i) {
			setColour(i, Colour.TRANSPARENT);
		}
	}

	public void fill() {
		for (int facetNumber = 0; facetNumber < CubeConstants.NUMBER_OF_FACETS; ++facetNumber) {
			setColour(FACETS_ORDER[facetNumber], Colour.values()[facetNumber / CubeConstants.NUMBER_OF_FACETS_PER_FACE + 1]);
		}
	}
	
	public int getNthFacetNumber(int index) {
		return FACETS_ORDER[index];
	}

	public void applyMove(Move move) {
		for (int i = 0; i < move.getAngle(); ++i) {
			for (int[] permutation : ROTATE_PERMUTATIONS[move.getFace().ordinal()]) {
				Colour tmp = getColour(permutation[0]);
				for (int n = 0; n < permutation.length; ++n) {
					setColour(permutation[n], getColour(permutation[(n + 1) % permutation.length]));
				}
				setColour(permutation[permutation.length - 1], tmp);
			}
		}
	}
	
}
