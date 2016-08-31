package pl.konar.rubikscube.model.cube.math.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.Test;

import pl.konar.rubikscube.model.cube.math.ModularInteger;
import pl.konar.rubikscube.model.cube.math.exception.IllegalModularIntegerValueException;

public class ModularIntegerTest {

	@Test
	public void shouldCreateModularInteger() {
		// given
		int value = 3;
		int base = 5;
		// when
		ModularInteger integer = new ModularInteger(value, base);
		// then
		assertNotNull(integer);
		assertEquals(value, integer.getValue());
		assertEquals(base, integer.getBase());
	}

	@Test(expected = IllegalModularIntegerValueException.class)
	public void shouldThrowExceptionOnCreatingIllegalModularInteger() {
		// given
		int value = 3;
		int base = 2;
		// when
		new ModularInteger(value, base);
		// then
		fail("Expected IllegalModularIntegerValueException");
	}

	@Test
	public void shouldAddModularIntegers() {
		// given
		int base = 4;
		ModularInteger first = new ModularInteger(2, base);
		ModularInteger second = new ModularInteger(3, base);
		ModularInteger expected = new ModularInteger(1, base);
		// when
		ModularInteger result = first.add(second);
		// then
		assertNotNull(result);
		assertEquals(expected, result);
	}
	
}

