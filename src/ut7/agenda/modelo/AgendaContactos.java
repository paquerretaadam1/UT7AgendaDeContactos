package ut7.agenda.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class AgendaContactos {
	private TreeMap<Character, TreeSet<Contacto>> agenda;

	public AgendaContactos() {
		agenda = new TreeMap<Character, TreeSet<Contacto>>();
	}

	public void añadirContacto(Contacto c) {

		if (agenda.containsKey(c.getPrimeraLetra())) {
			Set<Contacto> contactos = agenda.get(c.getPrimeraLetra());
			this.agenda.put(c.getPrimeraLetra(), añadirEnOrden(contactos, c));
		} else {
			TreeSet<Contacto> contactos = new TreeSet<Contacto>();
			contactos.add(c);
			this.agenda.put(c.getPrimeraLetra(), contactos);

		}

	}

	private TreeSet<Contacto> añadirEnOrden(Set<Contacto> original, Contacto aAñadir) {
		TreeSet<Contacto> resul = new TreeSet<>();
		resul.addAll(original);
		resul.add(aAñadir);
		return resul;
	}

	public Set<Contacto> contactosEnLetra(char caracter) {
		return agenda.get(caracter);

	}

	public void totalContactos() {
		int total = 0;
		for (Character clave : agenda.keySet()) {
			total += agenda.get(clave).size();

		}
		System.out.println(total);
	}

	public String toString() {
		System.out.println(this.agenda.keySet());
		StringBuilder sb = new StringBuilder();

		for (char clave : agenda.keySet()) {
			for (Contacto c : agenda.get(clave)) {
				sb.append(c.toString());
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

		Map<Relacion, List<String>> resul = new TreeMap<Relacion, List<String>>();

		for (char clave : agenda.keySet()) {
			for (Contacto personal : agenda.get(clave)) {
				if (personal instanceof Personal) {
					ArrayList<String> nombresFormateados = new ArrayList<>();
					nombresFormateados.add(crearNombre(((Personal) personal)));
					nombresFormateados.sort((n1, n2) -> n1.compareToIgnoreCase(n2));
					resul.put(((Personal) personal).getRelacion(), nombresFormateados);

				}
			}

		}

		return resul;
	}

	private String crearNombre(Personal p) {
		return p.getApellidos() + " " + p.getNombre();
	}

//	public List<Personal> personalesOrdenadosPorFechaNacimiento(char letra) {
//		List<Personal> resul = personalesEnLetra(letra);
//		resul.sort((p1, p2) -> p1.compareTo(p2));
//		return resul;

//	}

}
