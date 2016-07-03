package modelo;

public interface afectable extends movil{

	public void afectarPorEspinas(double coeficiente);
	public void afectarPorPantano(double coeficiente);
	public void afectarPorNebulosaDeAndromeda(int cantidadturnos);
	public void afectarPorTormentaPsionica(double coeficiente);
	public void afectarPorSuperficieRocosa(float coeficiente);
	public void afectarPorSuperficieNubosa(float coeficiente);
	public Efecto getEfecto();
}
