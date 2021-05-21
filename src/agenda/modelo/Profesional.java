package src.agenda.modelo;

/**
 * 
 * @author Pedro J. Aquerreta y David Sena
 */
public class Profesional extends Contacto {

	private String empresa;

	public Profesional(String nombre, String apellidos, String telefono, String email, String empresa) {
		super(nombre, apellidos, telefono, email);
		this.setEmpresa(crearNombreEmpresa(empresa.toUpperCase()));
	}

	/**
	 * Formatea el nombre de la empresa
	 * 
	 */
	private static String crearNombreEmpresa(String empresa) {
		String[] partes = empresa.split(" ");
		StringBuilder sb = new StringBuilder();
		for (String aCapitalizar : partes) {
			sb.append(aCapitalizar.charAt(0) + aCapitalizar.substring(1).toLowerCase() + " ");
		}
		return sb.toString();
	}

	/**
	 * Getter empresa
	 * 
	 */
	public String getEmpresa() {
		return empresa;
	}

	/**
	 * Setter empresa
	 * 
	 */
	public void setEmpresa(String empresa) {
		this.empresa = crearNombreEmpresa(empresa.toUpperCase());
	}

	/**
	 * Selecciona una firma aleatoria para los contactos profesionales
	 * 
	 */
	@Override
	public String getFirmaEmail() {
		String[] posibilidades = { "Atentamente", "Saludos", "Saludos cordiales", "Mis mejores deseos" };
		return posibilidades[(int) (Math.random() * 4)];
	}

	/**
	 * Representacion textual de contactos profesionales
	 * 
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("\nEmpresa: " + this.getEmpresa() + "\n");
		return sb.toString();

	}
}
