package es.ies.puerto.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

import es.ies.puerto.model.Empleado;

/**
 * Clase de las operaciones del fichero
 * @author prorix
 * @version 1.0.0
 */
abstract class FileOperations {

    private static String path = "src/main/resources/empleados.txt";

    /**
     * Metodo para obtener todos los empleados de forma ordenada.
     * @return Empleados ordenados.
     */
    protected Map<String, Empleado> readFile() {
        Map<String, Empleado> empleados = new TreeMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] datos = line.split(", ");
                if(datos.length == 5) {
                    Empleado empleado = new Empleado(datos[0], datos[1], datos[2], Double.parseDouble(datos[3]), datos[4]);
                    empleados.putIfAbsent(empleado.getId(), empleado);
                }
            }
        } catch (IOException e) {
            System.out.println("Error en: " + e.getMessage());
        }
        return empleados;
    }

    /**
     * Metodo para reescribir el archivo con los empleados del mapa.
     * @param empleados mapa de los empleados.
     * @return true / false
     */
    protected boolean updateFile(Map<String, Empleado> empleados) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            for (Empleado empleado : empleados.values()) {
                writer.write(empleado.toString());
                writer.newLine();
            }
            return true;
        } catch (IOException e) {
            System.out.println("Error en: " + e.getMessage());
        }
        return false;
    }
}

