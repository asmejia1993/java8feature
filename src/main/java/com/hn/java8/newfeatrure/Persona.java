package com.hn.java8.newfeatrure;

import java.util.ArrayList;
import java.util.List;

public class Persona {

	private int id;
	private String nombre;
	private String mensaje;
	private int edad;
	private String genero;
	
	public Persona() {
		
	}

	/**
	 * @param id
	 * @param nombre
	 */
	public Persona(int id, String nombre, String mensaje) {
		this.id = id;
		this.nombre = nombre;
		this.mensaje = mensaje + " " + this.nombre;
	}
	
	

	/**
	 * @param id
	 * @param nombre
	 * @param mensaje
	 * @param edad
	 * @param genero
	 */
	public Persona(int id, String nombre, String mensaje, int edad, String genero) {
		this.id = id;
		this.nombre = nombre;
		this.mensaje = mensaje;
		this.edad = edad;
		this.genero = genero;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void metodoReferenciaPersona() {
		System.out.println(this.mensaje);
		System.out.println("Nombre: " + this.nombre + "-" + " id: " + this.id);
	}
	
	
	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public List<Persona> obtenerPersonas() {
		List<Persona> personas = new ArrayList<>();
		personas.add(new Persona(1, "Jorge", "Hola", 25, "Masculino"));
		personas.add(new Persona(2, "Maria", "Hola", 18, "Femenino"));
		personas.add(new Persona(3, "Alicia", "Hola", 12, "Femenino"));
		personas.add(new Persona(4, "Marcos", "Hola", 30, "Masculino"));
		personas.add(new Persona(5, "Luisa", "Hola", 21, "Femenino"));
		
		return personas;
	}

	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombre + ", mensaje=" + mensaje + ", edad=" + edad + ", genero="
				+ genero + "]";
	}
	
	
}
