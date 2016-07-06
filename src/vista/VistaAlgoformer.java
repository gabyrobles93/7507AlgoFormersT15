package vista;

import javafx.scene.image.ImageView;
import modelo.Algoformer;

public abstract class VistaAlgoformer {

	Algoformer algoformer;
	ImageView vistaalgoformerHumanoide;
	ImageView vistaalgoformerAlterno;

	public abstract void cargar() throws Exception;
	public void cargarAlterno()throws Exception{}
	public void cambiarModoActualizarRef() {
		// TODO Auto-generated method stub
		
	}

}
