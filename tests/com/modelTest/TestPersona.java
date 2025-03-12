package com.modelTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.model.Persona;
import com.model.Excepciones.InvalidNumberException;

class TestPersona {

	private static Persona persona1;
	private static Persona persona2;
	private static Persona persona3;
	private static Persona persona4;

	
	@BeforeAll
	static void crearPersonas() {

		try{
			persona1 = new Persona();
			persona2 = new Persona("Manuel",20,'H');
			persona3 = new Persona("Antonia",30,'M', 20.00, 1.70);
			persona4 = new Persona("Antonia",30,'M', 60.00, 1.70);
		}catch(InvalidNumberException e) {
			System.out.println(e.getLocalizedMessage());
		}

		}

	@Test
	 void objetoLanzaExcepcion() {
		assertThrows(InvalidNumberException.class, () -> new Persona("Miguel",-10,'H'));
	}

	@Test
	void testDniValido() {
		assertTrue( persona1.esDniValido(persona1.getDni()));
		assertFalse( persona2.esDniValido(persona2.getDni()+" "));
		assertFalse(persona3.esDniValido(persona3.getDni()+"9"));
	}
	
	@Test
	void TestscalcularIMC() {
		assertEquals(persona1.SOBREPESO, persona1.calcularIMC());
		assertNotEquals(0, persona1.calcularIMC());
		assertEquals(persona2.SOBREPESO, persona2.calcularIMC());
		assertNotEquals(2, persona2.calcularIMC());
		assertEquals(persona3.INFRAPESO, persona3.calcularIMC());
		assertEquals(persona4.PESO_IDEAL, persona4.calcularIMC());
		assertEquals(0, persona4.calcularIMC());
	}
}
