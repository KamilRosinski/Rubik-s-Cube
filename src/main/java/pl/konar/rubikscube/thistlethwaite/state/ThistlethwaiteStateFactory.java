package pl.konar.rubikscube.thistlethwaite.state;

import pl.konar.rubikscube.model.cube.ThistlethwaiteCube;
import pl.konar.rubikscube.thistlethwaite.solver.Phase;

public class ThistlethwaiteStateFactory {

	private interface Creator {
		public ThistlethwaiteState create(ThistlethwaiteCube cube);
	}

	private static final Creator[] CREATORS = { //
			cube -> new ThistlethwaiteState1(cube), //
			cube -> new ThistlethwaiteState2(cube), //
			cube -> new ThistlethwaiteState3(cube), //
			cube -> new ThistlethwaiteState4(cube) };

	public static ThistlethwaiteState buildState(ThistlethwaiteCube cube, Phase phase) {
		return CREATORS[phase.ordinal()].create(cube);
	}

}
