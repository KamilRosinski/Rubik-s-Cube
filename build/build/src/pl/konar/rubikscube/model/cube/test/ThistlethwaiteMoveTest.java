package pl.konar.rubikscube.model.cube.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import pl.konar.rubikscube.model.cube.ThistlethwaiteMove;

public class ThistlethwaiteMoveTest {

	@Test
	public void shouldInverseClockwiseThistlethwaiteMove() {
		// given
		ThistlethwaiteMove thistlethwaiteMove = ThistlethwaiteMove.FRONT_1;
		// when
		ThistlethwaiteMove result = thistlethwaiteMove.inverse();
		// then
		assertEquals(ThistlethwaiteMove.FRONT_3, result);
	}

	@Test
	public void shouldInverseDoubleThistlethwaiteMove() {
		// given
		ThistlethwaiteMove thistlethwaiteMove = ThistlethwaiteMove.BACK_2;
		// when
		ThistlethwaiteMove result = thistlethwaiteMove.inverse();
		// then
		assertEquals(ThistlethwaiteMove.BACK_2, result);
	}

	@Test
	public void shouldInverseCounterClockwiseThistlethwaiteMove() {
		// given
		ThistlethwaiteMove thistlethwaiteMove = ThistlethwaiteMove.UP_3;
		// when
		ThistlethwaiteMove result = thistlethwaiteMove.inverse();
		// then
		assertEquals(ThistlethwaiteMove.UP_1, result);
	}

}
