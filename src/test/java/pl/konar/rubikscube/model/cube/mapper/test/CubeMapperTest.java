package pl.konar.rubikscube.model.cube.mapper.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import pl.konar.rubikscube.model.colour.Colour;
import pl.konar.rubikscube.model.cube.ObservableCube;
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
		ObservableCube cube = new ObservableCube(ObservableCubeTest.scrambledColours);
		// when
		// then
		assertNotNull(cube);
		assertTrue(CubeMapper.isMappable(cube));
	}

	@Test
	public void ShouldDetectNotMappableCubeWithWrongCenters() {
		// given
		List<Colour> colours = new ArrayList<>(ObservableCubeTest.scrambledColours);
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
		List<Colour> colours = new ArrayList<>(ObservableCubeTest.scrambledColours);
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
		List<Colour> colours = new ArrayList<>(ObservableCubeTest.scrambledColours);
		colours.set(50, Colour.RED);
		// when
		ObservableCube cube = new ObservableCube(colours);
		// then
		assertNotNull(cube);
		assertFalse(CubeMapper.isMappable(cube));
	}

	@Test
	public void ShouldMapCube() {
		fail("Not yet implamented.");
	}
	
}
