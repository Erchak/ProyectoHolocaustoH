package holocaustoH;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom; // Esta clase genera números aleatorios.

public class Juego {
	
	final static int Lanzar_dado = 1;
	final static int Salir_juego = 0;
	
	static Posicion[] posiciones=new Posicion[20];
	static int numPosiciones=0;

	public Juego() {
		
	}
    public static void pintarHabitacion(Habitacion h) {

    	if (h == null) {
    		System.out.println("La habitación no ha sido inicializada.");
    		return;
    	}
    	
    	Personaje jugador = h.getPosJugador();
    	if (jugador == null) {
    		System.out.println("El jugador no ha sido asignado a la habitación.");
    		return;
    	}
    	
    	Posicion posJugador = jugador.getPos();
    	if (posJugador == null) {
    		System.out.println("La posición del jugador es nula.");
    		return;
    	}
    	
    	int posXJugador = posJugador.getPosX();
    	int posYJugador = posJugador.getPosY();
    	
    	Random random = new Random();
    	
    	// Con las siguientes variables creamos las posiciones aleatorias para las puertas de nuestro mapa:
    	
    	int puertaColumnaIzquierda; // Evitamos la primera y última fila. (De la columna izquierda).
    	int puertaColumnaDerecha = random.nextInt(Habitacion.alto);         // Evitamos la primera y última fila. (De la columna derecha).
    	                                                                    // Hacemos esto con la finalidad de evitar las esquinas para la ubicación de
    	                                                                    // las puertas, por temas de jugabilidad y apariencia del mapa.
    	if (h.getPuertaIzquierdaFija() == null) {
            puertaColumnaIzquierda = random.nextInt(Habitacion.alto - 3) + 2;
            h.setPuertaIzquierdaFija(puertaColumnaIzquierda);
        } else {
            puertaColumnaIzquierda = h.getPuertaIzquierdaFija();
        }

        if (h.getPuertaDerechaFija() == null) {
            do {
                puertaColumnaDerecha = random.nextInt(Habitacion.alto - 3) + 2;
            } while (puertaColumnaIzquierda == puertaColumnaDerecha);
            h.setPuertaDerechaFija(puertaColumnaDerecha);
        } else {
            puertaColumnaDerecha = h.getPuertaDerechaFija();
        }
    	
    	   		    	  	
    	for(int fila = -1; fila < Habitacion.alto; fila++) {  
    		
    		for(int columna = 0; columna <= Habitacion.ancho; columna++) {  
    			Posicion posicionActual = new Posicion(columna,fila);
    	        int posObj = h.hayObjeto(posicionActual);
    	        
    	        if(posObj != -1) {
    	        	ObjetoJuego objJ= h.getObjetoJ(posObj);
    	        	if(objJ.getTipoObjeto() == ObjetoJuego.PUERTA_FINAL)
    	        		if(((Jugador)h.getObjetoJ(0)).getPiezaHabitacion()) {
    	        	        System.out.print(objJ.getLetraMapa());
    	        }
    			// Verificar si el jugador está en la misma posición que la puerta derecha.
    	        if (fila == puertaColumnaDerecha && columna == Habitacion.ancho && 
    	            posJugador.getPosX() == Habitacion.ancho -1 && posJugador.getPosY() == puertaColumnaDerecha) {
    	            System.out.print("⌞__⌟"); // Imprime el símbolo de apertura de la puerta
    	            System.out.print("¡Has alcanzado la puerta de salida! ¡Felicidades, ganaste!");
    	            continue; // continue; se utiliza dentro de los bucles (for, while, do-while) para omitir el resto del código dentro del bucle en la 
    	                      // iteración actual y continuar con la siguiente iteración del bucle. De esta maner, se evita imprimir la puerta o cualquier
    	                      // otra cosa.
    	        }
    			// Este primer if corresponde a la posición en donde estará ubicada nuestra puerta izquierda: (Columna izquierda).
    			if (columna == 0 && fila == puertaColumnaIzquierda) {   			    
    			   System.out.print("["); // Imprimimos la puerta izquierda.
    			}
    			
    	        
    			// El segundo if corresponde a la puerta de la posición de la columna derecha: (Solo si el jugador no está ahí)
    		    else if (columna == Habitacion.ancho - 1 && fila == puertaColumnaDerecha && 
    		    		!(posJugador.getPosX() == Habitacion.ancho - 1 && posJugador.getPosY() == puertaColumnaDerecha) ) { // El símbolo '!' se encarga
    			   System.out.print("]"); // Imprimimos la puerta derecha.                                           // de verificar que el jugador no es-
    			}                                                            // té en la posición que está negando para poder dibujar la puerta. Si el ju-
    			                // gador ya está en dicha posición, no se dibujará la puerta, porque se estará dando prioridad al símbolo del jugador "J" o
    			                                                                       // a la apertura de la puerta.
    	// Dibujar al jugador:
    		    else if (fila == posJugador.getPosY() && columna == posJugador.getPosX()) {
    		    	System.out.print("J");
    		    }
    	// Imprimimos la primera fila excepto la última posición: (0 - 12)		
    		    else if (fila == -1 && columna != Habitacion.ancho) System.out.print(columna); // Imprime hacia abajo la sucesión de números comprendi-
    			                                                                                 // da entre los valores 0 y 12.
    			else if (columna == Habitacion.ancho && fila != -1) System.out.print(fila);   // Paredes izquierda y derecha. (13 - 1 = 12)
    			    // Columna 0 = La primera barra lateral (|) dibujada a la izquierda.
    			                         // Columna 12 = La última barra lateral (|) dibujada a la derecha.
    		//	else if (h.esunaPuerta(posicionActual)) System.out.print("");
    			
    			else if (columna == 0 || columna == Habitacion.ancho -1) { 
     			   System.out.print("|");
     			   
     			}
    			else if (fila == 0 || fila == Habitacion.alto -1) { // Paredes superior e inferior. (Fila 0 y fila 8)
    			   System.out.print("_");
    			}
    			else { // Espacio vacío en el resto de la habitación.
    			   System.out.print(" ");
    			}
    			
    			// Salto de línea al final de cada fila.
    						
    		}
    	
    		}
    	}
    	System.out.println("");
    }
       public static void pintarMenu() {
    	System.out.println("");
    	System.out.println("-------------- HOLOCAUSTO H (HADRON) --------------");    	
   		System.out.println("         [1] LANZAR DADO DE MOVIMIENTO");
   		System.out.println("               [0] SALIR DEL JUEGO");
   		System.out.println("---------------------------------------------------");
   		
    }
       	
