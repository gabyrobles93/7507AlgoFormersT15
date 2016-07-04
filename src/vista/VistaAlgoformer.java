package vista;

import javafx.scene.image.ImageView;
import modelo.Algoformer;

public abstract class VistaAlgoformer {

	Algoformer algoformer;
	ImageView vistaalgoformer;

	public abstract void cargar() throws Exception;

}
