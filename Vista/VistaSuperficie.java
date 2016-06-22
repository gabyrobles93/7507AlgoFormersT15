package Vista;

import Modelo.Casillero;
import Modelo.Superficie;
import javafx.scene.shape.Rectangle;

public class VistaSuperficie {
	private Superficie supCielo;
	private Rectangle rect;
	private Superficie supTierra;
	
	public VistaSuperficie(Casillero cas,Rectangle rect){
		this.supCielo=cas.getSuperficieCielo();
		this.supTierra=cas.getSuperficieTierra();
		this.rect=rect;
	}
public void dibujar(){
	
}
}
