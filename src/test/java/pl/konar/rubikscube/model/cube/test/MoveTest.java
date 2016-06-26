package pl.konar.rubikscube.model.cube.test;

import static org.junit.Assert.*;

import org.junit.Test;

import pl.konar.rubikscube.model.cube.Move;

public class MoveTest {

	@Test
	public void shouldInverseEmptyMove() {
		// given
		Move move = Move.E;
		// when
		Move result = move.inverse();
		// then
		assertEquals(Move.E, result);
	}

	@Test
	public void shouldInverseClockwiseMove() {
		// given
		Move move = Move.F1;
		// when
		Move result = move.inverse();
		// then
		assertEquals(Move.F3, result);
	}
	
	@Test
	public void shouldInverseDoubleMove() {
		// given
		Move move = Move.B2;
		// when
		Move result = move.inverse();
		// then
		assertEquals(Move.B2, result);
	}
	
	@Test
	public void shouldInverseCounterClockwiseMove() {
		// given
		Move move = Move.U3;
		// when
		Move result = move.inverse();
		// then
		assertEquals(Move.U1, result);
	}
	
}
