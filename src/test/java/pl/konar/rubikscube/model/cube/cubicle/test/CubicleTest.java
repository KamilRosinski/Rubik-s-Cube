package pl.konar.rubikscube.model.cube.cubicle.test;

import static org.junit.Assert.*;

import org.junit.Test;

import pl.konar.rubikscube.model.colour.Colour;
import pl.konar.rubikscube.model.cube.cubicle.Cubicle;

public class CubicleTest {

	@Test
	public void shouldCreateCubicle() {
		// given
		Colour[] colours = { Colour.ORANGE, Colour.BLUE };
		// then
		Cubicle cubicle = new Cubicle(colours);
		// when
		assertEquals(colours[0], cubicle.getColour(0));
		assertEquals(colours[1], cubicle.getColour(1));
	}

	@Test
	public void shouldCompareTwoEqualCubicles() {
		// given
		Colour[] colours1 = { Colour.GREEN, Colour.ORANGE, Colour.WHITE };
		Cubicle cubicle1 = new Cubicle(colours1);
		Colour[] colours2 = { Colour.WHITE, Colour.GREEN, Colour.ORANGE };
		Cubicle cubicle2 = new Cubicle(colours2);
		// then
		boolean result = cubicle1.equals(cubicle2);
		// when
		assertTrue(result);
	}

	@Test
	public void shouldCompareTwoUnequalCubicles() {
		// given
		Colour[] colours1 = { Colour.GREEN, Colour.ORANGE, Colour.WHITE };
		Cubicle cubicle1 = new Cubicle(colours1);
		Colour[] colours2 = { Colour.WHITE, Colour.RED, Colour.ORANGE };
		Cubicle cubicle2 = new Cubicle(colours2);
		// then
		boolean result = cubicle1.equals(cubicle2);
		// when
		assertFalse(result);
	}

	@Test
	public void shouldCompareTwoCubiclesOfDifferentSize() {
		// given
		Colour[] colours1 = { Colour.GREEN, Colour.ORANGE, Colour.WHITE };
		Cubicle cubicle1 = new Cubicle(colours1);
		Colour[] colours2 = { Colour.WHITE, Colour.RED };
		Cubicle cubicle2 = new Cubicle(colours2);
		// then
		boolean result = cubicle1.equals(cubicle2);
		// when
		assertFalse(result);
	}

	@Test
	public void shouldCheckRelativeTwistOfEqualCubicles() {
		// given
		Colour[] colours1 = { Colour.GREEN, Colour.ORANGE, Colour.WHITE };
		Cubicle cubicle1 = new Cubicle(colours1);
		Colour[] colours2 = { Colour.WHITE, Colour.GREEN, Colour.ORANGE };
		Cubicle cubicle2 = new Cubicle(colours2);
		// then
		int result = cubicle1.relativeTwist(cubicle2);
		// when
		assertEquals(1, result);
	}

	@Test
	public void shouldCheckRelativeTwistOfUnequalCubicles() {
		// given
		Colour[] colours1 = { Colour.GREEN, Colour.ORANGE, Colour.WHITE };
		Cubicle cubicle1 = new Cubicle(colours1);
		Colour[] colours2 = { Colour.WHITE, Colour.GREEN };
		Cubicle cubicle2 = new Cubicle(colours2);
		// then
		int result = cubicle1.relativeTwist(cubicle2);
		// when
		assertEquals(-1, result);
	}

	@Test
	public void shouldTwistCubicle() {
		// given
		Cubicle cubicle = new Cubicle(Colour.YELLOW, Colour.BLUE, Colour.RED);
		int twistAngle = 1;
		// when
		Cubicle twisted = cubicle.twist(twistAngle);
		// then
		assertNotNull(twisted);
		assertEquals(twistAngle, twisted.relativeTwist(cubicle));

	}

}
