package com.hn.java8.newfeatrure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        
    	//List<String> cadenas = new ArrayList<>();
    	List<String> listaNombres = new ArrayList<>();
    	
    	listaNombres.add("Juan");
    	listaNombres.add("Ana");
    	listaNombres.add("Pedro");
    	
    	
    	//#1
    	Collections.addAll(listaNombres, "Maria", "Juan");
    	
    	List<Integer> numeros = new ArrayList<>();
    	Collections.addAll(numeros, 56, 12, 1, -3, 7);
    
    	//Java 7 - Ordenamiento de numeros
    	/*Collections.sort(listaNombres, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		});*/
    	
    	Collections.sort(listaNombres, (String x1, String x2) -> x1.compareTo(x2));
    	
    	//Recorriendo con lambdas
    	listaNombres.forEach(x -> {
    		double num1 = 10;
    		System.out.println(num1);
    		System.out.println("Imprimiendo desde una lambda");
    		System.out.println(x);
    		}
    	);
    	
    	listaNombres.forEach(x -> System.out.println());
    	
    	
    	
    	/*for (String value : listaNombres) {
    		double num1 = 10;
    		System.out.println(num1);
    		System.out.println("Imprimiendo desde una lambda");
			System.out.println(value);
		}*/
    	
    	
    	/**
    	 * Ordenamiento sin lambdas
    	 */
    	//Collections.sort(numeros);
    	/*Collections.sort(numeros, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2.compareTo(o1);
			}
		});*/
    	
    	/**
    	 * Haciendo uso de lambdas
    	 * Ordenamiento
    	 * (parametro1, parametro2, ...) -> {logica o procesamiento}
    	 * () -> {logica o procesamiento}
    	 */
    	Collections.sort(numeros, (Integer e1, Integer e2) -> e1.compareTo(e2));
    	
    	
    	//Equivalente agregar elementos
    	/*for (Integer value : numeros) {
			System.out.println(value);
		}*/
    
    	
    	Prueba p = new Prueba(4, 6);
    	p.imprimirPromedio();
    	p.imprimirMensaje();
    	
    }
}
