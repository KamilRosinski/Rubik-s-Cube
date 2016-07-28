package pl.konar.rubikscube.model.cube.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import pl.konar.rubikscube.model.colour.Colour;
import pl.konar.rubikscube.model.cube.Move;
import pl.konar.rubikscube.model.cube.ObservableCube;
import pl.konar.rubikscube.model.cube.ThistlethwaiteCube;
import pl.konar.rubikscube.model.cube.ThistlethwaiteMove;
import pl.konar.rubikscube.model.cube.builder.ThistlethwaiteCubeBuilder;
import pl.konar.rubikscube.model.cube.mapper.CubeMapper;

public class ThistlethwaiteCubeTest {

	@Test
	public void ShouldBuildSolvedCube() {
		// given
		// when
		ThistlethwaiteCube cube = ThistlethwaiteCubeBuilder.buildSolvedCube();
		// then
		assertNotNull(cube);
	}

	private void testMove(Move move, ThistlethwaiteMove thistlethwaiteMove) {
		// given
		ObservableCube observable = CubeMapper.map(ThistlethwaiteCubeBuilder.buildSolvedCube(),
				Colour.getAllNonTransparentList());
		ThistlethwaiteCube thistlethwaiteCube = ThistlethwaiteCubeBuilder.buildSolvedCube();
		// when
		observable.applyMove(move);
		thistlethwaiteCube = thistlethwaiteCube.applyMove(thistlethwaiteMove);
		// then
		assertEquals(CubeMapper.map(observable), thistlethwaiteCube);
	}

	@Test
	public void ShouldMoveE() {
		testMove(Move.E, ThistlethwaiteMove.EMPTY);
	}

	@Test
	public void ShouldMoveU1() {
		testMove(Move.U1, ThistlethwaiteMove.UP_1);
	}

	@Test
	public void ShouldMoveU2() {
		testMove(Move.U2, ThistlethwaiteMove.UP_2);
	}

	@Test
	public void ShouldMoveU3() {
		testMove(Move.U3, ThistlethwaiteMove.UP_3);
	}

	@Test
	public void ShouldMoveD1() {
		testMove(Move.D1, ThistlethwaiteMove.DOWN_1);
	}

	@Test
	public void ShouldMoveD2() {
		testMove(Move.D2, ThistlethwaiteMove.DOWN_2);
	}

	@Test
	public void ShouldMoveD3() {
		testMove(Move.D3, ThistlethwaiteMove.DOWN_3);
	}

	@Test
	public void ShouldMoveF1() {
		testMove(Move.F1, ThistlethwaiteMove.FRONT_1);
	}

	@Test
	public void ShouldMoveF2() {
		testMove(Move.F2, ThistlethwaiteMove.FRONT_2);
	}

	@Test
	public void ShouldMoveF3() {
		testMove(Move.F3, ThistlethwaiteMove.FRONT_3);
	}

	@Test
	public void ShouldMoveB1() {
		testMove(Move.B1, ThistlethwaiteMove.BACK_1);
	}

	@Test
	public void ShouldMoveB2() {
		testMove(Move.B2, ThistlethwaiteMove.BACK_2);
	}

	@Test
	public void ShouldMoveB3() {
		testMove(Move.B3, ThistlethwaiteMove.BACK_3);
	}

	@Test
	public void ShouldMoveL1() {
		testMove(Move.L1, ThistlethwaiteMove.LEFT_1);
	}

	@Test
	public void ShouldMoveL2() {
		testMove(Move.L2, ThistlethwaiteMove.LEFT_2);
	}

	@Test
	public void ShouldMoveL3() {
		testMove(Move.L3, ThistlethwaiteMove.LEFT_3);
	}

	@Test
	public void ShouldMoveR1() {
		testMove(Move.R1, ThistlethwaiteMove.RIGHT_1);
	}

	@Test
	public void ShouldMoveR2() {
		testMove(Move.R2, ThistlethwaiteMove.RIGHT_2);
	}

	@Test
	public void ShouldMoveR3() {
		testMove(Move.R3, ThistlethwaiteMove.RIGHT_3);
	}

	@Test
	public void ShouldApplyListOfMoves() {
		ObservableCube observable = CubeMapper.map(ThistlethwaiteCubeBuilder.buildSolvedCube(),
				Colour.getAllNonTransparentList());
		ThistlethwaiteCube thistlethwaiteCube = ThistlethwaiteCubeBuilder.buildSolvedCube();
		List<Move> moves = Arrays.asList(//
				Move.E, //
				Move.U1, //
				Move.R3, //
				Move.D1, //
				Move.L1, //
				Move.F2, //
				Move.U3, //
				Move.D2, //
				Move.R2 //
		);
		List<ThistlethwaiteMove> thistlethwaiteMoves = Arrays.asList(//
				ThistlethwaiteMove.EMPTY, //
				ThistlethwaiteMove.UP_1, //
				ThistlethwaiteMove.RIGHT_3, //
				ThistlethwaiteMove.DOWN_1, //
				ThistlethwaiteMove.LEFT_1, //
				ThistlethwaiteMove.FRONT_2, //
				ThistlethwaiteMove.UP_3, //
				ThistlethwaiteMove.DOWN_2, //
				ThistlethwaiteMove.RIGHT_2 //
		);
		// when
		observable.applyMoves(moves);
		thistlethwaiteCube = thistlethwaiteCube.applyMoves(thistlethwaiteMoves);
		// then
		assertEquals(CubeMapper.map(observable), thistlethwaiteCube);
	}

}
