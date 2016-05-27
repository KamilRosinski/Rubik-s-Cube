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

public class SolverModel {

	private static final int[][][] PERMUTATIONS = {
			{ { 34, 52, 30, 14 }, { 50, 25, 21, 23 }, { 41, 53, 38, 1 }, { 42, 36, 5, 7 }, { 35, 46, 39, 32 } },
			{ { 34, 52, 30, 14 }, { 50, 25, 21, 23 }, { 41, 53, 38, 1 }, { 42, 36, 5, 7 }, { 35, 46, 39, 32 } },
			{ { 34, 52, 30, 14 }, { 50, 25, 21, 23 }, { 41, 53, 38, 1 }, { 42, 36, 5, 7 }, { 35, 46, 39, 32 } },
			{ { 34, 52, 30, 14 }, { 50, 25, 21, 23 }, { 41, 53, 38, 1 }, { 42, 36, 5, 7 }, { 35, 46, 39, 32 } },
			{ { 34, 52, 30, 14 }, { 50, 25, 21, 23 }, { 41, 53, 38, 1 }, { 42, 36, 5, 7 }, { 35, 46, 39, 32 } },
			{ { 14, 30, 52, 34 }, { 23, 21, 25, 50 }, { 1, 38, 53, 41 }, { 7, 5, 36, 42 }, { 32, 39, 46, 35 } } };

	private ObservableCube cube = new ObservableCube();
	private ListProperty<Move> solution = new SimpleListProperty<>(FXCollections.observableArrayList());
	private BooleanProperty isSolved = new SimpleBooleanProperty(false);
	private BooleanProperty isSolvable = new SimpleBooleanProperty(false);

	public void changeColour(int facetNumber) {
		setNextColour(facetNumber);
		checkIfSolvable();
	}

	private void setNextColour(int facetNumber) {
		cube.setNextColour(facetNumber);
	}

	private void checkIfSolvable() {
		isSolvable.set(true);
	}

	public void resetCube() {
		cube.reset();
		solution.clear();
		isSolvable.set(false);
		isSolved.set(false);
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

	public ListProperty<Colour> cubeFacetsProperty() {
		return cube.facetsProperty();
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

	private void applyMove(Move move) {
		for (int i = 0; i < move.getAngle(); ++i) {
			for (int[] permutation : PERMUTATIONS[move.getFace().ordinal()]) {
				Colour tmp = cube
						.getColour(permutation[0]) /*
													 * facets.get(permutation[0])
													 *//* .get() */;
				for (int n = 0; n < permutation.length; ++n) {
					cube.setColour(permutation[n], cube.getColour(permutation[(n + 1)
							% permutation.length])/* .get() */);
				}
				cube.setColour(permutation[permutation.length - 1], tmp);
			}
		}
	}

	public void fillCube() {
		cube.fill();
		isSolvable.set(true);
	}

	public int getCubeNthFacetNumber(int index) {
		return cube.getNthFacetNumber(index);
	}

}
