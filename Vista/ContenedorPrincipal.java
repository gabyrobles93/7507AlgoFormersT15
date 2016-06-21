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
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
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

import Modelo.Juego;


public class ContenedorPrincipal extends BorderPane {

    BarraDeMenu menuBar;
    VistaAlgoformer vistaAlgoformer;
    TilePane PaneCentral;
    VBox contenedorCentral;

    public ContenedorPrincipal(Stage stage, Juego juego) {
        this.setMenu(stage);
        this.setCentro(juego);
        this.setConsola();
        this.setBotonera(juego);
    }

    private void setBotonera(Juego juego) {
    	
    	Text Autobots = new Text("Autobots");
    	Autobots.setTextAlignment( TextAlignment.LEFT );
    	
    	  MenuItem Atacar4=new MenuItem("atacar");
    	  MenuItem Mover1=new MenuItem("mover");
    	  
      	VistaAlgoformer vistaRatchet = new VistaAlgoformer(juego.getAutobots().getRatchet(),PaneCentral);
      	
      	Atacar4.setOnAction(new AtacarEventHandler(vistaRatchet,PaneCentral));
      	Mover1.setOnAction(new BotonMoverHandler(vistaRatchet,juego.getAutobots().getRatchet()));
      	
          MenuButton botonRatchet = new MenuButton("Ratchet",null,Atacar4,Mover1 );
          
          BotonSeleccionarAlgoformerEventHandler RatchetButtonHandler = new BotonSeleccionarAlgoformerEventHandler(vistaRatchet,juego.getDecepticons().getBonecrusher());
          botonRatchet.setOnAction(RatchetButtonHandler);

          MenuItem Atacar5=new MenuItem("atacar");
          MenuItem Mover2=new MenuItem("mover");
          
      	VistaAlgoformer vistaBumblebee= new VistaAlgoformer(juego.getAutobots().getBumblebee(),PaneCentral);
      	
      	Atacar5.setOnAction(new AtacarEventHandler(vistaBumblebee,PaneCentral));
      	Mover2.setOnAction(new BotonMoverHandler(vistaBumblebee,juego.getAutobots().getBumblebee()));
      	
          MenuButton botonBumblebee = new MenuButton("Bumblebee",null,Atacar5,Mover2 );
          
          BotonSeleccionarAlgoformerEventHandler BumblebeeButtonHandler = new BotonSeleccionarAlgoformerEventHandler(vistaBumblebee,juego.getDecepticons().getBonecrusher());
          botonBumblebee.setOnAction(BumblebeeButtonHandler);
        
          MenuItem Atacar6=new MenuItem("atacar");
          MenuItem Mover3=new MenuItem("mover");
          
      	VistaAlgoformer vistaOptimus = new VistaAlgoformer(juego.getAutobots().getOptimus(),PaneCentral);
      	
      	Atacar6.setOnAction(new AtacarEventHandler(vistaOptimus,PaneCentral));
      	Mover3.setOnAction(new BotonMoverHandler(vistaOptimus,juego.getAutobots().getOptimus()));
      	
          MenuButton botonOptimus = new MenuButton("Optimus",null,Atacar6,Mover3 );
          
          BotonSeleccionarAlgoformerEventHandler OptimusButtonHandler = new BotonSeleccionarAlgoformerEventHandler(vistaOptimus,juego.getDecepticons().getBonecrusher());
          botonOptimus.setOnAction(OptimusButtonHandler);
        
        
        VBox contenedorVertical = new VBox(Autobots,botonOptimus, botonBumblebee,botonRatchet);
        contenedorVertical.setSpacing(10);
        contenedorVertical.setPadding(new Insets(15));
        contenedorVertical.setAlignment(Pos.CENTER_RIGHT);

        this.setLeft(contenedorVertical);

        Text Decepticons = new Text("Decepticons");
    	Decepticons.setTextAlignment( TextAlignment.LEFT );
    	
    	MenuItem Atacar1=new MenuItem("atacar");
    	MenuItem Mover4=new MenuItem("mover");
    	
    	VistaAlgoformer vistaMegatron = new VistaAlgoformer(juego.getDecepticons().getMegatron(),PaneCentral);
    	Atacar1.setOnAction(new AtacarEventHandler(vistaMegatron,PaneCentral));
    	Mover4.setOnAction(new BotonMoverHandler(vistaMegatron,juego.getDecepticons().getMegatron()));
    	
        MenuButton botonMegatron = new MenuButton("Megatron",null,Atacar1,Mover4 );
       
        BotonSeleccionarAlgoformerEventHandler MegatronButtonHandler = new BotonSeleccionarAlgoformerEventHandler(vistaAlgoformer, juego.getDecepticons().getMegatron());
        
        
        MenuItem Atacar2=new MenuItem("atacar");
        MenuItem Mover5=new MenuItem("mover");
        
    	VistaAlgoformer vistaBonecrusher = new VistaAlgoformer(juego.getDecepticons().getBonecrusher(),PaneCentral);
    	Atacar2.setOnAction(new AtacarEventHandler(vistaBonecrusher,PaneCentral));
    	Mover5.setOnAction(new BotonMoverHandler(vistaBonecrusher,juego.getDecepticons().getBonecrusher()));
    	
        MenuButton botonBonecrusher = new MenuButton("Bonecrusher",null,Atacar2 ,Mover5);
        
        BotonSeleccionarAlgoformerEventHandler BonecrusherButtonHandler = new BotonSeleccionarAlgoformerEventHandler(vistaBonecrusher,juego.getDecepticons().getBonecrusher());
        botonBonecrusher.setOnAction(BonecrusherButtonHandler);
        
        MenuItem Atacar3=new MenuItem("atacar");
        MenuItem Mover6=new MenuItem("mover");
        
    	VistaAlgoformer vistaFrenzy = new VistaAlgoformer(juego.getDecepticons().getFrenzy(),PaneCentral);
    	Atacar3.setOnAction(new AtacarEventHandler(vistaFrenzy,PaneCentral));
    	Mover6.setOnAction(new BotonMoverHandler(vistaFrenzy,juego.getDecepticons().getFrenzy()));
    	
        MenuButton botonFrenzy = new MenuButton("Frenzy",null,Atacar3,Mover6 );
        
        BotonSeleccionarAlgoformerEventHandler FrenzyButtonHandler = new BotonSeleccionarAlgoformerEventHandler(vistaFrenzy,juego.getDecepticons().getFrenzy());
        botonFrenzy.setOnAction(FrenzyButtonHandler);
        
        
        VBox contenedorVertical2 = new VBox(Decepticons,botonMegatron, botonBonecrusher,botonFrenzy);
        contenedorVertical2.setSpacing(10);
        contenedorVertical2.setPadding(new Insets(15));
        contenedorVertical2.setAlignment(Pos.CENTER_RIGHT);

        this.setRight(contenedorVertical2);
        
        
        
        
    }

    private void setMenu(Stage stage) {
        this.menuBar = new BarraDeMenu(stage);
        this.setTop(menuBar);
    }

    private void setCentro(Juego juego) {

        PaneCentral = new TilePane();
        PaneCentral.setHgap(1);
        PaneCentral.setVgap(1);
        PaneCentral.setBorder(new Border(new BorderStroke(Color.BLACK,BorderStrokeStyle.SOLID,null,new BorderWidths(3))));
        
      PaneCentral.setPrefColumns(50);
      PaneCentral.setPrefRows(50);
      PaneCentral.setMaxSize(50*14 +7,50*14 +7);
       
        VistaTerreno  vistaTerreno= new VistaTerreno(juego, PaneCentral);
        vistaTerreno.dibujar();
       

        contenedorCentral = new VBox(PaneCentral);
        contenedorCentral.setAlignment(Pos.CENTER);
        contenedorCentral.setSpacing(20);
        contenedorCentral.setPadding(new Insets(25));
        Image imagen = new Image("file:src/vista/imagenes/fondo-verde.jpg");
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

}
