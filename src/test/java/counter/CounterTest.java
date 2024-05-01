package counter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CounterTest {
	
	private Counter counterTest;
	
	@BeforeEach
	void setUp() {
		counterTest = new Counter();
	}
	@Test
	void constructorTest() {
		assertEquals(0, counterTest.getValue());
		assertEquals(100_000, counterTest.getMaxValue());
		assertEquals("N-COUNTER", counterTest.getModel());
	}
	@Test
	void constructorMaxValueTest() {
		Counter counterCopia = new Counter(200_000);
		Counter counterCopia2 = new Counter(100_000);
		assertNotEquals(counterTest.getMaxValue(),counterCopia.getMaxValue());
		assertEquals(counterTest.getMaxValue(),counterCopia2.getMaxValue());
		assertEquals(counterTest.getValue(),counterCopia.getValue());
		assertEquals( counterTest.getModel(),counterCopia.getModel());
	}
	@Test
	void constructorCopiaTest() {
		Counter counterCopia = new Counter(counterTest);
		assertEquals(counterCopia.getValue(), counterTest.getValue());
		assertEquals(counterCopia.getMaxValue(), counterTest.getMaxValue());
		assertEquals(counterCopia.getModel(), counterTest.getModel());
	}
	@Test
	void incrementTestSimple() {
		assertTrue(counterTest.increment());
		assertEquals(1, counterTest.getValue());
	}
	@Test
	void incrementTestSimple2() {
		counterTest.increment(counterTest.getMaxValue());
		assertFalse(counterTest.increment());
	}
	@Test
	void incrementTestValue() {
		assertTrue(counterTest.increment(10));
		assertEquals(10, counterTest.getValue());
	}
	@Test 
	void incrementTestValueThrows(){
		assertThrows(IllegalArgumentException.class,()->counterTest.increment(-4));
		assertThrows(IllegalArgumentException.class,() -> counterTest.increment(Integer.MAX_VALUE));
	}	
	@Test
	void resetTest() {
		assertFalse(counterTest.reset());
		counterTest.increment(counterTest.getMaxValue());
		assertTrue(counterTest.reset());
	}	
	@Test
	void toStringTest() {
		String resultado = counterTest.toString();
		String esperado = "Contador modelo : N-COUNTER \n"
				+ "Valor actual: 0 \n"
				+ "Valor máximo: 100000 \n";
		assertEquals(esperado, resultado);
	}
}
