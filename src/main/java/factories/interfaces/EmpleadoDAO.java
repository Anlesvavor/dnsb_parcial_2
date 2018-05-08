package factories.interfaces;

import modelos.Empleado;

import java.util.List;

public interface EmpleadoDAO {

    public void create(Empleado obj);

    public Empleado read(Long id);

    public List<Empleado> read(String criterio);

    public void update(Empleado obj);

    public void delete(Long id);

}
