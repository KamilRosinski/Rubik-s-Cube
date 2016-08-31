package pl.konar.rubikscube.thistlethwaite.solver;

import pl.konar.rubikscube.model.cube.ThistlethwaiteMove;

public enum Phase {

	FIRST(ThistlethwaiteMove.FRONT_1, ThistlethwaiteMove.FRONT_2, ThistlethwaiteMove.FRONT_3, //
			ThistlethwaiteMove.BACK_1, ThistlethwaiteMove.BACK_2, ThistlethwaiteMove.BACK_3, //
			ThistlethwaiteMove.LEFT_1, ThistlethwaiteMove.LEFT_2, ThistlethwaiteMove.LEFT_3, //
			ThistlethwaiteMove.RIGHT_1, ThistlethwaiteMove.RIGHT_2, ThistlethwaiteMove.RIGHT_3, //
			ThistlethwaiteMove.UP_1, ThistlethwaiteMove.UP_2, ThistlethwaiteMove.UP_3, //
			ThistlethwaiteMove.DOWN_1, ThistlethwaiteMove.DOWN_2, ThistlethwaiteMove.DOWN_3), //
	SECOND(ThistlethwaiteMove.FRONT_1, ThistlethwaiteMove.FRONT_2, ThistlethwaiteMove.FRONT_3, //
			ThistlethwaiteMove.BACK_1, ThistlethwaiteMove.BACK_2, ThistlethwaiteMove.BACK_3, //
			ThistlethwaiteMove.LEFT_1, ThistlethwaiteMove.LEFT_2, ThistlethwaiteMove.LEFT_3, //
			ThistlethwaiteMove.RIGHT_1, ThistlethwaiteMove.RIGHT_2, ThistlethwaiteMove.RIGHT_3, //
			ThistlethwaiteMove.UP_2, //
			ThistlethwaiteMove.DOWN_2), //
	THIRD(ThistlethwaiteMove.FRONT_1, ThistlethwaiteMove.FRONT_2, ThistlethwaiteMove.FRONT_3, //
			ThistlethwaiteMove.BACK_1, ThistlethwaiteMove.BACK_2, ThistlethwaiteMove.BACK_3, //
			ThistlethwaiteMove.LEFT_2, //
			ThistlethwaiteMove.RIGHT_2, //
			ThistlethwaiteMove.UP_2, //
			ThistlethwaiteMove.DOWN_2), //
	FOURTH(ThistlethwaiteMove.FRONT_2, //
			ThistlethwaiteMove.BACK_2, //
			ThistlethwaiteMove.LEFT_2, //
			ThistlethwaiteMove.RIGHT_2, //
			ThistlethwaiteMove.UP_2, //
			ThistlethwaiteMove.DOWN_2);

	private ThistlethwaiteMove[] applicableMoves;

	private Phase(ThistlethwaiteMove... applicableMoves) {
		this.applicableMoves = applicableMoves;
	}

	public ThistlethwaiteMove[] getApplicableMoves() {
		return applicableMoves;
	}

}
