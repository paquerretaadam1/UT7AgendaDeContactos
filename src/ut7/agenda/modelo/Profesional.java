package ut7.agenda.modelo;

public class Profesional extends Contacto {

	private String empresa;

	public Profesional(String nombre, String apellidos, String telefono, String email, String empresa) {
		super(crearNombreEmpresa(nombre), crearNombreEmpresa(apellidos), crearNombreEmpresa(telefono),
				crearNombreEmpresa(email));
		this.setEmpresa(crearNombreEmpresa(empresa.toUpperCase()));
	}
	/*
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

	/*
	 * Getter empresa
	 * 
	 */
	public String getEmpresa() {
		return empresa;
	}

	/*
	 * Setter empresa
	 * 
	 */
	public void setEmpresa(String empresa) {
		this.empresa = crearNombreEmpresa(empresa.toUpperCase());
	}

	/*
	 * Selecciona una firma aleatoria para los contactos profesionales
	 * 
	 */
	public String getFirmaEmail() {
		String[] posibilidades = { "Atentamente", "Saludos", "Saludos cordiales", "Mis mejores deseos" };
		return posibilidades[(int) (Math.random() * 4)];
	}

	/**
	 * Representacion textual de contactos profesionales
	 * 
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("\nEmpresa: " + this.getEmpresa() + "\n");
		return sb.toString();

	}
}
