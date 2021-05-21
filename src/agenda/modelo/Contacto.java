package agenda.modelo;

/**
 * 
 * @author Pedro J. Aquerreta y David Sena
 */
public abstract class Contacto implements Comparable<Contacto> {
	private String nombre;
	private String apellidos;
	private String telefono;
	private String email;

	public Contacto(String nombre, String apellidos, String telefono, String email) {
		this.nombre = nombre.toUpperCase();
		this.apellidos = apellidos.toUpperCase();
		this.telefono = telefono;
		this.email = email.toLowerCase();
	}

	/**
	 * 
	 * accesor del nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * 
	 * mutador del nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * 
	 * accesor del apellidos
	 */
	public String getApellidos() {
		return apellidos;
	}

	/**
	 * 
	 * mutador del apellidos
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	/**
	 * 
	 * accesor del telefono
	 */
	public String getTelefono() {
		return telefono;
	}

	/**
	 * 
	 * mutador del telefono
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	/**
	 * 
	 * mutador del email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * 
	 * mutador del email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int hashCode() {
		return email.hashCode();

	}

	/**
	 * 
	 * @return primera letra del apellido
	 */
	public char getPrimeraLetra() {
		return this.apellidos.charAt(0);
	}

	/**
	 * Reescribo equals para saber si dos objetos contactos son iguales
	 * 
	 */
	public boolean equals(Contacto c) {
		if (c == null) {
			return false;
		}
		if (c == this) {
			return true;
		}
		if (c.getClass() != this.getClass()) {
			return false;
		}
		return c.getApellidos().equalsIgnoreCase(this.getApellidos())
				&& c.getNombre().equalsIgnoreCase(this.getNombre()) && c.getEmail().equalsIgnoreCase(this.getEmail());
	}

	/**
	 * Reescribo compareTo para poder ordenar, comparar, etc objetos de tipo
	 * contacto
	 * 
	 */
	@Override
	public int compareTo(Contacto c) {
		int resul = this.getApellidos().compareTo(c.getApellidos());
		if (resul != 0) {
			return resul;
		}
		return this.getNombre().compareTo(c.getNombre());

	}

	public abstract String getFirmaEmail();

	/**
	 * Representacion textual de contactos
	 * 
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.getApellidos() + ", ");
		sb.append(this.getNombre() + " (" + this.getClass().getSimpleName().toUpperCase() + ")\n");
		sb.append("Tlfn: " + this.getTelefono() + " |  email: " + this.getEmail());
		return sb.toString();
	}

}
