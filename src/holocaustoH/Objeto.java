package holocaustoH;

public class Objeto extends ObjetoJuego{
	
 // Propiedades:
	private int peso = 0;
	private String nombreObjeto;
	private Posicion posObjeto;
	private String numArtefacto;

	public Objeto() {
		System.out.println("Se crea un nuevo artefacto.");
		this.peso = 0;			
	}
	public Objeto(String numArtefacto) {
		this.numArtefacto = "";
		System.out.println("Se crea un nuevo artefacto con numeración.");
		this.numArtefacto = numArtefacto;		
	}
	public String getNumArtefacto() {
		return numArtefacto;
	}
	public void setNumArtefacto(String numArtefacto) {
		this.numArtefacto = numArtefacto;
	}
	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	public String getNombreObjeto() {
		return nombreObjeto;
	}

	public void setNombreObjeto(String nombreObjeto) {
		this.nombreObjeto = nombreObjeto;
	}

	public Posicion getPosObjeto() {
		return posObjeto;
	}

	public void setPosObjeto(Posicion posObjeto) {
		this.posObjeto = posObjeto;
	}

}
