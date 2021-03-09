package com.hn.java8.newfeatrure;

import java.util.List;

public class Empleado {

	private String nombre;
	private Double salario;
	private int edad;
	private List<String> telefonos;
	
	public Empleado() {
		
	}
	
	/**
	 * @param nombre
	 * @param salario
	 * @param edad
	 * @param telefonos
	 */
	public Empleado(String nombre, Double salario, int edad) {
		super();
		this.nombre = nombre;
		this.salario = salario;
		this.edad = edad;
		//this.telefonos = telefonos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public List<String> getTelefonos() {
		return telefonos;
	}

	public void setTelefonos(List<String> telefonos) {
		this.telefonos = telefonos;
	}

	@Override
	public String toString() {
		return "Empleado [nombre=" + nombre + ", salario=" + salario + ", edad=" + edad + ", telefonos=" + telefonos
				+ "]";
	}
	
	
}
