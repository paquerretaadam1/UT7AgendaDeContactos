package src.agenda.interfaz;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import src.agenda.modelo.AgendaContactos;

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
		btnListar.setPadding(new Insets(0, 0, 40, 0));
		btnListar.setOnAction(e -> listar());

		btnPersonalesEnLetra = new Button("Contactos personales en letra");
		btnPersonalesEnLetra.setPrefWidth(250);
		btnPersonalesEnLetra.setOnAction(e -> contactosPersonalesEnLetra());

		btnPersonalesOrdenadosPorFecha = new Button("Contactos personales ordenados por fecha");
		btnPersonalesOrdenadosPorFecha.setPrefWidth(250);
		btnPersonalesOrdenadosPorFecha.setOnAction(e -> personalesOrdenadosPorFecha());

		btnClear = new Button("Clear");
		btnClear.setPrefWidth(250);
		btnClear.setPadding(new Insets(40, 0, 0, 0));
		btnClear.setOnAction(e -> clear());

		btnSalir = new Button("Salir");
		btnSalir.setPrefWidth(250);
		btnSalir.setOnAction(e -> salir());

		panel.getChildren().addAll(btnListar, btnPersonalesEnLetra, btnPersonalesOrdenadosPorFecha, btnClear, btnSalir);
		return panel;
	}

	private GridPane crearPanelLetras() {
		// a completar
		GridPane panel = new GridPane();

		return panel;
	}

	private MenuBar crearBarraMenu() {
		// a completar
		MenuBar barra = new MenuBar();

		return barra;
	}

	private void importarAgenda() {
		// a completar

	}

	private void exportarPersonales() {
		// a completar

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
		// a completar
	}

	private void felicitar() {
		clear();
		// a completar

	}

	private void buscar() {
		clear();
		// a completar

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
