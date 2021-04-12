package ut7.agenda.modelo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Personal extends Contacto {

	private LocalDate dia;

	private Relacion relacion;

	/**
	 * Constructor
	 */
	public Personal(String nombre, String apellidos, String telefono, String email, String dia, Relacion relacion) {
		super(nombre, apellidos, telefono, email);
		this.dia = LocalDate.parse(dia, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		this.relacion = relacion;
	}

	/*
	 * Getter relacion
	 * 
	 */
	public Relacion getRelacion() {
		return relacion;
	}

	/*
	 * Getter dia
	 * 
	 */
	public LocalDate getDia() {
		return dia;
	}

	/*
	 * Setter dia
	 * 
	 */
	public void setDia(String dia) {
		this.dia = LocalDate.parse(dia, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}

	/*
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
	public boolean esCumpleaños(Contacto otro) {
		if (otro == null) {
			return false;
		}
		if (this == otro) {
			return true;
		}
		if (this.getClass() != otro.getClass()) {
			return false;
		}
		return this.dia.getMonth().equals(((Personal) otro).getDia().getMonth())
				&& (this.dia.getDayOfMonth() == ((Personal) otro).getDia().getDayOfMonth());
	}

	/**
	 * Representacion textual de contactos personales
	 * 
	 */

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("\n" + "Fecha de nacimiento: " + formatearFecha(dia) + "\n");
		sb.append("Relacion: " + relacion + "\n");
		return sb.toString();
	}

	/*
	 * Formatea la fecha para el toString()
	 */
	private String formatearFecha(LocalDate dia) {
		StringBuilder sb = new StringBuilder();
		sb.append(dia.getDayOfMonth() + " " + ("" + dia.getMonth()).substring(0, 2) + ". " + dia.getYear());
		return sb.toString();

	}

	/*
	 * Firma del contacto personal
	 */
	public String getFirmaEmail() {
		return "Un abrazo!!";

	}

}
