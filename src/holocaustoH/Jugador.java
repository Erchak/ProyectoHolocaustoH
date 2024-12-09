package holocaustoH;

public class Jugador extends Personaje {
	// Vida del Jugador:
	final static int VIDA_INICIAL = 6;
	
	private int vida = VIDA_INICIAL;
	private boolean piezaHabitacion = false;
	
	private Posicion pos;
	public Jugador() {
        this.pos = new Posicion(1, 1); // Inicialmente en la posición (0,0)
        System.out.println("Creación de un jugador 'J'.");       
	}
    
	public int getVida() {
		return vida;
	}
	
	public void setVida(int vida) {
		this.vida = vida;
	}
	
	public boolean getPiezaHabitacion() {
		return piezaHabitacion;
	}
	
	public void setPiezaHabitacion() {
		this.piezaHabitacion = true;
	}
	public Posicion getPos() { 
		return pos; 
	}

    // Movimiento en el eje X
 // Movimiento en el eje X
    public void movX(int movimientos) {
        int nuevaPosX = pos.getPosX() + movimientos;

        // Obtener la posición de la puerta derecha en la clase Habitacion
        int puertaColumnaDerecha = Habitacion.ancho -1;

        // Verificar si el jugador intenta moverse más allá de la pared derecha y no está en la puerta de salida
        if (nuevaPosX > Habitacion.ancho - 1) {
            System.out.println("¡Movimiento denegado! El jugador no puede ir más allá de la pared derecha.");
        } 
        // Verificar si el jugador está en la puerta de salida
        else if (nuevaPosX > Habitacion.ancho - 1 && pos.getPosY() == puertaColumnaDerecha) {
            System.out.println("¡Felicidades! Has atravesado la puerta de salida.");
            // Aquí puedes implementar lógica adicional, como finalizar el juego.
        } 
        else if (nuevaPosX <= 0) { // No puede ir más allá de la pared izquierda
            System.out.println("¡Movimiento denegado! El jugador no puede ir más allá de la pared izquierda.");
        } else {
            pos.setPosX(nuevaPosX); // Posible causante del error de que J atraviesa la pared.
        }
        System.out.println("Posición actual del jugador: (" + pos.getPosX() + ", " + pos.getPosY() + ")");
    }

        

    

    // Movimiento en el eje Y
    public void movY(int movimientos) {
        int nuevaPosY = pos.getPosY() + movimientos;

        // Verificar si la nueva posición está dentro de los límites de la habitación (excluyendo la puerta de salida)
        if (nuevaPosY <= 0) { // No puede ir más allá de la pared superior
            System.out.println("¡Movimiento denegado! El jugador no puede ir más allá de la pared superior.");
        } else if (nuevaPosY > Habitacion.alto - 1) { // No puede ir más allá de la pared inferior
            System.out.println("¡Movimiento denegado! El jugador no puede ir más allá de la pared inferior.");
        } else {
            pos.setPosY(nuevaPosY);
        }
        System.out.println("Posición actual del jugador: (" + pos.getPosX() + ", " + pos.getPosY() + ")");

    }
}

