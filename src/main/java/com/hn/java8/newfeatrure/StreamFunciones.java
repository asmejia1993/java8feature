package com.hn.java8.newfeatrure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamFunciones {

	static List<Empleado> empleados = llenarLista();

	/*
	 * Funcion Map
	 */
	public static void convertirListaStringAEnteros() {

		/***************************** Ejemplo #1 **********************************/
		List<String> listCadenas = Arrays.asList("1", "35", "100", "4", "20");
		List<Integer> listNumeros = new ArrayList<>();

		// Equivalente en Java < 7
		// for (String value : listCadenas) {
		// listNumeros.add(Integer.valueOf(value));
		// }

		// System.out.println(listNumeros);

		// Equivalente en Java 8
		listCadenas.stream().map(Integer::valueOf).forEach(System.out::println);

	}

	/**
	 * 
	 */
	public static void convertirMayusculas() {

		/***************************** Ejemplo #2 **********************************/
		List<String> listCadenas2 = Arrays.asList("hola", "desde", "curso", "de", "java");
		listCadenas2.stream().map(String::toUpperCase).forEach(System.out::println);
	}

	/*
	 * 
	 */
	public static void manipularClase() {
		//empleados = llenarLista();

		/***************************** Ejemplo #1 **********************************/
		// Haciendo uso de lambdas
		/*
		 empleados.stream().map(x -> x.getNombre().toUpperCase())
		  .forEach(System.out::println);*/
		 

		// Haciendo uso de metodos de referencia
		/*
		  empleados.stream() .map(Empleado::getNombre) .map(String::toUpperCase)
		  .forEach(System.out::println);*/
		 

		/***************************** Ejemplo #2 **********************************/
		String valorReturnado = empleados.stream().filter(x -> x.getSalario() > 10000.00).map(Empleado::getNombre)
				.findFirst().orElse("ninguno");

		//System.out.println("Nombre que cumplio condicion: " + valorReturnado);

		/***************************** Ejemplo #3 **********************************/
		String valorReturnado1 = empleados.stream().filter(x -> x.getSalario() > 20000.00).map(Empleado::getNombre)
				.findAny().orElse("nadie");

		// System.out.println("Nombre que cumplio condicion: " + valorReturnado1);

		/***************************** Ejemplo #4 **********************************/
		// Modificar mi lista sobrescribiendo por un valor por defecto
		// x.getEdad() = 20 && x.getSalario() = 25000
		List<Empleado> e1 = empleados.stream().map(x -> new Empleado(x.getNombre(), 25000.00, 20))
				.collect(Collectors.toList());
		//System.out.println(e1);

		// la lista original se mantiene
		// System.out.println(empleados);

		/***************************** Ejemplo #5 **********************************/
		long cantidadElmConStream = empleados.stream().count();
		long cantidadElmSinStream = empleados.size();

		// System.out.println(cantidadElmConStream);
		// System.out.println(cantidadElmSinStream);

		// Bloque equivalente en JAVA 8
		cantidadElmConStream = empleados.stream().filter(x -> x.getEdad() > 25).count();
		//System.out.println(cantidadElmConStream);

		// Bloque equivalente en JAVA < 7
		int count = 0;
		for (Empleado emp1 : empleados) {
			if (emp1.getEdad() > 25) {
				count++;
			}
		}
		// System.out.println(count);

		/***************************** Ejemplo #5 **********************************/
		empleados.stream().map(x -> x.getEdad()).distinct().forEach(System.out::println);

	}

	/**
	 * Encontrar maximo
	 */
	public static void encontrarMaximo() {

		Comparator<Empleado> comparator = Comparator.comparing(Empleado::getSalario);
		Empleado e = empleados.stream().max((a, b) -> a.getSalario().compareTo(b.getSalario())).get();
		//Empleado e = empleados.stream().max(comparator).get();

		System.out.println(e);
	}

	/**
	 * Encontrar minimo
	 */
	public static void encontrarMinimo() {

		Empleado e = empleados.stream().min((a, b) -> a.getSalario().compareTo(b.getSalario())).get();

		System.out.println(e);
	}
	
	/**
	 * Encontrar maximo y minimo
	 */
	public static void encontrarMaxMinConStream() {
		Integer maxNum = Stream.of(1, 2, 3, 2, 80, -5)
								.max((a, b) -> a.compareTo(b))
								.get();
		
		System.out.println(maxNum);
		
	}
	
	
	/**
	 * Calcular promedio
	 */
	public static void calcularPromedio() {
		double promedio = empleados.stream().mapToDouble(p -> p.getEdad()).average().orElse(0);
		System.out.println("El promedio de edad es de : " + promedio);
	}
	
	
	/**
	 * Elminiar duplicados
	 */
	public static void eliminarDuplicados() {
		
		//Forma numero1
		List<Integer> listNumeros = new ArrayList<>(Arrays.asList(1, 2, 2, 3, 3, 3, 6, 6, 6, 7, 8));
		System.out.println(listNumeros);
		
		System.out.println("Haciendo uso de Stream y el distinc");
		List<Integer> listSinDuplicados = listNumeros.stream().distinct().collect(Collectors.toList());
		System.out.println(listSinDuplicados);
		
		//Forma numero2
		Set<Integer> listConSet = listNumeros.stream().collect(Collectors.toSet());
		System.out.println("Haciendo uso de Stream y la clase Collectors,toSet");
		System.out.println(listConSet);
		
		//Forma numero3
		Set<Integer> setInt = new HashSet<>(listNumeros);
		System.out.println("Haciendo uso de la Interface SET");
		System.out.println(setInt);
	}
	
	/**
	 * Convertir a un Map a partir de una lista
	 */
	public static void convertirListToMap() {
		
		List<Integer> listNumeros = new ArrayList<>(Arrays.asList(1, 2, 2, 3, 3, 3, 6, 6, 6, 7, 8));
		Map<Integer, Long> map = listNumeros.stream().collect(Collectors.toMap(Function.identity(), v -> 1L, Long::sum));
		System.out.println(map);
	} 
	
	/**
	 * Ordenamiento
	 */
	public static void ordanamientoLista() {
		List<Integer> listNumeros = Arrays.asList(2, 4, -5, 1, 6, 355, 3);
		List<Integer> listOrdenada;
		System.out.println(listNumeros);
		
		Comparator<Integer> comparator = Comparator.reverseOrder();
		
		//Metodo #1 Ordnamiento Ascendente
		listNumeros.stream().sorted().forEach(System.out::println);
		
		//Metodo #2 Ordnamiento Ascendente
		Collections.sort(listNumeros);
		System.out.println(listNumeros);
		
		//Metodo #3 Ordnamiento Descendente
		listOrdenada = listNumeros.stream().sorted((a, b) -> b.compareTo(a)).collect(Collectors.toList());
		//System.out.println(listOrdenada);
		
		//Metodo #4 Ordnamiento Descendente
		Collections.sort(listNumeros, comparator);
		//System.out.println(listNumeros);
		
		//Metodo #5 Ordnamiento Descendente
		Collections.sort(listNumeros, Comparator.reverseOrder());
		System.out.println(listNumeros);
		
	}
	
	/**
	 * Haciendo uso de los AnyMatch, AllMacth
	 */
	public static void usandoAnyMatch() {
		
		Predicate<Empleado> edadMayor30 = x -> x.getEdad() > 30;
		Predicate<String> igualA = x -> x.contains("A");
		
		//Clase String
		Stream<String> stream = Stream.of("uno", "dos", "tres", "cinco");
		boolean existe = stream.anyMatch(x -> x.startsWith("u"));
		System.out.println(existe);
		
		//Empleado
		existe = empleados.stream().anyMatch(x -> x.getSalario() > 25000);
		System.out.println(existe);
		
		existe = empleados.stream().anyMatch(edadMayor30);
		System.out.println(existe);
	}
	
	/**
	 * Aplicar un regex o expresion regular
	 */
	public static void aplicarRegex() {
		List<String> correos = Arrays.asList("aj@example.com", "jsdhf@example.com", "aj@test.com", "dsds@example.hn");
		System.out.println("Lista de correos sin aplicar un filtro");
		System.out.println(correos);
		
		Predicate<String> correoFilter = Pattern.compile("^(.+)@example.com$").asPredicate();
		
		List<String> correosFiltrados = correos.stream().filter(correoFilter).collect(Collectors.toList());
		System.out.println("Lista de correos aplicando un filtro");
		System.out.println(correosFiltrados);
		
		
		//Tarea 
		//En aplicar una expresion regular a mi lista de empleados, 
		//donde imprima los registros cuyo nombre no tengan caracteres especiales o numeros
		
		
		
	}
	
	
	public static void explicacandoOptional() {
		
		//Declarar un optional
		Optional<Integer> opt = Optional.empty();
		System.out.println(opt.isPresent());
		
		Optional<Integer> opt1 = Optional.of(5);
		//Verificando si existe el elemento
		System.out.println(opt1.isPresent());
		//Obtener este elemento
		System.out.println(opt1.get());
		
		//Pasando un valor que podria ser null 
		Optional<String> optS = Optional.ofNullable(null);
		Optional<String> optSN = Optional.of(null);
		//System.out.println(optS.isPresent());
 		
	}
	
	
	

	/**
	 * Llenar lista
	 * 
	 * @return List<Empleado>
	 */
	public static List<Empleado> llenarLista() {
		List<Empleado> empleados = new ArrayList<>();
		Collections.addAll(empleados, new Empleado("Jo@se", 15000.00, 20), new Empleado("Mari&a", 12500.00, 20),
				new Empleado("Pe$dro", 12800.00, 20), new Empleado("Lui%sa", 22500.00, 20),
				new Empleado("Ka0rla", 31000.00, 20), new Empleado("P*ablo", 10000.00, 31),
				new Empleado("Juan", 16700.00, 29), new Empleado("Monica", 14000.00, 22));
		return empleados;
	}
}
