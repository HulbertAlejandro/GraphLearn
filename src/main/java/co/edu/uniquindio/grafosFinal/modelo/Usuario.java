package co.edu.uniquindio.grafosFinal.modelo;

import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * La clase Usuario representa a un usuario con identificaciones básicas.
 * Utiliza la librería Lombok para generar los métodos equals y hashCode automáticamente.
 * Implementa la interfaz Serializable para permitir la serialización de sus instancias.
 */
@EqualsAndHashCode
public class Usuario implements Serializable {
    private String identificacion;
    private String nombre;
    private String correo;
    private String telefono;

    /**
     * Constructor de la clase Usuario.
     *
     * @param identificacion La identificación del usuario.
     * @param nombre         El nombre del usuario.
     * @param correo         El correo electrónico del usuario.
     * @param telefono       El teléfono del usuario.
     */
    public Usuario(String identificacion, String nombre, String correo, String telefono) {
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
    }

    // Getters y setters

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Devuelve una representación en forma de cadena del objeto Usuario.
     *
     * @return La representación en forma de cadena del objeto Usuario.
     */
    @Override
    public String toString() {
        return "Usuario{" +
                "identificacion='" + identificacion + '\'' +
                ", nombre='" + nombre + '\'' +
                ", correo='" + correo + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }
}
