package vista;

import modelo.Juego;
import vista.Aplicacion;
import vista.controller.BarraDeMenuController;
import vista.controller.MenuAccionesAlgoformerController;
import vista.controller.TableroController;
import vista.controller.VentanaPrincipalController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Aplicacion extends Application {

	public static Juego juego;
	public static HBox msgUsuario;
	public static VBox opcUsuario;
	public static Stage ventanaPrincipal;
	public static VentanaPrincipalController ventanaprincipalcontroller;
	BarraDeMenuController barrademenucontroller;	
	public static MenuAccionesAlgoformerController menuaccionescontroller;
	TableroController tablerocontroller;
	VBox menuAcciones;
	ImageView[][] superficiestierra;
	ImageView[][] superficiescielo;
	
	@Override
	public void start(Stage ventana) throws Exception{
		// TODO Auto-generated method stub
		
		juego = new Juego();
		juego.setPrimerTurno(juego.getAutobots());

		
		superficiestierra = new ImageView[50][50];
		superficiescielo = new ImageView[50][50];
		
		ventanaPrincipal = ventana;
		ventana.setTitle("Algoformers");
		
	
		
		inicializarSuperficies();

		inicializarTableroRaiz();
	
		
		inicializarVentanaPrincipal();	
		ventanaprincipalcontroller.setTablero(tablerocontroller);
		ventanaprincipalcontroller.setVentana(ventanaPrincipal);
			
		inicializarBarraDeMenu();
		
		inicializarAlgoformers();
		
		inicializarChispa();
		
		inicializarPanelAcciones();
		
		setMenuAcciones(menuAcciones);
		 
		mostrarVentanaPrincipal();
		
		mostrarTablero();
				
	}




























	private void inicializarChispa() throws Exception {
		// TODO Auto-generated method stub
		tablerocontroller.cargarChispa();
		tablerocontroller.dibujarChispa();		
	}







	private void mostrarTablero() {
		// TODO Auto-generated method stub
		ventanaprincipalcontroller.mostrarTablero();
	}
private void setMenuAcciones(VBox menu){
	ventanaprincipalcontroller.setMenuAcciones(menu);
}



	private void inicializarSuperficies() {
		// TODO Auto-generated method stub
		for( int fila = 0; fila < 50; fila++){
			for( int columna = 0; columna < 50; columna ++){
			
			VistaSuperficie vistasuperficietierra = VistaSuperficie.crearVista(juego.getTablero().getCasillero(fila, columna).getSuperficieTierra());
			vistasuperficietierra.cargar();
			superficiestierra[fila][columna] = new ImageView();
			superficiestierra[fila][columna] = vistasuperficietierra.getVista();
			
			VistaSuperficie vistasuperficiecielo = VistaSuperficie.crearVista(juego.getTablero().getCasillero(fila, columna).getSuperficieCielo());
			vistasuperficiecielo.cargar();
			superficiescielo[fila][columna] = new ImageView();
			superficiescielo[fila][columna] = vistasuperficiecielo.getVista();
			
			}
		}
	}




	private void inicializarTableroRaiz() throws Exception{
		// TODO Auto-generated method stub
	
		tablerocontroller = new TableroController(juego);
		
		tablerocontroller.inicializar(superficiestierra, superficiescielo);
	}

	private void inicializarAlgoformers() throws Exception{
		// TODO Auto-generated method stub
		tablerocontroller.cargarAlgoformers(juego.autobots, juego.decepticons);
		tablerocontroller.dibujarAlgoformers();
	}

	private void inicializarBarraDeMenu() throws Exception{
		// TODO Auto-generated method stub
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Aplicacion.class.getResource("BarraDeMenu.fxml"));
		loader.load();
		
		barrademenucontroller = (BarraDeMenuController) loader.getController();
		barrademenucontroller.setControllers(tablerocontroller, ventanaprincipalcontroller);
		barrademenucontroller.setStage(ventanaPrincipal);
		ventanaprincipalcontroller.setBarraDeMenu(barrademenucontroller.getBarraDeMenu());
		
	}


	private void mostrarVentanaPrincipal() {
		// TODO Auto-generated method stub
		ventanaprincipalcontroller.mostrarVentanaPrincipal(ventanaPrincipal);
	}


	private void inicializarVentanaPrincipal() throws Exception{
		// TODO Auto-generated method stub
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Aplicacion.class.getResource("VentanaPrincipal.fxml"));
		loader.load();
		
		ventanaprincipalcontroller = (VentanaPrincipalController) loader.getController();
	}
	private void inicializarPanelAcciones() throws Exception{
		// TODO Auto-generated method stub
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Aplicacion.class.getResource("MenuAccionesAlgoformer2.fxml"));
		menuAcciones=loader.load();
		
		menuaccionescontroller =  loader.getController();
		menuaccionescontroller.setTableroController(tablerocontroller);
	}
	

}
