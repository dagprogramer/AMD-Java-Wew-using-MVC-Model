/*
 * Alumno.java
 *
 *
 */
package ar.com.entidades;



/**
 *
 * @author diego guzman
 */
public class Alumno {

    // Atributos
    private int id;
    private String nombre;
    private String apellido;
    private String dni;
    private String direccion;

    // Constructor
    public Alumno() {
    }

    // Constructor
    public Alumno(int id) {
        this.id = id;
    }

    // Constructor
    public Alumno(String unNombre, String unApellido) {
        this.setNombre(unNombre);
        this.setApellido(unApellido);
    }

    // Constructor
    public Alumno(int unId, String unNombre, String unApellido) {
        this.setNombre(unNombre);
        this.setApellido(unApellido);
        this.setId(unId);
    }
    
    public Alumno(int unId, String unNombre, String unApellido, String unDni, String unaDireccion) {
        this.setNombre(unNombre);
        this.setApellido(unApellido);
        this.setId(unId);
        this.dni = unDni;
        this.direccion = unaDireccion;
    }

    // Obtiene un ArrayList con los alumnos que satisfacen el criterio de busqueda

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the apellido
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * @param apellido the apellido to set
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    
   
}
