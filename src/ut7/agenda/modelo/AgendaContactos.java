package ut7.agenda.modelo;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;




public class AgendaContactos {
	private Map<Character, Set<Contacto>> agenda;

	public AgendaContactos() {

	}

	public void añadirContacto() {
		
	}

	public Set<Contacto> contactosEnLetra(char caracter) {
		return agenda.get(caracter);
		
	}

	public void totalContactos() {
		System.out.println(agenda.size());
	}

	@Override
	public String toString() {

		return null;
	}

	public List<Contacto> buscarContactos(String texto) {
		List<Contacto> buscaContacto = new ArrayList<>();
		for(Contacto contact:buscaContacto)
			if (contact.getNombre()
		return null;

	}

	public List<Personal> personalesEnLetra(char letra) {

		return null;
	}

	public List<Personal> felicitar() {
		List<Personal> cumpleañeros = new ArrayList<>();
		for (Personal cumple :cumpleañeros) {
			if(cumple.esCumpleaños()) {
				cumpleañeros.add(cumple);
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
