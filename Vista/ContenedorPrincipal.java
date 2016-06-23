package Vista;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import src.modelo.Robot;
import Vista.eventos.AtacarEventHandler;

import Vista.eventos.BotonMoverHandler;
import Vista.eventos.BotonSeleccionarAlgoformerEventHandler;
import Modelo.Algoformer;
import Modelo.Equipo;
import Modelo.Juego;


public class ContenedorPrincipal extends BorderPane {
	Equipo equipoJugador;
	Equipo equipoExpectador;
    BarraDeMenu menuBar;
    VistaAlgoformer vistaAlgoformer;
    GridPane PaneCentral;
    VBox contenedorCentral;
    boolean ModoSeleccionar;
    VistaTerreno vistaTerreno;

    public ContenedorPrincipal(Stage stage, Juego juego) {
        this.setMenu(stage);
        this.setCentro(juego);
        this.setConsola();
        this.setBotonera(juego);
        this.setModoSeleccionar(true);
      
    }

    private void setBotonera(Juego juego) {
    	
    
        /*VBox contenedorVertical = new VBox(Autobots,botonOptimus, botonBumblebee,botonRatchet);
        contenedorVertical.setSpacing(10);
        contenedorVertical.setPadding(new Insets(15));
        contenedorVertical.setAlignment(Pos.CENTER_RIGHT);
        this.setLeft(contenedorVertical);
*/
    
     /*   VBox contenedorVertical2 = new VBox(Decepticons,botonMegatron, botonBonecrusher,botonFrenzy);
        contenedorVertical2.setSpacing(10);
        contenedorVertical2.setPadding(new Insets(15));
        contenedorVertical2.setAlignment(Pos.CENTER_RIGHT);

        this.setRight(contenedorVertical2);
       */ 
        
        
        
    }

    private void setMenu(Stage stage) {
        this.menuBar = new BarraDeMenu(stage);
        this.setTop(menuBar);
    }

    private void setCentro(Juego juego) {

        PaneCentral = new GridPane();
        
        PaneCentral.setBorder(new Border(new BorderStroke(Color.BLACK,BorderStrokeStyle.SOLID,null,new BorderWidths(3))));
        
      
      PaneCentral.setMaxSize(50*14 +7,50*14 +7);
      
       
        vistaTerreno= new VistaTerreno(juego,PaneCentral,this);
        vistaTerreno.dibujar();
       

        contenedorCentral = new VBox(PaneCentral);
        contenedorCentral.setAlignment(Pos.CENTER);
        contenedorCentral.setSpacing(20);
        contenedorCentral.setPadding(new Insets(25));
        Image imagen = new Image("file:Vista/imagenes/fondo-verde.jpg");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        contenedorCentral.setBackground(new Background(imagenDeFondo));

        this.setCenter(contenedorCentral);
    }

    private void setConsola() {

        // TODO cambiar por el modelo de Consola...
        Label etiqueta = new Label();
        etiqueta.setText("consola...");
        etiqueta.setFont(Font.font("courier new", FontWeight.SEMI_BOLD, 14));
        etiqueta.setTextFill(Color.WHITE);

        VBox contenedorConsola = new VBox(etiqueta);
        contenedorConsola.setSpacing(10);
        contenedorConsola.setPadding(new Insets(15));
        contenedorConsola.setStyle("-fx-background-color: black;");

        this.setBottom(contenedorConsola);
    }

    public BarraDeMenu getBarraDeMenu() {
        return menuBar;
    }

	public void setModoSeleccionar(boolean b) {
		ModoSeleccionar=b;
		
	}
	public boolean modoSeleccionar(){
		return ModoSeleccionar;
	}

	public boolean modoRango() {
		// TODO Auto-generated method stub
		return vistaTerreno.ModoRango();
	}

	public void setModoRango(boolean b) {
		vistaTerreno.setModoRango(b);
		
	}

}
