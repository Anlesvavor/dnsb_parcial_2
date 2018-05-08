package modelos;

import static modelos.Model.fieldsToInsert;

public class Empleado {

    public static final String FIELDS = "id, nombre, apellido, fecha_nacimiento, gerente_id, plaza_id";
    public static final String TABLE = "empleados";
    public static final String Q_ALL = String.format("SELECT %s FROM %s", FIELDS, TABLE);
    public static final String Q_BY_ID = String.format("%s WHERE id = ", Q_ALL);
    public static final String INSERT = String.format("INSERT INTO %s (%s) VALUES %s", TABLE, FIELDS, fieldsToInsert(6));
    public static final String UPDATE = String.format("UPDATE %s SET id = ?, nombre = ?, apellido = ?, fecha_nacimiento = ?, gerente_id = ?, plaza_id = ? WHERE id =", TABLE);
    public static final String DELETE = String.format("DELETE FROM %s WHERE id = ?", TABLE);

    private Long id;
    private String nombre;
    private String apellido;
    private String fechaNacimiento;
    private Empleado gerente;
    private Plaza plaza;

    public Empleado() {
    }

    public Empleado(Long id, String nombre, String apellido, String fechaNacimiento, Empleado gerente, Plaza plaza) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.gerente = gerente;
        this.plaza = plaza;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Empleado getGerente() {
        return gerente;
    }

    public void setGerente(Empleado gerente) {
        this.gerente = gerente;
    }

    public Plaza getPlaza() {
        return plaza;
    }

    public void setPlaza(Plaza plaza) {
        this.plaza = plaza;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", fechaNacimiento='" + fechaNacimiento + '\'' +
                ", gerente=" + gerente +
                ", plaza=" + plaza +
                '}';
    }
}
