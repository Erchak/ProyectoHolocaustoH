package holocaustoH;

public class Posicion {
	private int posX;
	private int posY;
	
	public Posicion() {
		this.posX=1;
		this.posY=1;
	}

	public Posicion(int posX, int posY) { // La sobrecarga en POO es una característica que permite definir múltiples métodos con el mismo nombre, pero
		this.posX = posX;                 // diferentes parámetros en una misma clase. Esto se conoce como 'sobrecarga de métodos' (method overloading).
		this.posY = posY;
	}

	public int getPosX() {               
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}
    
	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}
	public boolean esIgual(Posicion p) {
		if(p == null) {
		return false;
	}
    return this.posX==p.posX && this.posY==p.posY; 
    }
}
