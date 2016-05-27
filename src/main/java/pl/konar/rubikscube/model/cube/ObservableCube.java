package pl.konar.rubikscube.model.cube;

import java.util.ArrayList;
import java.util.List;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import pl.konar.rubikscube.model.colour.Colour;
import pl.konar.rubikscube.model.solver.ThistlethwaiteSolver;

public class ObservableCube {

	private static final int NUMBER_OF_FACETS = 54;
	private static final int[] FACETS_ORDER = { 31, 7, 35, 12, 0, 8, 41, 11, 37, 32, 13, 40, 15, 1, 21, 44, 29, 53, 39,
			10, 36, 20, 2, 18, 51, 26, 48, 38, 9, 34, 19, 3, 17, 49, 25, 47, 33, 6, 30, 16, 4, 14, 45, 22, 42, 52, 27,
			50, 28, 5, 24, 43, 23, 46 };

	private CubeSolver solver = new ThistlethwaiteSolver();
	private ListProperty<Colour> facets = new SimpleListProperty<>(FXCollections.observableArrayList());
	private BooleanProperty isSolved = new SimpleBooleanProperty(false);
	private BooleanProperty isSolvable = new SimpleBooleanProperty(false);
	private ListProperty<Move> solution = new SimpleListProperty<>(FXCollections.observableArrayList());

	public ObservableCube() {
		for (int i = 0; i < NUMBER_OF_FACETS; ++i) {
			facets.add(Colour.TRANSPARENT);
		}
	}

	public void changeColour(int facetNumber) {
		setNextColour(facetNumber);
		checkIfSolvable();
	}

	public int getNthFacetNumber(int index) {
		return FACETS_ORDER[index];
	}

	private void setNextColour(int index) {
		facets.set(index, facets.get(index).getNextColour());
	}

	private void checkIfSolvable() {
		isSolvable.set(true);
	}

	public void reset() {
		for (int i = 0; i < NUMBER_OF_FACETS; ++i) {
			facets.set(i, Colour.TRANSPARENT);
		}
		isSolvable.set(false);
		isSolved.set(false);
		solution.clear();
	}

	public void solve() {
		solution.clear();
		solution.add(Move.E);
		for (Move move : ThistlethwaiteSolver.solve()) {
			solution.add(move);
		}
		isSolved.set(true);
		isSolvable.set(false);
	}

	public ListProperty<Colour> facetsProperty() {
		return facets;
	}

	public Colour getFacetColour(int index) {
		return facets.get(index);
	}

	public BooleanProperty isSolvedProperty() {
		return isSolved;
	}

	public BooleanProperty isSolvableProperty() {
		return isSolvable;
	}

	public ListProperty<Move> solutionProperty() {
		return solution;
	}

	public void applyPartialSolution(int oldIndex, int newIndex) {
		List<Move> result = new ArrayList<>();
		if (oldIndex < newIndex) {
			for (int i = oldIndex + 1; i <= newIndex; ++i) {
				result.add(solution.get(i));
			}
		} else {
			for (int i = oldIndex; i > newIndex; --i) {
				result.add(solution.get(i).inverse());
			}
		}
		applyMoves(result);
	}

	private void applyMoves(List<Move> moves) {
		for (Move move : moves) {
			applyMove(move);
		}
	}

	private static final int[][][] PERMUTATIONS = {
			{ { 34, 52, 30, 14 }, { 50, 25, 21, 23 }, { 41, 53, 38, 1 }, { 42, 36, 5, 7 }, { 35, 46, 39, 32 } },
			{ { 34, 52, 30, 14 }, { 50, 25, 21, 23 }, { 41, 53, 38, 1 }, { 42, 36, 5, 7 }, { 35, 46, 39, 32 } },
			{ { 34, 52, 30, 14 }, { 50, 25, 21, 23 }, { 41, 53, 38, 1 }, { 42, 36, 5, 7 }, { 35, 46, 39, 32 } },
			{ { 34, 52, 30, 14 }, { 50, 25, 21, 23 }, { 41, 53, 38, 1 }, { 42, 36, 5, 7 }, { 35, 46, 39, 32 } },
			{ { 34, 52, 30, 14 }, { 50, 25, 21, 23 }, { 41, 53, 38, 1 }, { 42, 36, 5, 7 }, { 35, 46, 39, 32 } },
			{ { 14, 30, 52, 34 }, { 23, 21, 25, 50 }, { 1, 38, 53, 41 }, { 7, 5, 36, 42 }, { 32, 39, 46, 35 } } };

	private void applyMove(Move move) {
		for (int i = 0; i < move.getAngle(); ++i) {
			for (int[] permutation : PERMUTATIONS[move.getFace().ordinal()]) {
				Colour tmp = facets.get(permutation[0])/* .get() */;
				for (int n = 0; n < permutation.length; ++n) {
					facets.set(permutation[n], facets.get(permutation[(n + 1)
							% permutation.length])/* .get() */);
				}
				facets.set(permutation[permutation.length - 1], tmp);
			}
		}
	}

	public void fill() {
		for (int face = 0; face < NUMBER_OF_FACETS; ++face) {
			facets.set(FACETS_ORDER[face], Colour.values()[face / 9 + 1]);
		}
		isSolvable.set(true);
	}

}
