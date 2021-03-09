package com.hn.java8.newfeatrure;

public class Prueba {

	double num1;
	double num2;
	static double atributo1;
	double atributo2;
	
	public Prueba() {
		
	}

	/**
	 * @param numero1
	 * @param numero2
	 */
	public Prueba(double num1, double num2) {
		this.num1 = num1;
		this.num2 = num2;
	}
	
	/**
	 * Implementando una interface como clase anonima
	 */
	public void imprimirPromedio() {
		/*Operacion o = new Operacion() {
			@Override
			public double calcularPromedio(double numero1, double numero2) {
				return (numero1+numero2)/2;
			}
		};*/
		
		//Operacion o1 = (x, y) -> (x+y)/2;
		Operacion o1 = (double x, double y) -> {return (x+y);};
		
		/*Operacion o1 = (double x, double y) -> {
			System.out.println("impriendo bloque de codigo dentro de lambda");
			atributo1 = x+y;
			System.out.println("Este es una variable static: " + atributo1);
			atributo2 = atributo1;
			return atributo2;
		};*/
		
		//Operacion o1 = () -> System.out.println("Hola mundo desde lambda");
		
		
		//Operacion o1 = (double x) -> x*2;
		o1.imprimirMensaje();
		//System.out.println("El producto es: " + o1.calcularDoble(this.num1));
		System.out.println("El promedio es: " + o1.calcularPromedio(this.num1, this.num2));
		 //o1.imprimirHolamundo();
	}
	
	public void imprimirMensaje() {
		Operacion.imprimirTexto();
	}

	
}
