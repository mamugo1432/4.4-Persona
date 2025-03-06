package com.modelTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.model.Persona;

class PersonaTest {

	private static Persona persona1;
	private static Persona persona2;
	private static Persona persona3;
	

	static void crearPersonas() {
		persona1 = new Persona();
		persona2 = new Persona("Manuel",20,'H');
		persona2 = new Persona("Antonia",30,'M', 80.00, 1.70);
		}

	@Test
	void testCalcularIMC() {
		assertEquals(persona1.calcularIMC(),Persona.INFRAPESO);
	}

	@Test
	void testPersonaStringIntCharDoubleDouble() {
		fail("Not yet implemented");
	}

	@Test
	void testSetNombre() {
		fail("Not yet implemented");
	}

	@Test
	void testSetEdad() {
		fail("Not yet implemented");
	}

	@Test
	void testSetSexo() {
		fail("Not yet implemented");
	}

	@Test
	void testSetPeso() {
		fail("Not yet implemented");
	}

	@Test
	void testSetAltura() {
		fail("Not yet implemented");
	}

	@Test
	void testCalcularIMC() {
		fail("Not yet implemented");
	}

	@Test
	void testEsMayorDeEdad() {
		fail("Not yet implemented");
	}

	@Test
	void testToString() {
		fail("Not yet implemented");
	}

}
