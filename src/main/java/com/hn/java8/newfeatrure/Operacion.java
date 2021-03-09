package com.hn.java8.newfeatrure;

@FunctionalInterface
public interface Operacion {

	double calcularPromedio(double numero1, double numero2);
	//double calcularDoble(double numero1);
	//double calcularPromedio(double numero1);
	//void imprimirHolamundo();
	
	
	//Metodo defecto
	default void imprimirMensaje() {
		System.out.println("Imprimiendo mensaje desde metodo por defecto");
	}
	
	//Metodo estatico
	static void imprimirTexto() {
		System.out.println("Imprimiendo mensaje desde interface");
	}
}
