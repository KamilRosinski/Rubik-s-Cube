package pl.konar.rubikscube.model.cube.math;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.Test;

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

}
