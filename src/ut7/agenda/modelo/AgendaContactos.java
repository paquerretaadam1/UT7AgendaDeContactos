package ut7.agenda.modelo;

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
			agenda.put(c.getPrimeraLetra(), añadirEnOrden(contactos, c));
		} else {
			TreeSet<Contacto> contactos = new TreeSet<Contacto>();
			contactos.add(c);
			agenda.put(c.getPrimeraLetra(), contactos);

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
		System.out.println(agenda.size());
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (char clave : agenda.keySet()) {
			for (Contacto c : agenda.get(clave)) {
				sb.append(c.toString());
			}
		}
		return sb.toString();
	}

//	public List<Contacto> buscarContactos(String texto) {
//		List<Contacto> buscaContacto = new ArrayList<>();
//		for(Contacto contact:buscaContacto)
//			if (contact.getNombre()
//		return null;
//
//	}

	public List<Contacto> buscarContactos(String texto) {
		List<Contacto> buscaContacto = new ArrayList<>();
		for (char clave : agenda.keySet()) {
			for (Contacto contact : agenda.get(clave)) {
				if (contact.getNombre().contains(texto) || contact.getApellidos().contains(texto)) {
					buscaContacto.add((Contacto) contact);
				}
			}
		}
		return buscaContacto;

	}

	public List<Personal> personalesEnLetra(char letra) {

		return null;
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

	public void personalesPorRelacion() {

	}

	public List<Personal> personalesOrdenadosPorFechaNacimiento(char letra) {

		return null;

	}

}
