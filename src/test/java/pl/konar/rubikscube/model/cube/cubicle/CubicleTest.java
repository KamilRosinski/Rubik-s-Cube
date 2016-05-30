package pl.konar.rubikscube.model.cube.cubicle;

import static org.junit.Assert.*;

import org.junit.Test;

import pl.konar.rubikscube.model.colour.Colour;

public class CubicleTest {

	@Test
	public void shouldFillCubicle() {
		// given
		Colour[] colours = { Colour.ORANGE, Colour.BLUE };
		// then
		Cubicle cubicle = new Cubicle(colours);
		// when
		assertEquals(colours[0], cubicle.getFacet(0));
		assertEquals(colours[1], cubicle.getFacet(1));
	}

	@Test
	public void shouldCompareTwoCubicles() {
		// given
		Colour[] colours1 = {Colour.GREEN, Colour.ORANGE, Colour.WHITE};
		Cubicle cubicle1 = new Cubicle(colours1);
		Colour[] colours2 = {Colour.WHITE, Colour.GREEN, Colour.ORANGE};
		Cubicle cubicle2 = new Cubicle(colours2);
		// then
		boolean result = cubicle1.equals(cubicle2);
		// when
		assertTrue(result);
		}
	
	@Test
	public void shouldCheckRelativeTwist() {
		// given
		Colour[] colours1 = {Colour.GREEN, Colour.ORANGE, Colour.WHITE};
		Cubicle cubicle1 = new Cubicle(colours1);
		Colour[] colours2 = {Colour.WHITE, Colour.GREEN, Colour.ORANGE};
		Cubicle cubicle2 = new Cubicle(colours2);
		// then
		int result = cubicle1.relativeTwist(cubicle2);
		// when
		assertEquals(1, result);
	}
	
}
