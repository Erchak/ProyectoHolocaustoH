package holocaustoH;

public class Mochila {
	
	private int espacioMochila;
	private Posicion posMochila;

	public Mochila() {
		System.out.println("Encontrar mochila.");
	}

	public int getEspacioMochila() {
		return espacioMochila;
	}

	public void setEspacioMochila(int espacioMochila) {
		this.espacioMochila = espacioMochila;
	}

	public Posicion getPosMochila() {
		return posMochila;
	}

	public void setPosMochila(Posicion posMochila) {
		this.posMochila = posMochila;
	}
}
