package com.modelTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.model.Persona;
import com.model.Excepciones.InvalidNumberException;

class PersonaTest {

	private static Persona persona1;
	private static Persona persona2;
	private static Persona persona3;

	
	@BeforeAll
	static void crearPersonas() {

		try{
			
			persona1 = new Persona();
			persona2 = new Persona("Manuel",20,'H');
			persona3 = new Persona("Antonia",30,'M', 80.00, 1.70);
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
	void calcularIMCTest() {
		
	}



}
