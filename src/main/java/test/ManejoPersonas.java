package test;

import datos.PersonaJDBC;
import domain.Persona;
import java.util.*;

public class ManejoPersonas {
    public static void main(String[] args) {
        /* Se muestra como ejecutamos un SELECT para poder ver la informacion de la base de datos */
        //Creamos un objeto de la clase: PersonaJDBC
        PersonaJDBC personaJDBC = new PersonaJDBC();
        
        //Ejecutamos el metodo select, que nos regresara un listado de personas
        //Creamos una variable llamada: personas que es una lista de objetos de tipo persona
        List<Persona> personas = personaJDBC.select();
        
        //Recorremos cada uno de los objetos y definimos la variable que va a recorrer cada objeto: persona 
        for(Persona persona: personas){
            System.out.println("Persona: "+persona);
        }
        
        
        
        /* No podemos estar usando metodos Insert y Update al mismo tiempo, podemos cancelar Insert para usar Update
            temporalmente */
        
        
        
        
        
        
        //Vamos a probar el metodo Insert: vamos a meter un nuevo registro
//        Persona persona = new Persona();
//        persona.setNombre("Maria");
//        persona.setApellido("Lara");
//        persona.setEmail("mlara@mail.com");
//        persona.setTelefono("55668899");
//        
//        //Mandamos a ejecutar el metodo INSERT
//        personaJDBC.insert(persona);
        
        
        



        
        /*Vamos a probar el metodo Update: Este metodo sirve para cambiar algun registro que ya se encuentre almacenado
            en nuestra base de datos, en este caso vamos a cambiar el registro de nombre Maria  */
        //Aqui en este caso solo cambiaremos el nombre de Maria por Mayra...
    /*    Persona persona = new Persona();
        persona.setId_persona(3);
        persona.setNombre("Mayra");
        persona.setApellido("Lara");
        persona.setEmail("mlara@mail.com");
        persona.setTelefono("55668899");
        
        personaJDBC.update(persona); //--Con esto ejecutamos la sentencia para hacer el update de algun registro
        */
        
        
        
        
        /* Para probar el metodo Delete cancelamos de mientras el metodo Update */
        //Probando Metodo Delete
     /*   Persona persona = new Persona();
        persona.setId_persona(3); //--En este caso se borrar completamente el registro que corresponde a nuestro ID 3
        
        personaJDBC.delete(persona); //--Ejecutamos el metodo para hacer el eliminado de ese objeto registro. */
    }
}

/* -Separacion de responsabilidades basica como se muestra en la clase Conexion: para establecer la conexion con la base de datos
   -Creamos una clase de tipo Persona que representa un registro de una base de datos para almacenamiento de tipo persona
   -Creamos una clase llamada PersonaJDBC que contiene las operaciones basicas para manipular la tabla de la base de datos 
        como insertar, actualizar, etc.
   -Tambien creamos una clase llamada ManejoPersonas (main) donde se pueden probar cada uno de los metodos antes mencionados   
*/