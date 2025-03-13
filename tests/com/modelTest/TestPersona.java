package com.modelTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.model.Persona;
import com.model.Excepciones.InvalidAlturaException;
import com.model.Excepciones.InvalidNumberException;
import com.model.Excepciones.InvalidPesoException;

class TestPersona {

	private static Persona persona1;
	private static Persona persona2;
	private static Persona persona3;
	private static Persona persona4;
	private static Persona persona5;
	
	@BeforeAll
	static void crearPersonas() {

		try{
			persona1 = new Persona();
			persona2 = new Persona("Manuel",20,'H');
			persona3 = new Persona("Antonia",30,'M', 90.00, 1.70);
			persona4 = new Persona("Antonia",15,'M', 60.00, 1.70);
			persona5 = new Persona("Paco",30,'H', 10.00, 1.70);
		}catch(InvalidNumberException e) {
			System.out.println(e.getLocalizedMessage());
		}

		}

	@Test
	 void objetoLanzaExcepcion() {
		assertThrows(InvalidNumberException.class, () -> new Persona("Miguel",-10,'H'));
	}
	@Test
	void setPesoTestExcepcion() {
		assertThrows(InvalidPesoException.class, () -> persona1.setPeso(0));
	}
	
	@Test
	void setPesoTest() {
		try {
			persona3.setPeso(100);
			persona4.setPeso(61.2);
			persona5.setPeso(10.87);
		} catch (InvalidPesoException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void setAlturaTestExcepcion() {
		assertThrows(InvalidAlturaException.class, () -> persona1.setAltura(0));
	}
	
	@Test
	void setAlturaTest() {
		try {
			persona3.setAltura(1.71);
			persona4.setAltura(1.72);
			persona5.setAltura(1.69);
		} catch (InvalidAlturaException e) {
			e.printStackTrace();
		}

	}
	
	@Test
	void testDniValido() {
		assertTrue( persona1.esDniValido(persona1.getDni()));
		assertFalse( persona2.esDniValido(persona2.getDni()+" "));
		assertFalse(persona3.esDniValido(persona3.getDni()+"9"));
		assertFalse(persona4.esDniValido(null));
		assertTrue(persona5.esDniValido(persona5.getDni()+""));
	}
	
	@Test
	void TestscalcularIMC() {
		assertEquals(null, persona1.calcularIMC());
		assertNotEquals(0, persona1.calcularIMC());
		assertEquals(null, persona2.calcularIMC());
		assertNotEquals(2, persona2.calcularIMC());
		assertEquals(persona3.SOBREPESO, persona3.calcularIMC());
		assertEquals(persona4.PESO_IDEAL, persona4.calcularIMC());
		assertEquals(0, persona4.calcularIMC());
		assertEquals(persona5.INFRAPESO, persona5.calcularIMC());
	}
	
	@Test
	void TestsMayorEdad() {
		assertFalse(persona1.esMayorDeEdad());
		assertTrue(persona2.esMayorDeEdad());
		assertTrue(persona3.esMayorDeEdad());
		assertFalse(persona4.esMayorDeEdad());
	}
	
	@Test
	void testToString() {
		assertEquals("Informacion de la persona:\nNombre: Manuel\nSexo: hombre\nEdad: 20 años\nDNI: "+persona2.getDni()+"\nPeso: 0.0 kg\nAltura: 0.0 metros\n", persona2.toString());
		assertEquals("Informacion de la persona:\nNombre: Antonia\nSexo: mujer\nEdad: 30 años\nDNI: "+persona3.getDni()+"\nPeso: 100.0 kg\nAltura: 1.7 metros\n", persona3.toString());
	}
	
}
