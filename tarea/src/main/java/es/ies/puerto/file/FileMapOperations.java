package es.ies.puerto.file;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import es.ies.puerto.model.Empleado;
import es.ies.puerto.operations.Operations;

public class FileMapOperations extends FileOperations implements Operations {
    /**
     * Metodo para crear un empleado
     * @param empleado a crear
     * @return true / false
     */
    @Override
    public boolean create(Empleado empleado) {
        if(empleado == null){
            return false;
        }
        if(empleado.getId() == null || empleado.getId().isEmpty()){
            return false;
        }
        Map<String, Empleado> empleados = readFile();
        empleados.putIfAbsent(empleado.getId(), empleado);
        return updateFile(empleados);
    }

    /**
     * Metodo para leer un empleado por su id
     * @param identificador del empleado a leer
     * @return empleado solicitado
     */
    @Override
    public Empleado read(String identificador) {
        if(identificador == null || identificador.isEmpty()){
            return null;
        }
        Map<String, Empleado> empleados = readFile();
        return empleados.get(identificador);
    }

    /**
     * Metodo para leer un empleado dado
     * @param empleado dado
     * @return el epleado
     */
    @Override
    public Empleado read(Empleado empleado) {
        if(empleado == null){
            return null;
        }
        if(empleado.getId() == null || empleado.getId().isEmpty()){
        return null;
        }
        return read(empleado.getId());
    }

    /**
     * Metodo para eliminar un empleado por su id
     * @param identificador del empleado a eliminar
     * @return true / false
     */
    @Override
    public boolean delete(String identificador) {
        if(identificador == null || identificador.isEmpty()){
            return false;
        }
        Map<String, Empleado> empleados = readFile();
        if(empleados.remove(identificador) != null) {
            return updateFile(empleados);
        }
        return false;
    }

    /**
     * Metodo para actualizar un empleado
     * @param empleado nuevo
     * @return true / false
     */
    @Override
    public boolean update(Empleado empleado) {
        if(empleado == null){
            return false;
        }
        if(empleado.getId() == null || empleado.getId().isEmpty()){
        return false;
        }
        Map<String, Empleado> empleados = readFile();
        if(empleados.replace(empleado.getId(), empleado) != null) {
            return updateFile(empleados);
        }
        return false;
    }

    /**
     * Metodo para obtener un conjunto de empleados por su puesto
     * @param puesto que se busca
     * @return el conjunto de empleados deseado
     */
    @Override
    public Set<Empleado> empleadosPorPuesto(String puesto) {
        Set<Empleado> empleadosPorPuesto = new HashSet<>();
        if(puesto == null || puesto.isEmpty()) return empleadosPorPuesto;
        Map<String, Empleado> empleados = readFile();
        for (Empleado empleado : empleados.values()) {
            if (empleado.getPuesto().equalsIgnoreCase(puesto)) {
                empleadosPorPuesto.add(empleado);
            }
        }
        return empleadosPorPuesto;
    }

    /**
     * Metodo para obtener los empleados que nacieron entre dos fechas dadas
     * @param fechaInicio dada
     * @param fechaFin dada
     * @return conjunto de empleados deseado
     */
    @Override
    public Set<Empleado> empleadosPorEdad(String fechaInicio, String fechaFin) {
        Set<Empleado> empleadosPorEdad = new HashSet<>();
        if(fechaInicio == null || fechaInicio.isEmpty()) return empleadosPorEdad;
        if(fechaFin == null || fechaFin.isEmpty()) return empleadosPorEdad;
        Map<String, Empleado> empleados = readFile();
        for (Empleado empleado : empleados.values()) {
            if (empleado.getFechaNacimiento().compareTo(fechaInicio) >= 0 &&
                empleado.getFechaNacimiento().compareTo(fechaFin) <= 0) {
                empleadosPorEdad.add(empleado);
            }
        }
        return empleadosPorEdad;
    }
}