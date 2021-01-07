package agenda;

import java.util.ArrayList;

import agenda.entidad.Contactos;
import agenda.entidad.Usuario;
import agenda.recursos.AccesoBD;
import agenda.recursos.EntradaSalida;

public class ClasePrincipal {
	public static void main(String[] args) {

		String nombre = EntradaSalida.solicitarNombre();
		Usuario user = AccesoBD.obtenerNombre(nombre);
		System.out.println("Bienvenido " + user.getNombre() + " " + user.getApellido() + "\n");

		int opcion = EntradaSalida.mostraMenu();

		while (opcion != EntradaSalida.SALIR) {
			switch (opcion) {
			case EntradaSalida.INSERTAR:
				
				Contactos insertado = EntradaSalida.insertarContactos();
				
				AccesoBD.insertarContacto(insertado);

				break;
			case EntradaSalida.LISTAR:
				
				 ArrayList<Contactos> listaContactos = AccesoBD.listarContactos();
				 
				 EntradaSalida.listarContactos(listaContactos);

				break;
			case EntradaSalida.BUSCAR:
				 
				String nombreBuscado = EntradaSalida.buscarContacto();
				ArrayList<Contactos> buscar = AccesoBD.buscarNombre(nombreBuscado);
				EntradaSalida.contactoEncontrado(buscar);
				

				break;
			case EntradaSalida.ELIMINAR:
				String nombreBorrado = EntradaSalida.borraContacto();
				AccesoBD.borrarContacto(nombreBorrado);

				break;
			case EntradaSalida.RESET:
				System.err.println("Under construction");

				break;
			case EntradaSalida.SALIR:
				
				break;

			default:
				break;
			}
			opcion = EntradaSalida.mostraMenu();

		}
		System.out.println("Cerrando agenda");
		try {
			Thread.sleep(1000);
			System.out.println("Activando alarma");
			Thread.sleep(1000);
			System.out.println("Soltando perros");
			Thread.sleep(1000);
			System.out.println("Electrificando entorno");
			Thread.sleep(1000);
			System.out.println("Activando explosivos");
			Thread.sleep(1000);
			System.err.println("Sistema armado");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
