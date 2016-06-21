package Vista;

import Modelo.Juego;
import Modelo.Tablero;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class VistaTerreno {
	
	private final TilePane tab;
	
	

	public VistaTerreno(Juego juego, TilePane PaneCentral) {
		this.tab=PaneCentral;
	}


	 public void dibujar() {
	        this.dibujarFormas();
	    }

	    private void dibujarFormas() {
	        this.clean();
	        for(int i=0;i<2500;i++){
	        Rectangle r1= new Rectangle(13,13);
	        r1.setFill(Color.BROWN);
	        
	       
	        tab.getChildren().addAll(r1);
	        }
	        //canvas.getGraphicsContext2D().fillOval(robot.getPosicion().getX() + 230, robot.getPosicion().getY() + 110, robot.RADIO, robot.RADIO);
	    }

	    public void clean() {

	        //canvas.getGraphicsContext2D().setFill(Color.LIGHTBLUE);
	        //canvas.getGraphicsContext2D().fillRect(0, 0, 460, 220);
	    }
	

}
