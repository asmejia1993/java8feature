package com.hn.java8.newfeatrure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class ReferenciaMetodosMain {

	public static void main(String[] args) {
		
		ReferenciaMetodos ref = new ReferenciaMetodos();
		//ref.referenciaMetodoInstanciaObjeto();
		
		//ref.referenciaConstructor();

		/**
		 * Implementacion de mi interface a traves de la referencia a un metodo static
		 */
		//IMensaje im = ReferenciaMetodos::referenciaMetodoStatic;
		//im.mensaje();
		
		/**
		 * Implementacion de mi interface a traves de la referencia a un instancia de un metodo dentro de un objeto
		 */
		//IMensaje im2 = ref::referenciaMetodoInstanciaObjetoParticular;
		//im2.mensaje();
		
		
		//final List<Persona> personas = Arrays.asList(new Persona(1, "Jose", "Hola mi nombre es:"), new Persona(2, "Mario", "Hola mi nombre es:"));
		//personas.forEach(Persona::metodoReferenciaPersona);
		Persona p = new Persona();
		List<Persona> personas = p.obtenerPersonas();
		
		/**
		 * Stream
		 */
		Long t = personas.stream().count();
		System.out.println("El tamanio es: " + t);
		
		/**
		 * Filtrar
		 */
		
		//[1, 2, 3, 4]
		System.out.println("Haciendo uso de un filter");
		List<Persona> resultado = personas.stream()
					.filter(persona -> persona.getEdad() > 20)
					.filter(persona -> persona.getGenero().equalsIgnoreCase("femenino"))
					.collect(Collectors.toList());
		
	
		
		//Equivalente de java 7
		List<Persona> resultado1 = p.obtenerPersonas();
		/*for (Persona persona : resultado) {
			if (persona.getEdad() > 20 && persona.getGenero().equalsIgnoreCase("Femenino")) {
				resultado1.add(persona);
			}
		}*/
		
		//Ordenar una lista
		resultado1.stream().sorted((x, y) -> x.getNombre().compareTo(y.getNombre())).forEach(System.out::println);
		
		//resultado1.forEach(x -> System.out.println(x.getNombre()));
	}

}
