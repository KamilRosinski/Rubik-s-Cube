package pl.konar.rubikscube.model.cube;

import java.util.ArrayList;
import java.util.List;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import pl.konar.rubikscube.model.colour.Colour;
import pl.konar.rubikscube.model.cube.mapper.CubeMapper;
import pl.konar.rubikscube.model.solver.ThistlethwaiteSolver;

public class SolverModel {

	private ObservableCube cube = new ObservableCube();
	private ListProperty<ThistlethwaiteMove> solution = new SimpleListProperty<>(FXCollections.observableArrayList());
	private BooleanProperty isSolved = new SimpleBooleanProperty(false);
	private BooleanProperty isSolvable = new SimpleBooleanProperty(false);

	public void changeColour(int facetNumber) {
		setNextColour(facetNumber);
		checkIfSolvable();
	}

	private void checkIfSolvable() {
		isSolvable.set(CubeMapper.isMappable(cube) && ThistlethwaiteSolver.isSolvable(CubeMapper.map(cube)));
	}

	private void setNextColour(int facetNumber) {
		cube.setNextColour(facetNumber);
	}

	public void resetCube() {
		cube.reset();
		solution.clear();
		isSolvable.set(false);
		isSolved.set(false);
	}

	public List<ThistlethwaiteMove> solve() {
		return ThistlethwaiteSolver.solve(CubeMapper.map(cube));
	}

	public ListProperty<Colour> cubeFacetsProperty() {
		return cube.facetsProperty();
	}

	public BooleanProperty isSolvedProperty() {
		return isSolved;
	}

	public void setIsSolved(boolean isSolved) {
		this.isSolved.set(isSolved);
	}

	public BooleanProperty isSolvableProperty() {
		return isSolvable;
	}

	public void setIsSolvable(boolean isSolvable) {
		this.isSolvable.set(isSolvable);
	}

	public ListProperty<ThistlethwaiteMove> solutionProperty() {
		return solution;
	}

	public void setSolution(List<ThistlethwaiteMove> solution) {
		this.solution.get().setAll(solution);
	}

	public void applyPartialSolution(int oldIndex, int newIndex) {
		List<ThistlethwaiteMove> result = new ArrayList<>();
		if (oldIndex < newIndex) {
			for (int i = oldIndex + 1; i <= newIndex; ++i) {
				result.add(solution.get(i));
			}
		} else {
			for (int i = oldIndex; i > newIndex; --i) {
				result.add(solution.get(i).inverse());
			}
		}
		// TODO: apply moves on Thistlethwaite Cube
		cube = CubeMapper.map(CubeMapper.map(cube).applyMoves(result), cube.getCenterColours());
		// cube.applyMoves(result);
	}

	public void fillCube() {
		cube.fill();
		checkIfSolvable();
		isSolvable.set(true);
	}

	public int getCubeNthFacetNumber(int index) {
		return cube.getNthFacetNumber(index);
	}

}
