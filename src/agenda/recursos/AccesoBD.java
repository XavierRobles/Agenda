package agenda.recursos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import agenda.entidad.Contactos;
import agenda.entidad.Usuario;

public class AccesoBD {

	public static Usuario obtenerNombre(String nombre) {
		try {
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/agenda", "root", null);
			Statement stmt = c.createStatement();
			String query = "SELECT * FROM usuarios WHERE nombre = '" + nombre + "'";
			ResultSet rst = stmt.executeQuery(query);
			rst.next();
			Usuario usuario = new Usuario();
			usuario.setNombre(rst.getString(2));
			usuario.setApellido(rst.getString(3));
			return usuario;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	public static void insertarContacto(Contactos insertado) {
		try {
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/agenda", "root", null);
			Statement stmt = c.createStatement();
			String query = "INSERT INTO `contactos`(`nombre`, `apellido`, `email`) VALUES ('" + insertado.getNombre()
					+ "','" + insertado.getApellido() + "','" + insertado.getEmail() + "')";
			int rst = stmt.executeUpdate(query);
			
			System.out.println("####################################");
			System.out.println("Insertando datos en la agenda.");
			System.out.println("####################################\n");

		} catch (SQLException e) {

			System.out.println("Algo ha fallado");
			e.printStackTrace();
		}

	}

	public static ArrayList<Contactos> listarContactos() {
		try {
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/agenda", "root", null);
			Statement stmt = c.createStatement();
			String query = "SELECT * FROM `contactos`";
			ResultSet rst = stmt.executeQuery(query);
			ArrayList<Contactos> listaContactos = new ArrayList();
			while (rst.next()) {
				
				Contactos agenda = new Contactos();
				agenda.setNombre(rst.getString(2));
				agenda.setApellido(rst.getString(3));
				agenda.setEmail(rst.getString(4));
				listaContactos.add(agenda);
			}
			return listaContactos;
			
			
		} catch (SQLException e) {

			System.out.println("Algo ha fallado");
			e.printStackTrace();
		}
		return null;
	}

	public static ArrayList<Contactos> buscarNombre(String nombreBuscado) {
		try {
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/agenda", "root", null);
			Statement stmt = c.createStatement();
			String query = "SELECT * FROM `contactos` WHERE nombre like '"+nombreBuscado+"%'";
			ResultSet rst = stmt.executeQuery(query);
			if (!rst.next()) {
				System.err.println("No existe el nombre introducido");
			}
			ArrayList<Contactos> buscar = new ArrayList();
			while (rst.next()) {
				
				Contactos agenda = new Contactos();
				agenda.setNombre(rst.getString(2));
				agenda.setApellido(rst.getString(3));
				agenda.setEmail(rst.getString(4));
				buscar.add(agenda);
			}
			return buscar;
			
			
		} catch (SQLException e) {

			System.out.println("Algo ha fallado");
			e.printStackTrace();
		}
		return null;
	}

	public static void borrarContacto(String nombreBorrado) {
		try {
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/agenda", "root", null);
			Statement stmt = c.createStatement();
			String query = "DELETE FROM `contactos` WHERE nombre = '"+nombreBorrado+"'";
			int rst = stmt.executeUpdate(query);
			
			System.err.println("Borrando Contacto");
		} catch (SQLException e) {

			System.out.println("Algo ha fallado");
			e.printStackTrace();
		}
	}
	
}
