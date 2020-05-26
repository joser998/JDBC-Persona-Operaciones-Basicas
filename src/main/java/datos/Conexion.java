package datos;

import java.sql.*;

public class Conexion {
    private static final String JDBC_URL = "jdbc:mysql://localhost/test?useSSL=false&serverTimezone=UTC";
    private static final String JDBC_USER = "root"; 
    private static final String JDBC_PASS = "admin";
    
    //Metodo getConnection, puede llamarse diferente, este metodo puede arrojar una excepcion del tipo SQL Exception
    //Este metodo se usar para establecer una conexion con la base de datos.
    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(JDBC_URL,JDBC_USER,JDBC_PASS );
    }
    
    /*Definicion de metodos para cerrar los objetos de tipo ResulSet, PreparedStatement, Connection, ya que son los 
        objetos que vamos a abrir al momento de trabajar con la DB */
    /* Al nombre de la variable le ponemos 'rs' y la envolvemos en un bloque Try-Catch por cualquier excepcion que se presente */
    public static void close(ResultSet rs){
        try {
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
    public static void close(PreparedStatement stmt){
        try {
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
    public static void close(Connection con){
        try {
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
}