package Vista;

import Modelo.Casillero;
import Modelo.Superficie;
import Modelo.SuperficieCielo;
import Modelo.SuperficieEspinosa;
import Modelo.SuperficieNebulosaDeAndromeda;
import Modelo.SuperficieNubosa;
import Modelo.SuperficiePantanosa;
import Modelo.SuperficieRocosa;
import Modelo.SuperficieTierra;
import Modelo.SuperficieTormentaPsionica;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;

public abstract class VistaSuperficie {

	
	public VistaSuperficie(){
		
	}
	
public abstract void dibujar(GridPane tablero,int fila,int columna);

public static VistaSuperficie crearVista(Superficie superficie) {
	// TODO Auto-generated method stub
	SuperficieTierra supPant=new SuperficiePantanosa();
	
	SuperficieTierra supEsp=new SuperficieEspinosa();
	
	SuperficieTierra supRoc=new SuperficieRocosa();
	
	SuperficieCielo supNub=new SuperficieNubosa();
	
	SuperficieCielo supTorm=new SuperficieTormentaPsionica();
	
	SuperficieCielo supNebulosa=new SuperficieNebulosaDeAndromeda();
	
	
	
	
	if(superficie.equals(supPant)){
		return new VistaPantano();
	}else if(superficie.equals(supEsp)){
		return new VistaEspinosa();
	}else if(superficie.equals(supRoc)){
		return new VistaRocosa();
	}else if(superficie.equals(supNub)){
		return new VistaNubosa();
	}else if (superficie.equals(supTorm)){
		return new VistaTormentaPsionica();
		
	}else if(superficie.equals(supNebulosa)){
		return new VistaNebulosaDeAndromeda();
	}else{
		throw new ErrorAlDibujarSuperficie();
	}
	
}
}
