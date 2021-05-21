package src.agenda.interfaz;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import src.agenda.io.AgendaIO;
import src.agenda.modelo.AgendaContactos;
import src.agenda.modelo.Personal;

public class GuiAgenda extends Application {
	private AgendaContactos agenda;
	private MenuItem itemImportar;
	private MenuItem itemExportarPersonales;
	private MenuItem itemSalir;

	private MenuItem itemBuscar;
	private MenuItem itemFelicitar;

	private MenuItem itemAbout;

	private TextArea areaTexto;

	private RadioButton rbtListarTodo;
	private RadioButton rbtListarSoloNumero;
	private Button btnListar;

	private Button btnPersonalesEnLetra;
	private Button btnPersonalesOrdenadosPorFecha;

	private TextField txtBuscar;

	private Button btnClear;
	private Button btnSalir;

	@Override
	public void start(Stage stage) {
		agenda = new AgendaContactos(); // el modelo

		BorderPane root = crearGui();

		Scene scene = new Scene(root, 1100, 700);
		stage.setScene(scene);
		stage.setTitle("Agenda de contactos");
		scene.getStylesheets().add(getClass().getResource("/application.css").toExternalForm());
		stage.show();

	}

	private BorderPane crearGui() {
		BorderPane panel = new BorderPane();
		panel.setTop(crearBarraMenu());
		panel.setCenter(crearPanelPrincipal());
		return panel;
	}

	private BorderPane crearPanelPrincipal() {
		BorderPane panel = new BorderPane();
		panel.setPadding(new Insets(10));
		panel.setTop(crearPanelLetras());

		areaTexto = new TextArea();
		areaTexto.getStyleClass().add("textarea");
		panel.setCenter(areaTexto);

		panel.setLeft(crearPanelBotones());
		return panel;
	}

	private VBox crearPanelBotones() {

		VBox panel = new VBox(10);

		panel.setPadding(new Insets(40, 0, 40, 0));
		panel.setAlignment(Pos.CENTER);

		txtBuscar = new TextField();
		txtBuscar.setPrefColumnCount(13);
		panel.getChildren().addAll(new Label("Buscar"), txtBuscar);

		rbtListarTodo = new RadioButton("Listar toda la agenda");
		rbtListarTodo.setSelected(true);

		rbtListarSoloNumero = new RadioButton("Listar nº contactos");

		ToggleGroup grupo = new ToggleGroup();
		rbtListarTodo.setToggleGroup(grupo);
		rbtListarSoloNumero.setToggleGroup(grupo);

		panel.getChildren().addAll(rbtListarTodo, rbtListarSoloNumero);

		btnListar = new Button("Listar");
		btnListar.setPrefWidth(250);
		btnListar.setOnAction(e -> listar());

		btnPersonalesEnLetra = new Button("Contactos personales en letra");
		btnPersonalesEnLetra.setPrefWidth(250);
		btnPersonalesEnLetra.setOnAction(e -> contactosPersonalesEnLetra());

		btnPersonalesOrdenadosPorFecha = new Button("Contactos personales ordenados por fecha");
		btnPersonalesOrdenadosPorFecha.setPrefWidth(250);
		btnPersonalesOrdenadosPorFecha.setOnAction(e -> personalesOrdenadosPorFecha());

		btnClear = new Button("Clear");
		btnClear.setPrefWidth(250);
		btnClear.setOnAction(e -> clear());

		btnSalir = new Button("Salir");
		btnSalir.setPrefWidth(250);
		btnSalir.setOnAction(e -> salir());

		panel.getChildren().addAll(btnListar, btnPersonalesEnLetra, btnPersonalesOrdenadosPorFecha, btnClear, btnSalir);
		return panel;
	}

	private GridPane crearPanelLetras() {
		GridPane panel = new GridPane();
		String letras = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ ";
		panel.setPadding(new Insets(10));
		panel.setAlignment(Pos.CENTER);
		panel.setHgap(5);
		panel.setVgap(5);
		for (int fila = 0; fila < 14; fila++) {
			for (int col = 0; col < 2; col++) {
				char pos = letras.charAt((fila * 14) + col);
				if (pos != ' ') {
					Button btn = new Button("" + pos);
					btn.setOnAction(e -> contactosEnLetra(pos));
					btn.setId("button");
					btn.setMaxSize(Integer.MAX_VALUE, Integer.MAX_VALUE);
					btn.setId("botonletra");
					GridPane.setMargin(btn, new Insets(1.5));
					panel.add(btn, col, fila);
				}

			}
		}
		return panel;
	}

	private MenuBar crearBarraMenu() {
		// a completar
		MenuBar barra = new MenuBar();
		barra.setId("barramenu");
		Menu archivo = new Menu("Archivo");
		Menu operaciones = new Menu("Operaciones");
		Menu help = new Menu("Help");
		barra.getMenus().addAll(archivo, operaciones, help);

		itemImportar = new MenuItem("_Importar Agenda");
		itemImportar.setOnAction(event -> importarAgenda());
		itemExportarPersonales = new MenuItem("_Exportar");
		itemExportarPersonales.setOnAction(event -> exportarPersonales());
		itemSalir = new MenuItem("_Salir");
		itemSalir.setOnAction(event -> salir());
		archivo.getItems().addAll(itemImportar, itemExportarPersonales, new SeparatorMenuItem(), itemSalir);

		itemBuscar = new MenuItem("_Buscar");
//		itemBuscar.setOnAction(event -> factorial());
		itemFelicitar = new MenuItem("_Felicitar");
		itemFelicitar.setOnAction(event -> felicitar());
		operaciones.getItems().addAll(itemBuscar, itemFelicitar);

		itemAbout = new MenuItem("_About");
//		itemAbout.setOnAction(event -> factorial());
		help.getItems().addAll(itemAbout);

		return barra;
	}

	private void importarAgenda() {
		// a completar

	}

	private void exportarPersonales() {

		try {
			AgendaIO.exportarPersonales(agenda, "Personales");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 *  
	 */
	private void listar() {
		clear();
		// a completar

	}

	private void personalesOrdenadosPorFecha() {
		clear();
		// a completar

	}

	private void contactosPersonalesEnLetra() {
		clear();
		// a completar

	}

	private void contactosEnLetra(char letra) {
		clear();
		List<Personal> personales = agenda.personalesEnLetra(letra);
		if (personales == null) {
			areaTexto.setText(letra + " no está en la agenda");
		} else {
			areaTexto.setText(personales.toString());
		}

	}

	private void felicitar() {
		clear();
		List<Personal> resultado = agenda.felicitar();
		if (resultado.isEmpty()) {
			areaTexto.setText("Hoy no cumple nadie");
		} else {
			areaTexto.setText("Hoy es " + LocalDate.now() + "\nHay que felicitar a " + resultado.toString());
		}

	}

	private void buscar() {
		clear();

		cogerFoco();

	}

	private void about() {
		// a completar

	}

	private void clear() {
		areaTexto.setText("");
	}

	private void salir() {
		Platform.exit();
	}

	private void cogerFoco() {
		txtBuscar.requestFocus();
		txtBuscar.selectAll();

	}

	public static void main(String[] args) {
		launch(args);
	}
}
