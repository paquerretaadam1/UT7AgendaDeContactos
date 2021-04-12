package ut7.agenda.modelo;

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

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

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
				&& c.getNombre().equalsIgnoreCase(this.getApellidos())
				&& c.getEmail().equalsIgnoreCase(this.getEmail());
	}

	public int compareTo(Contacto c) {
		int resul = this.getApellidos().compareTo(c.getApellidos());
		if (resul != 0) {
			return resul;
		}
		return this.getNombre().compareTo(c.getNombre());

	}

	public abstract String getFirmaEmail();

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.getApellidos() + ",");
		sb.append(this.getNombre() + "(" + this.getClass().getSimpleName() + ")\n");
		sb.append("Tlfn: " + this.getTelefono() + " |  " + "email" + this.getEmail());
		return sb.toString();
	}
}
