package holocaustoH;

public class AgujeroNegro {
	
    private Posicion pos;
	
	public AgujeroNegro() {
		System.out.println("Creación de un agujero negro: 'A'.");
	}
	public void setPosAgujeroNegro(Posicion pos) { // PosAgujeroNegro para establecerse debe tener el mismo nombre en su llamada en la clase HolocaustoH.
		this.pos = pos;
	}
	public Posicion getPosAgujeroNegro() {
		return pos;
	}
}