	public static void resolverObjeto(ObjetoJuego obj) {
		System.out.println("--------------        OBJETO         --------------");
		System.out.println(obj.getClass().getName());
		System.out.println("---------------------------------------------------");
	}
	
	public static int explotaHadron(int vidaPerdida) {
		int muerte = -1;
		System.out.println("------------------  HADRÓN  -------------------");
		System.out.println("¡¡¡¡¡ HAS CHOCADO CON UN HADRÓN !!!!!");
		System.out.println("Has perdido " +vidaPerdida+" puntos de vida.");
		if(vidaPerdida >= Jugador.VIDA_INICIAL) {
			System.out.println("----> Estás Muerto <----");
			muerte = Juego.Salir_juego;
		}
		else System.out.println("¡Qué suerte!, puedes continuar.");
		System.out.println("-----------------------------------------------");
		return muerte;
	}
	public static void habitacionSuperada(Habitacion h) {
		System.out.println("--------------  HABITACIÓN SUPERADA  --------------");
		Juego.pintarHabitacion(h);
		System.out.println("--------------------¡Continúa!-------------------");
	}
	
	public static int lanzarDado(int numCaras) {
 	   int dado = ThreadLocalRandom.current().nextInt(1, numCaras+1); // int java.util.concurrent.ThreadLocalRandom.nextInt (int origin,  int bound) el primer 
 	   System.out.println("[Dado Lanzado] = "+dado);           // parámetro (origin) es el valor mínimo y el segundo parámetro (bound) es exclusivo, es 
 	                                                         // decir, el valor máximo no se incluye en el rango.
        return dado;
 	                                                         // Si deseamos simular un dado con valores entre 1 y 6, necesitamos establecer origin en
 	                                                         // 1 y bound en 7 para que el rango sea [1, 7), es decir, de 1 a 6 incluisive. De lo con-
 	                                                         // trario, si defines bound como 6, los valores posibles serán solo del 1 al 5.
    }
	 public static Posicion posAleatoria() {
	   		int posX=ThreadLocalRandom.current().nextInt(2, Habitacion.ancho-2);
	   		int posY=ThreadLocalRandom.current().nextInt(2, Habitacion.alto-2);
	   		Posicion posTemp=new Posicion(posX,posY);
	   		//Comprobación de todas las posiciones diferentes
	   		if(numPosiciones>0) {
	   			for(int i=0;i<numPosiciones;i++) {
	   				if(posTemp.esIgual(posiciones[i])) {
	   					posX=ThreadLocalRandom.current().nextInt(2, Habitacion.ancho-2);
	   					posY=ThreadLocalRandom.current().nextInt(2, Habitacion.alto-2);
	   					posTemp.setPosX(posX);
	   					posTemp.setPosX(posY);
	   					i=0;
	   				}
	   			}
	   		}
	   		posiciones[numPosiciones]=posTemp;
	   		numPosiciones++;
	   		return posiciones[numPosiciones-1];
	   	}
}




















 