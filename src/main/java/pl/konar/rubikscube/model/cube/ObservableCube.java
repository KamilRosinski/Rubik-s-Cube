package pl.konar.rubikscube.model.cube;

import java.util.ArrayList;
import java.util.List;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ListProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import pl.konar.rubikscube.model.colour.Colour;
import pl.konar.rubikscube.model.solver.CubeSolver;
import pl.konar.rubikscube.model.solver.impl.ThistlethwaiteSolver;

public class ObservableCube {

	private static final int NUMBER_OF_FACETS = 54;
	private static final int[] FACETS_ORDER = { 31, 7, 35, 12, 0, 8, 41, 11, 37, 32, 13, 40, 15, 1, 21, 44, 29, 53, 39,
			10, 36, 20, 2, 18, 51, 26, 48, 38, 9, 34, 19, 3, 17, 49, 25, 47, 33, 6, 30, 16, 4, 14, 45, 22, 42, 52, 27,
			50, 28, 5, 24, 43, 23, 46 };
	private CubeSolver solver = new ThistlethwaiteSolver();
	private List<ObjectProperty<Colour>> facetColours = new ArrayList<>();
	private BooleanProperty isSolved = new SimpleBooleanProperty(false);
	private BooleanProperty isSolvable = new SimpleBooleanProperty(false);
	private ListProperty<Move> solution = new SimpleListProperty<>(FXCollections.observableArrayList());

	public ObservableCube() {
		for (int i = 0; i < NUMBER_OF_FACETS; ++i) {
			facetColours.add(new SimpleObjectProperty<Colour>(Colour.TRANSPARENT));
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
		facetColours.get(index).set(facetColours.get(index).get().getNextColour());
		System.err.println("==========================================");
		for (ObjectProperty<Colour> colour : facetColours) {
			System.err.println(colour);
		}
		System.err.println("==========================================");
	}

	private void checkIfSolvable() {
		isSolvable.set(true);
	}

	public void reset() {
		for (ObjectProperty<Colour> facetColour : facetColours) {
			facetColour.set(Colour.TRANSPARENT);
		}
		isSolvable.set(false);
		isSolved.set(false);
		solution.get().clear();
	}

	public void solve() {
		solution.clear();
		solution.add(Move.E);
		for (Move move : solver.solve()) {
			solution.add(move);
		}
		isSolved.set(true);
		isSolvable.set(false);
	}

	public ObjectProperty<Colour> getFacetColour(int index) {
		return facetColours.get(index);
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

	public ObservableList<Move> getSolution() {
		return solution.get();
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
				Colour tmp = facetColours.get(permutation[0]).get();
				for (int n = 0; n < permutation.length; ++n) {
					facetColours.get(permutation[n])
							.set(facetColours.get(permutation[(n + 1) % permutation.length]).get());
				}
				facetColours.get(permutation[permutation.length - 1]).set(tmp);
			}
		}
	}

	public void fill() {
		for (int face = 0; face < NUMBER_OF_FACETS; ++face) {
			facetColours.get(FACETS_ORDER[face]).set(Colour.values()[face / 9 + 1]);
		}
		isSolvable.set(true);
	}

}
