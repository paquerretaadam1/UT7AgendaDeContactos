package src.agenda.modelo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * 
 * @author Pedro J. Aquerreta y David Sena
 */
public class Personal extends Contacto {

	private LocalDate fechaCumple;
	private Relacion relacion;

	/**
	 * Constructor
	 */
	public Personal(String nombre, String apellidos, String telefono, String email, String fechaCumple,
			Relacion relacion) {
		super(nombre, apellidos, telefono, email);
		this.fechaCumple = LocalDate.parse(fechaCumple, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

		this.relacion = relacion;
	}

	/**
	 * Getter relacion
	 * 
	 */
	public Relacion getRelacion() {
		return relacion;
	}

	/**
	 * Getter fechaCumple
	 * 
	 */
	public LocalDate getFechaCumple() {
		return fechaCumple;
	}

	/**
	 * Setter fechaCumple
	 * 
	 */
	public void setDia(String fechaCumple) {
		this.fechaCumple = LocalDate.parse(fechaCumple, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}

	/**
	 * Setter relacion
	 * 
	 */
	public void setRelacion(Relacion relacion) {
		this.relacion = relacion;
	}

	/**
	 * Devuelve true /false si es el día del cumpleaños o no
	 * 
	 */
	public boolean esCumpleaños() {
		LocalDate fechaActual = LocalDate.now();
		return this.fechaCumple.getMonth().equals(fechaActual.getMonth())
				&& (this.fechaCumple.getDayOfMonth() == (fechaActual.getDayOfMonth()));
	}

	/**
	 * Representacion textual de contactos personales
	 * 
	 */

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("\n" + "Fecha de nacimiento: " + formatearFecha(fechaCumple) + "\n");
		sb.append("Relacion: " + relacion + "\n");
		return sb.toString();
	}

	/**
	 * Formatea la fecha para el toString()
	 */
	private String formatearFecha(LocalDate fechaCumple) {
		return fechaCumple.format(DateTimeFormatter.ofPattern("dd MMM yyyy"));
	}

	/**
	 * Firma del contacto personal
	 */
	@Override
	public String getFirmaEmail() {
		return "Un abrazo!!";

	}

	public int compareTo(Personal p) {
		if (this.getFechaCumple().compareTo(p.getFechaCumple()) > 1) {
			return 1;
		} else if (this.getFechaCumple().compareTo(p.getFechaCumple()) == 1) {
			return 0;
		}
		return -1;
	}
}
