package vista;

import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import modelo.Superficie;
import modelo.SuperficieCielo;
import modelo.SuperficieEspinosa;
import modelo.SuperficieNebulosaDeAndromeda;
import modelo.SuperficieNubosa;
import modelo.SuperficiePantanosa;
import modelo.SuperficieRocosa;
import modelo.SuperficieTierra;
import modelo.SuperficieTormentaPsionica;

public abstract class VistaSuperficie {
	
	ImageView vista_superficie;

	public abstract void cargar();

	public static VistaSuperficie crearVista(Superficie superficie) {
		// TODO Auto-generated method stub
		SuperficieTierra supPant = new SuperficiePantanosa();
		
		SuperficieTierra supEsp = new SuperficieEspinosa();
		
		SuperficieTierra supRoc = new SuperficieRocosa();
		
		SuperficieCielo supNub = new SuperficieNubosa();
		
		SuperficieCielo supTorm = new SuperficieTormentaPsionica();
		
		SuperficieCielo supNebulosa = new SuperficieNebulosaDeAndromeda();
		
			
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
		//	throw new ErrorAlDibujarSuperficie();
		}
		return null;	
	}

	public ImageView getVista(){
		return vista_superficie;
	}

}
