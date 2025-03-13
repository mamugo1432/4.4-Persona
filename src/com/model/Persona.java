package com.model;

import com.model.Excepciones.InvalidAlturaException;
import com.model.Excepciones.InvalidNumberException;
import com.model.Excepciones.InvalidPesoException;

/**

 * Clase Persona

 * Contiene información de una persona

 * @author DiscoDurodeRoer

 */

public class Persona {


    private final static char SEXO_DEF = 'H';
    public static final int INFRAPESO = -1;
    public static final int PESO_IDEAL = 0;
    public static final int SOBREPESO = 1;

    private String nombre;
    private int edad;
    private String DNI;
    private char sexo;
    private double peso;
    private double altura;


    public Persona() throws InvalidNumberException{

        this("", 0, SEXO_DEF, 0, 0);
    }

 
    public Persona(String nombre, int edad, char sexo) throws InvalidNumberException {

        this(nombre, edad, sexo, 0, 0);
        if(this.edad<0) {
        	throw new InvalidNumberException();
        }
    }


    public Persona(String nombre, int edad, char sexo, double peso, double altura) throws InvalidNumberException {

        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
        this.altura = altura;
        generarDni();
        this.sexo = sexo;
        comprobarSexo();
        
        if(this.edad<0 || this.peso<0 || this.altura<0) {
        	throw new InvalidNumberException();
        }
    }


   

    private void comprobarSexo() {

        if (sexo != 'H' && sexo != 'M') {

            this.sexo = SEXO_DEF;

        }

    }

 

    private void generarDni() {

        final int divisor = 23;

        int numDNI = ((int) Math.floor(Math.random() * (100000000 - 10000000) + 10000000));

        int res = numDNI - (numDNI / divisor * divisor);

        char letraDNI = generaLetraDNI(res);

        DNI = Integer.toString(numDNI) + letraDNI;

    }

 

    private char generaLetraDNI(int res) {

        char letras[] = {'T', 'R', 'W', 'A', 'G', 'M', 'Y',

            'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z',

            'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};

 

        return letras[res];

    }

 
    public void setNombre(String nombre) {

        this.nombre = nombre;
    }


    public void setEdad(int edad) {

        this.edad = edad;
    }


    public void setSexo(char sexo) {

        this.sexo = sexo;
    }

 

    public void setPeso(double peso) throws InvalidPesoException{
    	if (peso <=0) {
    		throw new InvalidPesoException();
    	}
        this.peso = peso;
    }



    public void setAltura(double altura) throws InvalidAlturaException {
    	if(altura<=0) {
    		throw new InvalidAlturaException();
    	}
        this.altura = altura;
    }

    public String getDni() {
    	return DNI;
    }
    
    public boolean esDniValido(String dni) {
    	return dni != null && dni.length()==9 && Character.isUpperCase(dni.charAt(dni.length()-1)) && isNumeric(dni.substring(0, 8));
    }

    private boolean isNumeric(String cadena) {
    	
    	boolean salida=false;
    	
    	for(int i=0; i<cadena.length() && !salida;i++) {
    		if(!Character.isDigit(cadena.charAt(i))) {
    			salida=true;
    		}
    	}
    	return !salida;
    }
    
   
    /**

     * Calcula el indice de masa corporal

     *

     * @return codigo numerico

     * <ul><li>-1: la persona esta por debajo de su peso ideal</li>

     * <li>0: la persona esta en su peso ideal</li>

     * <li>1: la persona esta por encima de su peso ideal</li></ul>

     */

    public Integer calcularIMC() {


        double pesoActual = peso / (Math.pow(altura, 2));


        if (pesoActual >= 20 && pesoActual <= 25) {

            return PESO_IDEAL;

        } else if (pesoActual < 20) {

            return INFRAPESO;

        } else if (Double.isNaN(pesoActual)) {
        
        	return null;
        	
        }
        else {
            return SOBREPESO;

        }

    }

 
    public boolean esMayorDeEdad() {

        boolean mayor = false;

        if (edad >= 18) {

            mayor = true;
        }

        return mayor;

    }


    @Override

    public String toString() {

        String sexo;

        if (this.sexo == 'H') {

            sexo = "hombre";

        } else {

            sexo = "mujer";

        }

        return "Informacion de la persona:\n"

                + "Nombre: " + nombre + "\n"

                + "Sexo: " + sexo + "\n"

                + "Edad: " + edad + " años\n"

                + "DNI: " + DNI + "\n"

                + "Peso: " + peso + " kg\n"

                + "Altura: " + altura + " metros\n";

    }

 

}