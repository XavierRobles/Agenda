package agenda.recursos;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import agenda.entidad.Contactos;

public class EntradaSalida {

	public final static int INSERTAR = 1;
	public final static int LISTAR = 2;
	public final static int BUSCAR = 3;
	public final static int ELIMINAR = 4;
	public final static int RESET = 5;
	public final static int SALIR = 6;
	private static Scanner sc = new Scanner(System.in);

	public static String solicitarNombre() {

		System.out.println("Introduzca el usuario para acceder a su agenda.");
		String nombre = sc.nextLine();
		return nombre;

	}

	public static int mostraMenu() {
		System.out.println("Seleccione una opcion del Menu");
		System.out.println("1 - Insertar nuevo contacto");
		System.out.println("2 - Mostrar todos los contactos");
		System.out.println("3 - Buscar contactos");
		System.out.println("4 - Eliminar  contacto");
		System.out.println("5 - Borrar la Agenda");
		System.out.println("6 - Salir");
		int opcion = Integer.parseInt(sc.nextLine());
		return opcion;

	}

	public static Contactos insertarContactos() {
		System.out.println("Introduzca el nombre");
		String nombre = sc.nextLine();
		System.out.println("Introduzca el apellido");
		String apellido = sc.nextLine();
		System.out.println("Introduzca el Email");
		String email = sc.nextLine();

		Contactos insertado = new Contactos(nombre, apellido, email);

		return insertado;

	}

	public static void listarContactos(ArrayList<Contactos> listaContactos) {
		System.out.println("Contactos en el agenda:");
		System.out.println("---------------------------------------------------------");
		for (Contactos contactos : listaContactos) {
			System.out.println("Nombre: " + contactos.getNombre() + ", Apellido: " + contactos.getApellido()
					+ ", Email: " + contactos.getEmail());
			System.out.println("---------------------------------------------------------");

		}
	}

	public static String buscarContacto() {
		System.out.println("Introduce el nombre o parte del nombre que quieres buscar");
		String nombreBuscado = sc.nextLine();

		return nombreBuscado;
	}

	public static void contactoEncontrado(ArrayList<Contactos> buscar) {
		System.out.println("---------------------------------------------------------");
		for (Contactos busqueda : buscar) {
			System.out.println("Nombre "+ busqueda.getNombre()+", Apellido "+busqueda.getApellido()+", Email "+busqueda.getEmail());
			System.out.println("---------------------------------------------------------");
		}
	}

	public static String borraContacto() {
		System.out.println("Introduce el nombre del contacto que deseas borrar");
		String nombreBorrado = sc.nextLine();
		return nombreBorrado;
	}

}
