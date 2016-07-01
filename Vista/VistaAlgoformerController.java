package Vista;

import Modelo.Algoformer;
import javafx.stage.Stage;

public class VistaAlgoformerController {

	protected Algoformer algof;
	protected TableroController controllerTablero;
	protected Stage ventana_acciones;
	
	public void setAlgoformer(Algoformer algof2) {
		// TODO Auto-generated method stub
		this.algof=algof2;
	}
	
	public void cerrarMenu(){
		ventana_acciones.close();
	}
	public void setControllerTablero(TableroController tab){
		this.controllerTablero=tab;
	}
	
	public void update() {
		
		controllerTablero.redibujarAlgoformers();
	}
	
	public void mostrarMenuAcciones(){}
	
	public void dibujar() {}


}
