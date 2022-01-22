import java.io.Serializable;

public class Jugador implements Serializable{
    private String nombre;
    private int edad;
  
    public Jugador(String nombre, int edad){
        this.nombre = nombre;
        this.edad = edad;
       
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }


}
