package ut7.agenda.modelo;

/**
 * 
 * @author Pedro J. Aquerreta y David Sena
 */
public class Relacion {

	private static final String PADRE = "padre";
	private static final String MADRE = "madre";
	private static final String HIJO = "hijo";
	private static final String HIJA = "hija";
	private static final String AMIGOS = "amigos";
	private static final String PAREJA = "pareja";
	private String relacion;

	/*
	 * Inicializa nivel a BAJO
	 */
	public Relacion() {
		relacion = PADRE;
	}

	public void setRelacion(String relacion) {
		this.relacion = relacion;
	}
}
