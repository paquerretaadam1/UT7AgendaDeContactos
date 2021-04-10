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
	

}
