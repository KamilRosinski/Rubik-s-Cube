package pl.konar.rubikscube.model.cube;

import java.util.List;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import pl.konar.rubikscube.model.colour.Colour;

public class ObservableCube {

	private static final int[][][] ROTATE_PERMUTATIONS = {
			{ { 39, 51, 48, 36 }, { 10, 20, 26, 18 }, { 41, 53, 50, 38 }, { 11, 21, 27, 19 }, { 37, 40, 52, 49 } }, // F
			{ { 33, 45, 42, 30 }, { 6, 16, 22, 14 }, { 34, 46, 44, 31 }, { 17, 23, 15, 7 }, { 47, 43, 32, 35 } }, // B
			{ { 32, 44, 53, 40 }, { 13, 15, 29, 21 }, { 30, 43, 51, 41 }, { 14, 28, 20, 12 }, { 42, 52, 39, 31 } }, // L
			{ { 38, 49, 47, 34 }, { 9, 19, 25, 17 }, { 36, 50, 45, 35 }, { 18, 24, 16, 8 }, { 48, 46, 33, 37 } }, // R
			{ { 31, 41, 37, 35 }, { 12, 11, 8, 7 }, { 32, 39, 38, 33 }, { 13, 10, 9, 6 }, { 40, 36, 34, 30 } }, // U
			{ { 52, 43, 46, 50 }, { 28, 23, 24, 27 }, { 53, 42, 47, 48 }, { 29, 22, 25, 26 }, { 44, 45, 49, 51 } } }; // D
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
			setColour(FACETS_ORDER[facetNumber],
					Colour.values()[facetNumber / CubeConstants.NUMBER_OF_FACETS_PER_FACE + 1]);
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

	public List<Colour> facetslist() {
		return facets.get();
	}

}
