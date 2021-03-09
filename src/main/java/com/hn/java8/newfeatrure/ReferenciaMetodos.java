package com.hn.java8.newfeatrure;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class ReferenciaMetodos {

	public static void referenciaMetodoStatic() {
		System.out.println("Llamado por referencia a metodo static");
	}
	
	public void referenciaMetodoInstanciaObjeto() {
		String[] nombres = {"Ana", "Marco", "Carlos"};
		
		//Java 7 -> usando implementacion de Comparator
		/*Arrays.sort(nombres, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.compareToIgnoreCase(o2);
			}
		});*/
		
		//Java +8 -> Usando lambda
		//Arrays.sort(nombres, (String o1, String o2) -> o1.compareToIgnoreCase(o2));
		
		//Java +8 -> Usando refenciar metodo a una instancia de un objeto
		Arrays.sort(nombres, String::compareToIgnoreCase);
		
		System.out.println(Arrays.toString(nombres));	
	}
	
	public void referenciaMetodoInstanciaObjetoParticular() {
		System.out.println("Llamado por referencia a metodo de una instancia de un objeto");
	}
	
	public void referenciaConstructor() {
		IPersona ip = Persona::new;
		Persona resultado = ip.crear(1, "Jorge", "hola");
		System.out.println(resultado.getNombre());
	}
	
	
	
	
}
