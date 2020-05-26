/* Esta clase se va a encargar de realizar las operaciones sobre la tabla de datos 'persona' (que esta en MySQL WorkBench) operaciones tales como:
    Leer osea Seleccionar Informacion, Insertar informacion, Modificar, o Eliminar Informacion...   */

/* Esta clase contiene los metodos:
    -Select
    -Insert
    -Update
    -Delete
   para la tabla de persona  */
package datos;

import domain.Persona;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonaJDBC {
    private static final String SQL_SELECT = "SELECT id_persona, nombre, apellido, email, telefono FROM persona"; //--Query para ver la informacion
    private static final String SQL_INSERT = "INSERT INTO persona(nombre, apellido, email, telefono) VALUES(?, ?, ?, ?)"; /*Son 4 parametros que no sabemos
                                                                                                                        cuales seran, son valores desconocidos
                                                                                                                        por lo tanto usamos '?' */
    private static final String SQL_UPDATE = "UPDATE persona SET nombre=?, apellido=?, email=?, telefono=? WHERE id_persona = ?"; /*Se usa para hacer una
                                                                                                                                  actualizacion. */
    private static final String SQL_DELETE = "DELETE FROM persona WHERE id_persona=?"; /* Para borrar algun registro */
    
    //Metodo para modificar un registro...
    public List<Persona> select(){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Persona persona = null;
        
        /* Lista de Objetos de tipo persona // ArrayList de tipo Persona    */
        List<Persona> personas = new ArrayList<Persona>();
        
        try {
            conn = Conexion.getConnection();  //--Obtenemos la conexion con nuestra base de datos 
            stmt = conn.prepareStatement(SQL_SELECT); /*Inicializamos nuestro objeto de tipo Statement y le indicamos que debe ejecutar la sentencia SELECT*/
                                                             
            rs = stmt.executeQuery();  //Ejecutamos el Query y lo asignamos a nuestra variable rs
            
            /* Con este recuperamos cada uno de los valores de la sentencia */  
            while(rs.next()){   /*Va recorriendo cada sentencia */
                
                //Variables temporales
                int id_persona = rs.getInt("id_persona");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");  //Accesamos a las variables mediante las variables temporales
                String email = rs.getString("email");
                String telefono = rs.getString("telefono");
                
                /* Con este se contruye un Objeto de tipo persona */
                persona = new Persona();
                persona.setId_persona(id_persona);
                persona.setNombre(nombre);
                persona.setApellido(apellido);
                persona.setEmail(email);
                persona.setTelefono(telefono);
                
                /* Con esto ya podemos agregar cada uno de los objetos que vallamos recogiendo del ResultSet, pero ahora agregandolos a una lista */
                personas.add(persona);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
        /* En esta parte cerramos cada uno de nuestros objetos, para evitar problemas con esto mismo, y se hace en el finally para que ocurra siempre */
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        /* Por ultimo lo que hacemos es regresamos el listado de personas */
        return personas;
    }
    
    
    
    
    
    
    /* Definimos Metodo Insert: Indica cuantos registros han sido afectados
        Recibe el objeto persona de la clase Persona el cual ya tiene los elementos que desean ser insertados*/
    public int insert(Persona persona){
        Connection conn = null;  //--Definimos la variable Connection
        PreparedStatement stmt = null;
        int rows = 0;  //--Esta variable es para saber cuantos registros han sido afectados una vez ejecutemos nuestra sentencia
        try {
            conn = Conexion.getConnection(); //--Hacemos nuestra conexion con el metodo getConnection()
            stmt = conn.prepareStatement(SQL_INSERT); /*Usamos el metodo PreparedStatement y le pasamos la sentencia INSERT
                                                        ya que este metodo va a realizar la insercion de un objeto de tipo Persona*/
            
            //Le pasamos los parametros que queremos llenar, con esto modificamos los valores de la sentencia insert ?,?,?,?
            stmt.setString(1, persona.getNombre());
            stmt.setString(2, persona.getApellido());
            stmt.setString(3, persona.getEmail());
            stmt.setString(4, persona.getTelefono());
            
            System.out.println("Ejecutando QUERY: "+SQL_INSERT); //Manda por consola mensaje de lo que se esta haciendo
            
            /*Mandamos a ejecutar por medio de la variable Statment el metodo execute update, nos regresa un entero con el numero de 
                los registros modificados, y lo metemos a la variable de rows para saber cuantos registros se han modificado*/
            rows = stmt.executeUpdate();
            System.out.println("Registros Afectados: "+rows);//--Para que nos diga cuantos han sido los registros afectados
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            Conexion.close(stmt);
            Conexion.close(conn); //--Cerramos el objeto conection
        }
        
        return rows; //--Regresamos el numero de registros afectados.
    }
    
    
    /*Metodo Update - Este metodo si debe de contener el objeto persona que ya contenga la llave primaria, 
    para hacer la modificacion, ya que debe ser un registro existente en la base de datos */
    //Es public 'int' por que regresa los registros afectados
    public int update(Persona persona){
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0; //Esta es la variable para definir el numero de registros afectados
        
        try {
            conn = Conexion.getConnection(); //--Es para obtener nuestra conexion
            System.out.println("Ejecutando QUERY: "+SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE); //Usamos metodo PreparedStatement con la ayuda el objeto connection
            stmt.setString(1, persona.getNombre());
            stmt.setString(2, persona.getApellido());
            stmt.setString(3, persona.getEmail());
            stmt.setString(4, persona.getTelefono());
            stmt.setInt(5, persona.getId_persona());
            
            rows = stmt.executeUpdate(); //Una vez la ejecutamos nos trai el numero de registros afectados
            System.out.println("Registros Actualizados: "+rows); //--Imprimimos el numero de registros afectados
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            Conexion.close(stmt); //--Cerramos el objeto Statement
            Conexion.close(conn); //--Cerramos el objeto conexion
        }
        
        return rows; //--Regresamos el numero de registros afectados...
    }
    
    /* Metodo Delete, para eliminar un registro */
   public int delete(Persona persona){
       //Definimos nuestra variable conexion...
       Connection conn = null;
       PreparedStatement stmt = null;
       int rows = 0;
       
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando QUERY: "+SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            //En este caso solo se proporciona un parametro para hacer un Delete de un registro
            stmt.setInt(1, persona.getId_persona());
            rows = stmt.executeUpdate();
            System.out.println("Registros Eliminados: "+rows);
        } catch (SQLException ex) {
           ex.printStackTrace(System.out);
        }finally{
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
   }
}
