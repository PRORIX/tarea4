package es.ies.puerto.operations;

import java.util.Set;

import es.ies.puerto.model.Empleado;

/**
 * Interfaz de operaciones
 * @author prorix
 * @version 1.0.0
 */
public interface Operations {
    boolean create(Empleado empleado);
    boolean delete(String identificador);
    boolean update(Empleado empleado);
    Empleado read(String identificador);
    Empleado read(Empleado empleado);
    Set<Empleado> empleadosPorPuesto(String puesto);
    Set<Empleado> empleadosPorEdad(String fechaInicio, String fechaFin);
}
