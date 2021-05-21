package agenda.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class AgendaContactos {
	private Map<Character, Set<Contacto>> agenda;

	public AgendaContactos() {
		agenda = new TreeMap<>();
	}

	public void añadirContacto(Contacto c) {

		if (agenda.containsKey(c.getPrimeraLetra())) {
			Set<Contacto> contactos = agenda.get(c.getPrimeraLetra());
			contactos.add(c);
		} else {
			TreeSet<Contacto> contactos = new TreeSet<Contacto>();
			contactos.add(c);
			this.agenda.put(c.getPrimeraLetra(), contactos);
		}

	}

	public Set<Contacto> contactosEnLetra(char caracter) {
		caracter = Character.toUpperCase(caracter);
		return agenda.get(caracter);

	}

	public void totalContactos() {
		int total = 0;
		for (Character clave : agenda.keySet()) {
			total += agenda.get(clave).size();

		}
		System.out.print(total);
	}

	public String toString() {

		StringBuilder sb = new StringBuilder("AGENDA DE CONTACTOS");
		for (char clave : agenda.keySet()) {
			Set<Contacto> contactos = agenda.get(clave);
			sb.append("\n" + clave + " (" + contactos.size() + " contacto/s)\n");
			sb.append("------------------------\n");
			for (Contacto c : contactos) {
				sb.append(c.toString() + "\n");
			}
		}

		return sb.toString();
	}

	public List<Contacto> buscarContactos(String texto) {
		List<Contacto> buscaContacto = new ArrayList<>();
		texto = texto.toUpperCase();
		for (char clave : agenda.keySet()) {
			for (Contacto contact : agenda.get(clave)) {
				if (contact.getNombre().toUpperCase().contains(texto)
						|| contact.getApellidos().toUpperCase().contains(texto)) {
					buscaContacto.add(contact);
				}
			}
		}
		return buscaContacto;

	}

	public List<Personal> personalesEnLetra(char letra) {
		letra = Character.toUpperCase(letra);
		if (!agenda.containsKey(letra)) {
			return null;
		}
		List<Personal> resul = new ArrayList<>();
		for (Contacto personal : agenda.get(letra)) {
			if (personal instanceof Personal) {
				resul.add((Personal) personal);
			}
		}
		return resul;
	}

	public List<Personal> felicitar() {
		List<Personal> cumpleañeros = new ArrayList<>();

		for (char clave : agenda.keySet()) {
			for (Contacto cumple : agenda.get(clave)) {
				if (cumple instanceof Personal && ((Personal) cumple).esCumpleaños()) {
					cumpleañeros.add((Personal) cumple);

				}
			}

		}
		return cumpleañeros;
	}

	public Map<Relacion, List<String>> personalesPorRelacion() {

		Map<Relacion, List<String>> resul = new TreeMap<>();

		for (char clave : agenda.keySet()) {
			for (Contacto contacto : agenda.get(clave)) {
				if (contacto instanceof Personal) {
					Personal personal = (Personal) contacto;
					Relacion relacion = personal.getRelacion();
					if (!resul.containsKey(relacion)) {
						ArrayList<String> nombresFormateados = new ArrayList<>();
						nombresFormateados.add(crearNombre(personal));
						resul.put(personal.getRelacion(), nombresFormateados);
					} else {
						List<String> nombresFormateados = resul.get(relacion);
						nombresFormateados.add(crearNombre(personal));
					}
				}
			}
		}

		return resul;
	}

	private String crearNombre(Personal p) {
		return p.getApellidos() + " " + p.getNombre();
	}

	public List<Personal> personalesOrdenadosPorFechaNacimiento(char letra) {
		List<Personal> resul = personalesEnLetra(letra);

		if (resul != null && !resul.isEmpty()) {
			resul.sort((p1, p2) -> p1.getFechaCumple().compareTo(p2.getFechaCumple()));
		}
		return resul;

	}

}
