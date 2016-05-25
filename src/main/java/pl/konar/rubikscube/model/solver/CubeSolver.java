package pl.konar.rubikscube.model.solver;

import java.util.List;

import pl.konar.rubikscube.model.cube.Move;

public interface CubeSolver {

	public List<Move> solve();
	
}
