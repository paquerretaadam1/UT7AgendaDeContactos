package agenda.modelo;

/**
 * 
 * @author Pedro J. Aquerreta y David Sena
 */
public enum Relacion {
	PADRE("padre"), MADRE("madre"), AMIGOS("amigos"), PAREJA("pareja"), HIJO("hijo"), HIJA("hija");

	private String relacion;

	/*
	 * Inicializa nivel a BAJO
	 */
	private Relacion(String relacion) {
		this.relacion = relacion;
	}

	public void setRelacion(String relacion) {
		this.relacion = relacion;
	}

	public String getRelacion() {
		return relacion;
	}

	/**
	 * 
	 */
	public static Relacion queRelacion(String relacion) {
		return Relacion.valueOf(relacion);
	}

}
