package holocaustoH;

public class Hadron extends Personaje {
 // Propiedades:
	private boolean visible = true;

	public Hadron() {
		System.out.println("Creación de un hadrón: 'H'.");
	}
    public boolean cambioVisibilidad() {
    	if(this.visible) { // Aquí (visible) es true; por lo tanto la condición se cumple. (Definido más arriba en las propiedades de la clase Hadrón).
    		this.visible = false; // Si (visible) es verdadero (o sea true) cambiará inmediatamente a false;
    	}else {            // Si no es verdadero (la condición if no se cumple) y pasa al bloque else cambiando su valor a true.
    		this.visible = true; // Esto permite que 'visible' "cambie" o "alterne" su valor entre verdadero o falso cada vez que llamamos al método cambioVisibi-
    }                    // lidad().
    	return visible; // Devuelve el nuevo valor de 'visible' para que el código que llamó a este método pueda ver el estado actualizado.
    }
		
} // Este tipo de método se suele llamar un "conmutador" o "interruptor" de estado porque alterna o invierte el valor cada vez que se llama.

