package holocaustoH;

public class Habitacion {
	
//  Tamaño de la habitación:
	
	public static final int alto = 9; // 'final' hace que un valor sea constante e inmutable durante la ejecución del programa. No puede cambiar después 
	public static final int ancho = 10; // de su inicialización en ninguna parte del código.
	
	// Variables para las posiciones fijas de las puertas: (Para evitar la continua aleatoriedad de las puertas cada vez que se realiza un movimiento del
    private Integer puertaIzquierdaFija;                   // jugador).
    private Integer puertaDerechaFija;
    
    private static Integer puertaColumnaDerecha;
    
 // Método para obtener la posición de la puerta derecha
    public static int getPuertaColumnaDerecha() {
        return puertaColumnaDerecha != null ? puertaColumnaDerecha : -1; // -1 si no está definida
    }
    
    public Integer getPuertaIzquierdaFija() {
		return puertaIzquierdaFija;
	}

	public void setPuertaIzquierdaFija(Integer puertaIzquierdaFija) {
		this.puertaIzquierdaFija = puertaIzquierdaFija;
	}

	public Integer getPuertaDerechaFija() {
		return puertaDerechaFija;
	}

	public void setPuertaDerechaFija(Integer puertaDerechaFija) {
		this.puertaDerechaFija = puertaDerechaFija;
	}
	//  Puertas:                          // 'static' significa que la variable o el método pertenece a la clase y no a una instancia (u objeto) de la clase. 
	                                  //  Por lo tanto, se puede acceder a los miembros static sin crear un objeto de esa clase.
	private Posicion puertaEntrada;
	private Posicion puertaSalida;
	
 // Conjunto de Objetos de Juego:
	private ObjetoJuego[] objetosJ = new ObjetoJuego[20]; // objetosJ son los elementos del juego: Jugador, Hadrón, Artefacto, Mochila etc. Máx 20.
	private int numObjetos= 0;
	
 // Hacemos una copia del jugador:
	
	private Personaje j;
	
	public Habitacion() { // Constructor.
		System.out.println("Creación de una habitación: 'N'.");
		this.puertaEntrada = new Posicion(1, 2);
		this.puertaSalida = new Posicion();
	}

	public Posicion getPuertaEntrada() {
		return puertaEntrada;
	}

	public void setPuertaEntrada(Posicion puertaEntrada) {
		this.puertaEntrada = puertaEntrada;
	}

	public Posicion getPuertaSalida() {
		return puertaSalida;
	}

	public void setPuertaSalida(Posicion puertaSalida) {
		this.puertaSalida = puertaSalida;
	}
	public boolean esunaPuerta(Posicion p) {
		if (p == null) return false;
	        return p.esIgual(puertaEntrada) || p.esIgual(puertaSalida);
	    }
	    	
	public void setJugador(Jugador j) { // Revisar esta línea de código por si interfiere más adelante en el avance del proyecto, si es necesario, eliminar.
		this.j = j;
	}
	
	public void setObjetoJ(ObjetoJuego obj) {
		objetosJ[numObjetos] = obj;
		numObjetos++;
	}
	
	public ObjetoJuego getObjetoJ(int posObj) { // Verificar si es posObj o funciona bien con objPos.
		return objetosJ[posObj];
	}
	
	public void eliminarObjetoJ(int objPos) {
		int posObjetos=0;
		for (int i=0;i<numObjetos;i++) {
			if(objPos!=i) {
				objetosJ[posObjetos]=objetosJ[i];
				posObjetos++;
			}
		}
		numObjetos--;
	}
	
	public int hayObjeto(Posicion p) {
		for (int i=0; i < numObjetos; i++) {
			ObjetoJuego obj = objetosJ[i];
			Posicion objPosicion = obj.getPos();
			if(p.esIgual(objPosicion) || p.esIgual(objPosicion)) return i;			
		}
	    return -1; // Devuelve un -1 cuando no hay nada, ningún objeto: Jugador, Puerta, Hadrón etc.
	}
	public int hayObjetoSinJugador(Posicion p) {
		for (int i=1; i < numObjetos; i++) {
			ObjetoJuego obj = objetosJ[i];
			Posicion objPosicion = obj.getPos();
			if(p.esIgual(objPosicion) || p.esIgual(objPosicion)) return i;			
		}
	    return -1; // Devuelve un -1 cuando no hay nada, ningún objeto: Jugador, Puerta, Hadrón etc.
	}
	public Personaje getPosJugador() {
		return j;
	}
}

