package holocaustoH;     // Agregar las siguientes funciones: Control de movimientos cuando llegan a 0, El jugador no aparezca en una de las paredes.
import java.util.Scanner;                                             // Controlar la sumatoria correctamente "www, por ejemplo: -1, // El jugador no debe
public class HolocaustoH {                                                                                            // salir del mapa o la habitación.

	public static void main(String[] args) {
		int accionJuego = -1;
		Scanner in = new Scanner(System.in);
		int objeto = 0;
		
	//	Posicion posInicial = new Posicion();
	//	posInicial.setPosX(3); // Establecer directamente la posición del jugador en los valores de 'x' e 'y'.
	//	posInicial.setPosY(0);
		Posicion pInicial = new Posicion(0,3); // Establecer la posición en 'blanco' (0,0) o con un valor dado, por ejemplo: (3,4).
		Posicion pFinal = new Posicion(3, Habitacion.alto -1); // pInicial = Puerta Inicial. Establecer aquí la puerta de Salida.
		ObjetoJuego puertaInicial = new ObjetoJuego();
		puertaInicial.setPos(pInicial);
		puertaInicial.setLetraMapa(' ');
		puertaInicial.setTipoObjeto(ObjetoJuego.PUERTA_INICIAL);
		ObjetoJuego puertaFinal = new ObjetoJuego();
		puertaFinal.setPos(pFinal);
		puertaFinal.setLetraMapa(' ');
		puertaInicial.setTipoObjeto(ObjetoJuego.PUERTA_FINAL);
		
		// Generamos los 2 primeros objetos:
		
		Habitacion hab = new Habitacion();
		
				
		// Generamos el jugador y lo almacenamos en la Habitación:
	//	Posicion puertaInicialJ = new Posicion(puertaInicial.getPosX(), puertaInicial.getPosY()); -> Revisar línea de código si genera error sin ella.
		Jugador jugador = new Jugador();
		Posicion posicion = jugador.getPos();
		jugador.setSimboloMapa("🧍");
		jugador.setPos(pInicial); // Revisar si funciona con posInicial sino, cambiar a puertaEntrada e investigar cómo hacerlo.
		jugador.setLetraMapa('J');
		jugador.setTipoObjeto(ObjetoJuego.JUGADOR);
		
		// Generamos el Hadrón y lo almacenamos en la Habitación:
		Hadron hadron = new Hadron();		
		Posicion pH = new Posicion(3,5); // pH = Posición Hadrón.
		hadron.setSimboloMapa("⚛️");
		hadron.setPos(pH); 
		hadron.setLetraMapa('O'); // Hadrón pasa de ser 'H' a 'O' pues será un objeto oculto que podrá ser el mismo hadrón o cualquier otro objeto.
		hadron.setTipoObjeto(ObjetoJuego.HADRON);
				
		// Luego el objeto Agujero Negro:
		AgujeroNegro agujeronegro = new AgujeroNegro();
		                                                   // .setPosAgujeroNegro (mismo nombre que en .set de la clase AgujeroNegro)
		hab.setObjetoJ(jugador);
		
		
		jugador.setPos(pInicial);
		                               
	
		
		
	 // Generamos una nueva pieza
		ObjetoJuego pieza = new ObjetoJuego();
		Posicion pPieza = Juego.posAleatoria();
		pieza.setPos(pPieza);
		pieza.setLetraMapa('P');
		pieza.setTipoObjeto(ObjetoJuego.PIEZA);
		
	// Generamos un nuevo objeto oculto
		ObjetoJuego objOculto = new ObjetoJuego();
		Posicion pobjOculto = Juego.posAleatoria();
		objOculto.setPos(pobjOculto);
		objOculto.setLetraMapa('O');
		objOculto.setTipoObjeto(ObjetoJuego.OBJETO);
		
		//  Generamos la habitación y sus elementos.			
		Habitacion hab1 = new Habitacion();
		hab1.setJugador(jugador);
		hab1.setObjetoJ(hadron);
		hab.setObjetoJ(puertaInicial);
		hab.setObjetoJ(puertaFinal);
		hab1.setObjetoJ(pieza);
		hab1.setObjetoJ(objOculto);
		
		
		while(accionJuego != Juego.Salir_juego) { // En vez de usar un 0 declarado de forma estática, utilizaremos la llamada a la variable "int Salir_ju-
		int numMov = 0;	                          // ego = 1;" declarada en nuestra clase Juego. Así mantenemos la legibilidad y mantenibilidad del código
	// Pintamos la habitación:                    // utilizando nombres descriptivos y entregando, a través de dichos nombres, un contexto que nos permite
		                                          // entender rápidamente a lo que se refiere dicha variable.
		Juego.pintarHabitacion(hab1);             
		Juego.pintarMenu();
		
		accionJuego = in.nextInt();
		
		switch(accionJuego) {
		     case Juego.Lanzar_dado:
		    	 numMov = Juego.lanzarDado(10); // Número de movimientos.
		         System.out.println("[Movimiento Columnas / X] ¿Cuántas columnas quieres moverte? Tienes " + numMov + " movimientos.");
		         int numColumnas = in.nextInt(); // Valor ingresado por el jugador para moverse en el eje X.
		         
		         // Aquí validamos para que el jugador no se mueva fuera del rango disponible:
		         if (numColumnas < -numMov || numColumnas > numMov) {
		             System.out.println("¡Valor fuera de rango! Solo puedes moverte entre " + -numMov + " y " + numMov + " columnas.");
		         } else {
		             jugador.movX(numColumnas); // Movemos jugador en el eje X (tanto positivo como negativo).
		             numMov -= Math.abs(numColumnas); // Restamos la cantidad de movimientos, siempre en valor absoluto.
		         }
		         if (numMov <= 0) {
		                System.out.println("Te has quedado sin suficientes puntos de movimientos.");
		                break;  // Salimos del switch si no hay más movimientos.
		            }
		         // Si nos quedan movimientos restantes, continuamos con el eje Y:
		         if (numMov > 0) {
		             System.out.println("[Movimiento Filas / Y] ¿Cuántas filas quieres moverte? Tienes " + numMov + " movimientos.");
		             int numFilas = in.nextInt(); // Valor ingresado por el jugador para moverse en el eje Y.

		             // Validación para que el jugador no se mueva fuera del rango disponible en el eje Y.
		             if (numFilas < -numMov || numFilas > numMov) {
		                 System.out.println("¡Valor fuera de rango! Solo puedes moverte entre " + -numMov + " y " + numMov + " filas.");
		             } else {
		                 jugador.movY(numFilas); // Mover jugador en el eje Y (tanto positivo como negativo).
		                 numMov -= Math.abs(numFilas); // Restamos la cantidad de movimientos, siempre en valor absoluto.
		             }
		             if (hab1.esunaPuerta(jugador.getPos())) {
		         		System.out.print("⌞__⌟");	    
		         	    break;
		         	}
		             objeto=hab1.hayObjetoSinJugador(jugador.getPos());
		             break;
		         }
		         if(objeto>0) {
						//Se ha chocado contra un hadron
						if(hab1.getObjetoJ(objeto).getTipoObjeto()==ObjetoJuego.HADRON) {
							int vidaPerdida=Juego.lanzarDado(2)*numMov;
							accionJuego=Juego.explotaHadron(vidaPerdida);
						}
						else if(hab1.getObjetoJ(objeto).getTipoObjeto()==ObjetoJuego.PIEZA) {
							jugador.setPiezaHabitacion();
						}
						else if(hab1.getObjetoJ(objeto).getTipoObjeto()==ObjetoJuego.PUERTA_FINAL) {
							Juego.habitacionSuperada(hab1);
							accionJuego=Juego.Salir_juego;
						}
						hab1.eliminarObjetoJ(objeto);
						objeto = -1;
					}		       
	             break;
		}
	}	
  }
}
