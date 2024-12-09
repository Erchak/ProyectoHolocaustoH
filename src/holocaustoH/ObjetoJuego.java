package holocaustoH;

public class ObjetoJuego {
	// Tipos de ObjetoJuego:
	final static int JUGADOR=0;
	final static int HADRON=1;
	final static int PIEZA=2;
	final static int OBJETO=3;
	final static int PUERTA_INICIAL=4;
	final static int PUERTA_FINAL=5;
	
	 // Propiedades:
		private String nombre;
		private Posicion pos;		
	//  Letra en mapa:
		private char letraMapa= ' '; // Para caracteres ASCII simples.
		private String simboloMapa = " "; // Para usar símbolos Unicode.
		private int tipoObjeto = -1;
         
		// Getter y setter para símbolos más visuales
	    public String getSimboloMapa() {
	        return simboloMapa;
	    }

	    public void setSimboloMapa(String simboloMapa) {
	        this.simboloMapa = simboloMapa;
	    }

	    // Método para obtener la representación a pintar
	    public String getVisualRepresentation() {
	        return simboloMapa.isEmpty() ? String.valueOf(letraMapa) : simboloMapa;
	    }
	
		public ObjetoJuego() {
			
		}
				
		public String getNombre() {
			return nombre;
		}
		
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public Posicion getPos() {
			return pos;
		}

		public void setPos(Posicion pos) {
			this.pos = pos;
		}

		public char getLetraMapa() {
			return letraMapa;
		}

		public void setLetraMapa(char letraMapa) {
			this.letraMapa = letraMapa;
		}
		public void setTipoObjeto(int tipoObjeto) {
			this.tipoObjeto  = tipoObjeto;
		}
		public int getTipoObjeto() {
			return tipoObjeto;
		}
	}	
