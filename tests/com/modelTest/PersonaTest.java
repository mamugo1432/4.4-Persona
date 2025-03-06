package com.modelTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.model.Persona;
import com.model.Excepciones.InvalidNumberException;

class PersonaTest {

	private static Persona persona1;
	private static Persona persona2;
	private static Persona persona3;
	

	static void crearPersonas() {
		try{
			persona1 = new Persona();
			persona2 = new Persona("Manuel",20,'H');
			persona2 = new Persona("Antonia",30,'M', 80.00, 1.70);
		}catch(InvalidNumberException e) {
			System.out.println(e.getLocalizedMessage());
		}

		}


	@Test
	void testDniValido() {
		assertEquals(persona1.getDni(), persona1.)
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
