package agenda.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Map;

import agenda.modelo.AgendaContactos;
import agenda.modelo.Contacto;
import agenda.modelo.Personal;
import agenda.modelo.Profesional;
import agenda.modelo.Relacion;

/**
 * Utilidades para cargar la agenda
 */
public class AgendaIO {

	public static int importar(AgendaContactos agenda, String file) {
		int errores = 0;
		File f = new File(file);
		BufferedReader entrada = null;
		try {
			entrada = new BufferedReader(new FileReader(f));
			String linea = entrada.readLine();
			while (linea != null) {
				try {
					Contacto c = parsearLinea(linea);
					agenda.añadirContacto(c);
				} catch (NumberFormatException e) {
					System.out.println(e.getMessage());
					errores++;
				} catch (DateTimeParseException e) {

					errores++;
				} catch (IllegalArgumentException e) {
					System.out.println(e.getMessage());
					errores++;

				}

				linea = entrada.readLine();

			}
		} catch (FileNotFoundException e) {
			System.out.println("Error al abrir fichero " + e.getMessage());
		} catch (IOException e) {
			System.out.println("Error al leer" + e.getMessage());
		} finally {

			try {
				entrada.close();
			} catch (IOException e) {
				System.out.println("Error al cerrar" + e.getMessage());
			} catch (NullPointerException e) {
				System.out.println("Error al cerrar " + e.getMessage());
			}
		}
		return errores;

	}

	private static Contacto parsearLinea(String linea)
			throws NumberFormatException, DateTimeParseException, IllegalArgumentException {
		String[] datos = linea.split(",");
		for (int i = 0; i < datos.length; i++) {
			datos[i] = datos[i].trim();
		}

		Contacto c = null;
		if (datos[0].equals("1")) {
			c = new Profesional(datos[1], datos[2], datos[3], datos[4], datos[5]);
		} else {

			c = new Personal(datos[1], datos[2], datos[3], datos[4], datos[5],
					Relacion.valueOf(datos[6].toUpperCase()));
		}
		return c;

	}

	public static void exportarPersonales(AgendaContactos agenda, String fichero) throws IOException {

		File f = new File(fichero);
		PrintWriter salida = null;

		try {
			salida = new PrintWriter(new BufferedWriter(new FileWriter(f)));
			Map<Relacion, List<String>> personales = agenda.personalesPorRelacion();
			for (Relacion clave : personales.keySet()) {
				salida.printf(clave + "\n\t" + personales.get(clave).toString() + "\n");
			}
		} finally {
			try {
				salida.close();
			} catch (NullPointerException e) {
				System.out.println("Error el cerrar " + e.getMessage());
			}

		}

	}

}
