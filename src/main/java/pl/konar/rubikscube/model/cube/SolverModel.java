package pl.konar.rubikscube.model.cube;

import java.util.ArrayList;
import java.util.List;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import pl.konar.rubikscube.model.colour.Colour;
import pl.konar.rubikscube.model.cube.builder.ThistlethwaiteCubeBuilder;
import pl.konar.rubikscube.model.cube.mapper.CubeMapper;
import pl.konar.rubikscube.thistlethwaite.solver.ThistlethwaiteSolver;

public class SolverModel {

	private final ObservableCube cube = new ObservableCube();
	private ListProperty<ThistlethwaiteMove> solution = new SimpleListProperty<>(FXCollections.observableArrayList());
	private BooleanProperty isSolved = new SimpleBooleanProperty(false);
	private BooleanProperty isSolvable = new SimpleBooleanProperty(false);
	private Colour currentColour = Colour.TRANSPARENT;

	public ObservableCube getCube() {
		return cube;
	}

	public void setCurrentColour(Colour newColour) {
		currentColour = newColour;
	}

	public void changeColour(int facetNumber) {
		System.err.println("Setting colour: " + currentColour);
		cube.setColour(facetNumber, currentColour);
		checkIfSolvable();
	}

	private void checkIfSolvable() {
		System.err.println(CubeMapper.isMappable(cube));
		isSolvable.set(CubeMapper.isMappable(cube) && ThistlethwaiteSolver.isSolvable(CubeMapper.map(cube)));
	}

	public void resetCube() {
		cube.reset();
		solution.clear();
		isSolvable.set(false);
		isSolved.set(false);
	}

	public List<ThistlethwaiteMove> solve() {
		ThistlethwaiteCube thistlethwaiteCube = CubeMapper.map(cube);
		return ThistlethwaiteSolver.solve(thistlethwaiteCube);
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
		this.solution.get().add(0, null);
	}

	public void applyPartialSolution(int oldIndex, int newIndex) {
		System.err.println("partial solution: " + oldIndex + " -> " + newIndex);
		List<ThistlethwaiteMove> result = new ArrayList<>();
		if (oldIndex >= 0 && newIndex >= 0) {
			if (oldIndex < newIndex) {
				for (int i = oldIndex + 1; i <= newIndex; ++i) {
					result.add(solution.get(i/* - 1 */));
				}
			} else {
				for (int i = oldIndex; i > newIndex; --i) {
					result.add(solution.get(i/* - 1 */).inverse());
				}
			}
			cube.update(CubeMapper.map(CubeMapper.map(cube).applyMoves(result), cube.getCenterColours()));
		}
	}

	public void scrambleCube() {
		cube.update(CubeMapper.map(ThistlethwaiteCubeBuilder.scrambledCube(), Colour.getAllNonTransparentList()));
		checkIfSolvable();
	}

	public int getCubeNthFacetNumber(int index) {
		return cube.getNthFacetNumber(index);
	}

}
