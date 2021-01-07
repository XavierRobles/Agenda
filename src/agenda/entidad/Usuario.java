package agenda.entidad;

import java.util.List;

public class Usuario {
	private int id;
	private String nombre;
	private String apellido;
	private List<Contactos> contactos;
	
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
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public List<Contactos> getContactos() {
		return contactos;
	}
	public void setContactos(List<Contactos> contactos) {
		this.contactos = contactos;
	}
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", contactos=" + contactos + "]";
	}
	
	

}
