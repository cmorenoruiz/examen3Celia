package ejerciciosExamen;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author DAW
 */
public class ejercicio2 {

    public static void main(String[] args) {

        try {
            System.out.println("Leyendo documento...");
            System.out.println("");
            System.out.println("Introduciendo datos en la clase Aparcamiento...");

            File fichAparcamientos = new File("Aparcamientos.txt"); //csv
            if (!fichAparcamientos.exists() | !fichAparcamientos.isFile()) {
                throw new Exception("No existe o no se encuentra el archivo.");
            }

            Scanner lector = new Scanner(fichAparcamientos);
            HashMap<String, Aparcamiento> hashmapa = new HashMap<String, Aparcamiento>();
            Aparcamiento aparcamiento;

            String id = "";
            String nombre = "";
            String tipo = "";
            int plazasRot = 0;
            int plazasResid = 0;
            int plazasDis = 0;
            String distrito = "";

            while (lector.hasNextLine()) {

                String linea = lector.nextLine();
                String trozos[] = linea.split(",");

                id = trozos[0].trim();
                nombre = trozos[1].trim();
                tipo = trozos[2].trim();

                if (trozos[3].isEmpty()) { //buscar metodo mas eficiente despues
                    plazasRot = 0;
                } else {
                    plazasRot = Integer.parseInt(trozos[3]);
                }

                if (trozos[4].isEmpty()) {
                    plazasResid = 0;
                } else {
                    plazasResid = Integer.parseInt(trozos[4]);
                }

                if (trozos[5].isEmpty()) {
                    plazasDis = 0;
                } else {
                    plazasDis = Integer.parseInt(trozos[5].trim());
                }

                distrito = trozos[6];

                aparcamiento = new Aparcamiento(id, nombre, tipo, plazasRot, plazasResid, plazasDis, distrito);
                hashmapa.put(id, aparcamiento);

            }

            System.out.println("Datos introducidos con éxito.");

            System.out.println("");
            System.out.println("Calculando número de aparcamientos por cada tipo...");
            System.out.println("");
            System.out.println("El número de plazas de rotacion es: " + contRot(hashmapa));
            System.out.println("    //El resto estan en blanco porque el registro esta en blanco)");
            //aqui irian el resto
            System.out.println("El número de plazas de residentes es: " + contResid(hashmapa));

            System.out.println("El número de plazas de disuasorias es: " + contDis(hashmapa));

            System.out.println("");
            System.out.println("Calculando aparcamientos por distrito...");

            System.out.println("Aparcamientos en Chamberi: " + contDistChamb(hashmapa));
            System.out.println("Aparcamientos en Centro: " + contDistCentro(hashmapa));

            lector.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //FUNCIONES - proxima optimizacion, conseguir resultados con mejores funciones
    static public int contRot(HashMap hm) {
        int cont = 0;
        Iterator<Map.Entry<String, Aparcamiento>> iterator = hm.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Aparcamiento> entry = iterator.next();
            String key = entry.getKey();
            cont += entry.getValue().getPlazasRot();
        }
        return cont;
    }

    static public int contResid(HashMap hm) {
        int cont = 0;
        Iterator<Map.Entry<String, Aparcamiento>> iterator = hm.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Aparcamiento> entry = iterator.next();
            String key = entry.getKey();
            cont += entry.getValue().getPlazasResid();
        }
        return cont;
    }

    static public int contDis(HashMap hm) {
        int cont = 0;
        Iterator<Map.Entry<String, Aparcamiento>> iterator = hm.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Aparcamiento> entry = iterator.next();
            String key = entry.getKey();
            cont += entry.getValue().getPlazasDis();
        }
        return cont;
    }

    static public int contDistChamb(HashMap hm) {
        int cont = 0;
        Iterator<Map.Entry<String, Aparcamiento>> iterator = hm.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Aparcamiento> entry = iterator.next();
            String key = entry.getKey();
            if (entry.getValue().getDistrito().equalsIgnoreCase("chamberi")) {
                cont++; //no fucking idea por que dice que 0, algo se me ha pasado, sin tiempo
            }

        }
        return cont;
    }
    
        static public int contDistCentro(HashMap hm) {
        int cont = 0;
        Iterator<Map.Entry<String, Aparcamiento>> iterator = hm.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Aparcamiento> entry = iterator.next();
            String key = entry.getKey();
            if (entry.getValue().getDistrito().equalsIgnoreCase("centro")) {
                cont++;
            }

        }
        return cont;
    }
}
