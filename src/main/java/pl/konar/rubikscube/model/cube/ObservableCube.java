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
		isSolved.set(false);
		solution.get().clear();
	}

	public void solve() {
		solution.setAll(solver.solve());
		solution.add(0, Move.E);
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
			for (int i = oldIndex - 1; i >= newIndex; --i) {
				result.add(solution.get(i));
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
		System.err.println(move);
	}

}
