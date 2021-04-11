package ut7.agenda.modelo;
import java.time.LocalDate;


public class Personal extends Contacto {

	private LocalDate dia;
	private Relacion relacion;
	
	/**
	 * Constructor
	 */
	public Personal(String nombre, String apellidos, String telefono,
			String email, LocalDate dia, Relacion relacion) {
		super(nombre, apellidos, telefono, email);
		this.dia = dia;
		this.relacion = relacion;
	}
	public Relacion getRelacion() {
		return relacion;
	}
	public LocalDate getDia() {
		return dia;
	}
	
	/**
	 * Devuelve true /false si es el día del cumpleaños o no
	 *  
	 */
	public  boolean esCumpleaños(Contacto otro)  {
		return this.dia.equals(((Personal) otro).getDia());
	
		/**
		 * Representacion textual de contactos personales
		 *  
		 */
	}
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("Fecha de nacimiento: " + dia + "\n");
		sb.append("Relacion: " + relacion + "\n");
		return sb.toString();
	}
}
