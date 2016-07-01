package pl.konar.rubikscube.model.cube.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

import pl.konar.rubikscube.model.colour.Colour;
import pl.konar.rubikscube.model.cube.CubeConstants;
import pl.konar.rubikscube.model.cube.ObservableCube;
import pl.konar.rubikscube.model.cube.exception.WrongNumberOfFacetsException;

public class ObservableCubeTest {

	public static List<Colour> scrambledColours = Arrays.asList(Colour.WHITE, Colour.GREEN, Colour.ORANGE, Colour.BLUE,
			Colour.RED, Colour.YELLOW, Colour.ORANGE, Colour.BLUE, Colour.ORANGE, Colour.WHITE, Colour.YELLOW,
			Colour.ORANGE, Colour.RED, Colour.WHITE, Colour.YELLOW, Colour.BLUE, Colour.BLUE, Colour.RED, Colour.WHITE,
			Colour.BLUE, Colour.GREEN, Colour.ORANGE, Colour.WHITE, Colour.GREEN, Colour.YELLOW, Colour.GREEN,
			Colour.RED, Colour.YELLOW, Colour.GREEN, Colour.RED, Colour.GREEN, Colour.ORANGE, Colour.WHITE, Colour.RED,
			Colour.BLUE, Colour.YELLOW, Colour.ORANGE, Colour.GREEN, Colour.YELLOW, Colour.WHITE, Colour.BLUE,
			Colour.RED, Colour.RED, Colour.GREEN, Colour.WHITE, Colour.BLUE, Colour.ORANGE, Colour.YELLOW, Colour.WHITE,
			Colour.ORANGE, Colour.BLUE, Colour.GREEN, Colour.RED, Colour.YELLOW);

	@Test
	public void ShouldCreateTransparentCube() {
		// given
		ObservableCube cube = new ObservableCube();
		// when
		List<Colour> expected = Collections.nCopies(CubeConstants.NUMBER_OF_FACETS, Colour.TRANSPARENT);
		// then
		assertNotNull(cube);
		assertEquals(expected, cube.getColours());
	}

	@Test
	public void ShouldCreateCubeFromListOfColours() {
		// given
		// when
		ObservableCube cube = new ObservableCube(scrambledColours);
		// then
		assertNotNull(cube);
		assertEquals(scrambledColours, cube.getColours());
	}

	@Test(expected = WrongNumberOfFacetsException.class)
	public void ShouldThrowExceptionOnWrongNumberOfFacets() {
		// given
		List<Colour> colours = Arrays.asList(Colour.RED, Colour.YELLOW, Colour.BLUE);
		// when
		new ObservableCube(colours);
		// then
		fail("No exception thrown");
	}

	@Test
	public void ShouldGetCenterColours() {
		// given
		ObservableCube cube = new ObservableCube(scrambledColours);
		// when
		List<Colour> expected = Arrays.asList(Colour.WHITE, Colour.GREEN, Colour.ORANGE, Colour.BLUE, Colour.RED,
				Colour.YELLOW);
		// then
		assertEquals(expected, cube.getCenterColours());
	}

}
