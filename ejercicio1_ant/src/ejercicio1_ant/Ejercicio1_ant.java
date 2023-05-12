package ejercicio1_ant;

import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author DAW
 */
public class Ejercicio1_ant {

    public static void main(String[] args) {

        System.out.println("Conexión a BBDD en proceso...");
        System.out.println("");

        try {

            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();//no tocar

            String url = "jdbc:mysql://10.230.109.73:3306/AGENDA?serverTimezone=UTC"; //cambiar cada vez
            String user = "root";
            String password = "";

            Connection conexion = DriverManager.getConnection(url, user, password);

            Statement ejecutor = conexion.createStatement();

//            boolean ex = ejecutor.execute("USE agenda"); //para saber si funciona o no, true o false
            ResultSet consulta;

            System.out.println("Conexión conseguida.");
            System.out.println("");

            System.out.println("Creacion de variables para uso en bbbdd...");
            String id = "";
            String nombre = "";
            String telefono = "";

            //fuera del bucle hashmap <string, clase>
            HashMap<String, Contacto> hashmapa = new HashMap<String, Contacto>();
            Contacto contacto;

            System.out.println("Creando hashmap.");
            System.out.println();
            System.out.println("");

            // MENU E INTERACCION CON USUARIO
            Scanner teclado = new Scanner(System.in);
            System.out.println();
            System.out.println("     *-------------*");
            System.out.println("     | AGENDA 2023 |");
            System.out.println("     |  By Celia   |");
            System.out.println("     *-------------*");
            System.out.println("");
            System.out.println("BIENVENIDE.");
            System.out.println("Seleccione una opcion:");

            char opcionElegida;

            do {

                System.out.println("");
                System.out.println("Pulse 1 para crear un contacto y añadirlo a la agenda.");
                System.out.println("Pulse 2 para modificar datos de un contacto");
                System.out.println("Pulse 3 para eliminar un contacto existente");
                System.out.println("Pulse 4 para mostrar contactos existentes.");
                System.out.println("Pulse 0 para salir.");

                opcionElegida = teclado.nextLine().charAt(0);

                switch (opcionElegida) {

                    case '1': //crear contacto
                        //posteriormente optimizamos con funciones externas al menu
                        System.out.println("Introduce el id del contacto:");
                        id = teclado.nextLine();
                        System.out.println("Introduce el nombre del contacto:");
                        nombre = teclado.nextLine();
                        System.out.println("Introduce el telefono del contacto:");
                        telefono = teclado.nextLine();
                        System.out.println("");
                        System.out.println("Contacto añadido con éxito.");
//                        consulta.moveToInsertRow();
//                        consulta.updateString(id, nombre, telefono);
//                        consulta.insertRow();
                        contacto = new Contacto(id, nombre, telefono);
                        hashmapa.put(id, contacto);

                        break;
                    case '2': //editar
                        //editar contacto
                        System.out.println("Contacto editado con éxito.");

                        break;
                    case '3': //eliminar contacto
                        System.out.println("Contacto eliminado con éxito.");
                        break;

                    case '4': //mostrar contacto
                        System.out.println("Mostrando contactos existentes:");
                        System.out.println("Mostrando datos insertados en tabla contactos...");
                        System.out.println("");

                        consulta = ejecutor.executeQuery("SELECT * FROM contactos");

                        while (consulta.next()) {
                            //creo objeto de clase 'nombretabla'
                            //setteo los atributos del objeto con cada campo de consulta
                            //añade al hashmap
                            id = consulta.getString("id"); //nombre de la columna. Uno por columna!!!
                            System.out.println("id: " + id);

                            nombre = consulta.getString("nombre"); //nombre de la columna. Uno por columna!!!
                            System.out.println("Nombre: " + nombre);

                            telefono = consulta.getString("telefono"); //nombre de la columna. Uno por columna!!!
                            System.out.println("Telefono: " + telefono);

                            contacto = new Contacto(id, nombre, telefono);
                            hashmapa.put(id, contacto);
                        }
                        break;

                    case '0': //salir
                        System.out.println("Ha decidido salir del programa.");
                        break;
                }

            } while (opcionElegida != '0');

            ejecutor.close();
            conexion.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
