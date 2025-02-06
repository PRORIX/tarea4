package es.ies.puerto.model;
import java.util.Objects;

public class Empleado {
    public String id;
    public String nombre;
    public String puesto;
    public double salario;
    public String fechaNacimiento;

    /**
     * Constructor vacío
     */
    public Empleado(){

    }
    
    /**
     * Constructor solo con la clase primaria
     * @param id del empleado
     */
    public Empleado(String id){
        this.id = id;
    }

    /**
     * Constructor con todos los parámetros
     * @param id del empleado
     * @param nombre del empleado
     * @param puesto del empleado
     * @param salario del empleado
     * @param fechaNacimiento del empleado
     */
    public Empleado(String id, String nombre, String puesto, double salario, String fechaNacimiento){
        this.id = id;
        this.nombre = nombre;
        this.puesto = puesto;
        this.salario = salario;
        this.fechaNacimiento = fechaNacimiento;
    }

    // Getters y setters


    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPuesto() {
        return this.puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public double getSalario() {
        return this.salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getFechaNacimiento() {
        return this.fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }


    // Metodo toString()
    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", nombre='" + getNombre() + "'" +
            ", puesto='" + getPuesto() + "'" +
            ", salario='" + getSalario() + "'" +
            ", fechaNacimiento='" + getFechaNacimiento() + "'" +
            "}";
    }

    // Metodo equals
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Empleado)) {
            return false;
        }
        Empleado empleado = (Empleado) o;
        return Objects.equals(id, empleado.id) && Objects.equals(nombre, empleado.nombre) && Objects.equals(puesto, empleado.puesto) && salario == empleado.salario && Objects.equals(fechaNacimiento, empleado.fechaNacimiento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, puesto, salario, fechaNacimiento);
    }
    

}
