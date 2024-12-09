package holocaustoH;

public class Personaje extends ObjetoJuego { // Dentro del mapa cuadriculado.
                                                                // Para colocar automáticamente los Getters y Setters seleccionamos todas las propiedades, 
	                                                                           // luego clic derecho en ellas y nos dirijimos
	                                                                           // a la opción 'Source', finalmente seleccionamos 'Generate Getters and Se-
	                                                                                                                       // tters'
	public Personaje() {
		
		// this.pos = new Posicion(0,0); // Asignamos una posición por defecto para evitar null.
	}
    // Getters & Setters:
	
	public void movX(int X) {
		Posicion pos = super.getPos(); // La posición actual de J (Jugador) es o está en: this.pos.getX()
		
	        pos.setPosX(pos.getPosX()+ X);
	}                                            // valor entero ingresado por el usuario.
	public void movY(int Y) {
		Posicion pos = super.getPos();
		pos.setPosY(pos.getPosY()+Y); 
	}
}

   

/* Ejemplo: 

   public class Persona { // Declaración de la clase.
    private String nombre; // Campo de la clase.

    public Persona(String nombre) { // Constructor.
        this.nombre = nombre; // 'this.nombre' se refiere al campo de la clase, y 'nombre' al parámetro del constructor.
    }
}

* Sin 'this.' el compilador no podrá distinguir entre el campo 'nombre' de la clase y el parámetro 'nombre' del constructor. this.nombre asegura que esta-
  mos asignando el valor del parámetro al campo de la clase.
  
- Ejemplo:

  public class Persona {
    private String nombre;

    public Persona(String nombre) {
        this.nombre = nombre; 
    }
}
  
  public class Persona {
    private String nombre;

    public Persona(String nombre) {
        nombre = nombre; // Aquí simplemente reasignamos el parámetro a sí mismo, no al campo de la clase, esto puede llevar a errores lógicos en el pro-
                            grama.
    }
}

* No utilizamos this. en 'get' pues, al no haber parámetros en los Getters, no existe ambigüedad en los nombres de los parámetros con los atributos de la
  clase. Aquí el compilador de Java ya sabe que 'posX' y 'posY' se refieren a los atributos de la instancia de la clase. Por lo tanto, podemos devolver 
  los atributos directamente.                       
     
     */