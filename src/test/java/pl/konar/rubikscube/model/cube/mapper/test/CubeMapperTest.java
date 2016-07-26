package pl.konar.rubikscube.model.cube.mapper.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import pl.konar.rubikscube.model.colour.Colour;
import pl.konar.rubikscube.model.cube.ObservableCube;
import pl.konar.rubikscube.model.cube.ThistlethwaiteCube;
import pl.konar.rubikscube.model.cube.builder.ThistlethwaiteCubeBuilder;
import pl.konar.rubikscube.model.cube.mapper.CubeMapper;
import pl.konar.rubikscube.model.cube.test.ObservableCubeTest;

public class CubeMapperTest {

	private static ObservableCube solvedCube = new ObservableCube();

	@BeforeClass
	public static void Initialize() {
		solvedCube.fill();
	}

	@Test
	public void ShouldDetectMappableCube() {
		// given
		ObservableCube cube = new ObservableCube(ObservableCubeTest.SCRAMBLED_COLOURS);
		// when
		// then
		assertNotNull(cube);
		assertTrue(CubeMapper.isMappable(cube));
	}

	@Test
	public void ShouldDetectNotMappableCubeWithWrongCenters() {
		// given
		List<Colour> colours = new ArrayList<>(ObservableCubeTest.SCRAMBLED_COLOURS);
		colours.set(1, Colour.YELLOW);
		// when
		ObservableCube cube = new ObservableCube(colours);
		// then
		assertNotNull(cube);
		assertFalse(CubeMapper.isMappable(cube));
	}

	@Test
	public void ShouldDetectNotMappableCubeWithWrongEdges() {
		// given
		List<Colour> colours = new ArrayList<>(ObservableCubeTest.SCRAMBLED_COLOURS);
		colours.set(10, Colour.RED);
		// when
		ObservableCube cube = new ObservableCube(colours);
		// then
		assertNotNull(cube);
		assertFalse(CubeMapper.isMappable(cube));
	}

	@Test
	public void ShouldDetectNotMappableCubeWithWrongCorners() {
		// given
		List<Colour> colours = new ArrayList<>(ObservableCubeTest.SCRAMBLED_COLOURS);
		colours.set(50, Colour.RED);
		// when
		ObservableCube cube = new ObservableCube(colours);
		// then
		assertNotNull(cube);
		assertFalse(CubeMapper.isMappable(cube));
	}

	@Test
	public void ShouldMapScrambledCubeToThistlethwaite() {
		// given
		ObservableCube observableCube = new ObservableCube(ObservableCubeTest.SCRAMBLED_COLOURS);
		// when
		ThistlethwaiteCube thistlethwaiteCube = CubeMapper.map(observableCube);
		// then
		assertNotNull(thistlethwaiteCube);
	}

	@Test
	public void ShouldMapSolvedCubeToThistlethwaite() {
		// given
		ObservableCube solvedCube = new ObservableCube();
		solvedCube.fill(Colour.getAllNonTransparentList());
		// when
		ThistlethwaiteCube thistlethwaiteCube = CubeMapper.map(solvedCube);
		ThistlethwaiteCube expected = ThistlethwaiteCubeBuilder.buildSolvedCube();
		// then
		assertNotNull(thistlethwaiteCube);
		assertEquals(expected, thistlethwaiteCube);
	}

	@Test
	public void ShouldMapSolvedCubeToObservable() {
		// given
		ThistlethwaiteCube thistlethwaiteCube = ThistlethwaiteCubeBuilder.buildSolvedCube();
		ObservableCube expected = new ObservableCube();
		expected.fill(Colour.getAllNonTransparentList());
		// when
		ObservableCube observableCube = CubeMapper.map(thistlethwaiteCube, expected.getCenterColours());
		// then
		assertNotNull(observableCube);
		assertEquals(expected.getColours(), observableCube.getColours());
	}

	@Test
	public void ShouldMapSolvedScrambledCubeInBothDirections() {
		// given
		ObservableCube scrambled = new ObservableCube(ObservableCubeTest.SCRAMBLED_COLOURS);
		// when
		ThistlethwaiteCube mapped = CubeMapper.map(scrambled);
		ObservableCube result = CubeMapper.map(mapped, scrambled.getCenterColours());
		// then
		assertNotNull(result);
		assertEquals(ObservableCubeTest.SCRAMBLED_COLOURS, result.getColours());
	}
	
}
