package ejercicio1_ant;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author DAW
 */
public class Ejercicio1_ant {

    public static void main(String[] args) {
        
        
        System.out.println("Conexión a BBDD en proceso...");
        
        try {

            Class.forName("com.mysql.cj.jdbc.Driver").newInstance(); //copypasted de apuntes

            String url = "jdbc:mysql://10.230.109.73:3306/test?serverTimezone=UTC;";
            String user = "root";
            String password = "";

            Connection conexion = DriverManager.getConnection(url, user, password);

            Statement ejecutor = conexion.createStatement();

            boolean ex = ejecutor.execute("USE agenda;"); //para saber si funciona o no, true o false

            ResultSet consulta = ejecutor.executeQuery("SELECT * FROM equipos");

            //fuera del bucle hashmap <string, clase>
            while (consulta.next()) {
                //creo objeto de clase 'nombretabla'

                String nombre = consulta.getString("Nombre"); //nombre de la columna. Uno por columna!!!
                //setteo los atributos del objeto con cada campo de consulta
                System.out.println("Nombre: " + nombre);
                //añade al hashmap
            }

            
            
            
            
            
            ejecutor.close();
            conexion.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
