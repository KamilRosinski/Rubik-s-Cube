package pl.konar.rubikscube.model.cube.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

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

	@Test
	public void ShouldMoveU1() {
		// given
		ObservableCube observable = CubeMapper.map(ThistlethwaiteCubeBuilder.buildSolvedCube(),
				Colour.getAllNonTransparentList());
		ThistlethwaiteCube thistlethwaite = ThistlethwaiteCubeBuilder.buildSolvedCube();
		Move move = Move.U1;
		ThistlethwaiteMove thistlethwaiteMove = ThistlethwaiteMove.U1;
		// when
		observable.applyMove(move);
		thistlethwaite = thistlethwaite.applyMove(thistlethwaiteMove);
		// then
		assertEquals(CubeMapper.map(observable), thistlethwaite);
	}

	@Test
	public void ShouldMoveU2() {
		// given
		ObservableCube observable = CubeMapper.map(ThistlethwaiteCubeBuilder.buildSolvedCube(),
				Colour.getAllNonTransparentList());
		ThistlethwaiteCube thistlethwaite = ThistlethwaiteCubeBuilder.buildSolvedCube();
		Move move = Move.U2;
		ThistlethwaiteMove thistlethwaiteMove = ThistlethwaiteMove.U2;
		// when
		observable.applyMove(move);
		thistlethwaite = thistlethwaite.applyMove(thistlethwaiteMove);
		// then
		assertEquals(CubeMapper.map(observable), thistlethwaite);
	}
	
	@Test
	public void ShouldMoveU3() {
		// given
		ObservableCube observable = CubeMapper.map(ThistlethwaiteCubeBuilder.buildSolvedCube(),
				Colour.getAllNonTransparentList());
		ThistlethwaiteCube thistlethwaite = ThistlethwaiteCubeBuilder.buildSolvedCube();
		Move move = Move.U3;
		ThistlethwaiteMove thistlethwaiteMove = ThistlethwaiteMove.U2;
		// when
		observable.applyMove(move);
		thistlethwaite = thistlethwaite.applyMove(thistlethwaiteMove);
		// then
		assertEquals(CubeMapper.map(observable), thistlethwaite);
	}
	
}
