package pl.konar.rubikscube.thistlethwaite.state;

import pl.konar.rubikscube.model.cube.ThistlethwaiteCube;
import pl.konar.rubikscube.thistlethwaite.solver.Phase;

public class ThistlethwaiteStateFactory {

	public static ThistlethwaiteState buildState(ThistlethwaiteCube cube, Phase phase) {
		return new ThistlethwaiteState1(cube);
	}

}
