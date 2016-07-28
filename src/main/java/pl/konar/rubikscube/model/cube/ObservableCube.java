package pl.konar.rubikscube.model.cube;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import pl.konar.rubikscube.model.colour.Colour;
import pl.konar.rubikscube.model.cube.exception.WrongNumberOfFacetsException;

public class ObservableCube {

	private static final int[][][] ROTATE_PERMUTATIONS = {
			{ { 39, 51, 48, 36 }, { 10, 20, 26, 18 }, { 41, 53, 50, 38 }, { 11, 21, 27, 19 }, { 37, 40, 52, 49 } }, // F
			{ { 33, 45, 42, 30 }, { 6, 16, 22, 14 }, { 34, 46, 43, 31 }, { 17, 23, 15, 7 }, { 47, 44, 32, 35 } }, // B
			{ { 32, 43, 53, 40 }, { 13, 15, 29, 21 }, { 30, 44, 51, 41 }, { 14, 28, 20, 12 }, { 42, 52, 39, 31 } }, // L
			{ { 38, 49, 47, 34 }, { 9, 19, 25, 17 }, { 36, 50, 45, 35 }, { 18, 24, 16, 8 }, { 48, 46, 33, 37 } }, // R
			{ { 31, 41, 37, 35 }, { 12, 11, 8, 7 }, { 32, 39, 38, 33 }, { 13, 10, 9, 6 }, { 40, 36, 34, 30 } }, // U
			{ { 52, 44, 46, 50 }, { 28, 23, 24, 27 }, { 53, 42, 47, 48 }, { 29, 22, 25, 26 }, { 43, 45, 49, 51 } } // D
	};

	private static final int[] FACETS_ORDER = { //
			31, 7, 35, 12, 0, 8, 41, 11, 37, // 0
			33, 6, 30, 16, 1, 14, 45, 22, 42, // 1
			38, 9, 34, 19, 2, 17, 49, 25, 47, // 2
			39, 10, 36, 20, 3, 18, 51, 26, 48, // 3
			32, 13, 40, 15, 4, 21, 43, 29, 53, // 4
			52, 27, 50, 28, 5, 24, 44, 23, 46 // 5
	};

	private ListProperty<Colour> facets = new SimpleListProperty<>(FXCollections.observableArrayList());

	public ObservableCube() {
		reset();
	}

	public ObservableCube(List<Colour> colours) {
		if (colours.size() != CubeConstants.NUMBER_OF_FACETS) {
			throw new WrongNumberOfFacetsException(
					"Cube must have " + CubeConstants.NUMBER_OF_FACETS + " facets, has " + colours.size() + ".");
		}
		facets.addAll(colours);
	}

	public ListProperty<Colour> facetsProperty() {
		return facets;
	}

	public Colour getColour(int facetNumber) {
		return facets.get(facetNumber);
	}

	public List<Colour> getColours() {
		return facets.get();
	}

	public void setColour(int facetNumber, Colour colour) {
		facets.set(facetNumber, colour);
	}

	public void setNextColour(int facetNumber) {
		setColour(facetNumber, getColour(facetNumber).getNextColour());
	}

	public void reset() {
		facets.setAll(Collections.nCopies(CubeConstants.NUMBER_OF_FACETS, Colour.TRANSPARENT));
	}

	public void fill() {
		fill(Colour.getAllNonTransparentList());
	}

	public void fill(List<Colour> centers) {
		for (int index = 0; index < CubeConstants.NUMBER_OF_FACETS; ++index) {
			setColour(FACETS_ORDER[index], centers.get(index / CubeConstants.NUMBER_OF_FACETS_PER_FACE));
		}
	}

	public int getNthFacetNumber(int index) {
		return FACETS_ORDER[index];
	}

	public void applyMoves(List<Move> moves) {
		for (Move move : moves) {
			applyMove(move);
		}
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

	public List<Colour> getCenterColours() {
		return new ArrayList<>(facets.subList(0, CubeConstants.NUMBER_OF_FACES));
	}

}
