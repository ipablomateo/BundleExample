package gt.com.greenway.bundle_example;

import java.io.Serializable;

/**
 * Created by Pablo on 24/04/2017.
 */
public class Persona implements Serializable{

    private String nombre;
    private int edad;

    public Persona(String nombre, int edad) {
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
