/* En esta clase van a ser nuestras clases de dominio del problema que estamos resolviendo */
/* En esta Clase vamos a definir los atributos que corresponden a cada una de las columnas de nuestra tabla 'persona' de 
    nuestra base de datos */
package domain;

public class Persona {
    //Atributos que estan en nuestra DB
    private int id_persona;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;

    //Metodos Getters y Setters
    public int getId_persona() {
        return id_persona;
    }
    public void setId_persona(int id_persona) {
        this.id_persona = id_persona;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    
    @Override
    public String toString() {
        return "Persona{" + "id_persona=" + id_persona + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email + ", telefono=" + telefono + '}';
    }
}