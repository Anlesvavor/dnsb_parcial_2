package factories.interfaces.implementations.mysql;

import conexiones.Conexion;
import modelos.Empleado;
import modelos.Plaza;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class EmpleadoDAO implements factories.interfaces.EmpleadoDAO {
    @Override
    public void create(Empleado obj) {
        try {
            Conexion conexion = Conexion.getInstance();
            PreparedStatement ps = conexion.getConnection().prepareStatement(Empleado.INSERT);
            Integer i = 1;
            ps.setLong(i++, obj.getId());
            ps.setString(i++, obj.getNombre());
            ps.setString(i++, obj.getApellido());
            ps.setString(i++, obj.getFechaNacimiento());
            ps.setLong(i++, obj.getGerente().getId());
            ps.setLong(i, obj.getPlaza().getId());
            ps.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Empleado read(Long id) {
        Empleado empleado = null;
        try {
            Conexion conexion = Conexion.getInstance();
            PreparedStatement ps = conexion.getConnection().prepareStatement(String.format("%s %s",Empleado.Q_BY_ID, id));
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                empleado = makeEmpleado(rs);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return empleado;

    }

    @Override
    public List<Empleado> read(String criterio) {
        List<Empleado> empleados = null;
        try {
            Conexion conexion = Conexion.getInstance();
            PreparedStatement ps = conexion.getConnection().prepareStatement(String.format("%s %s",Empleado.Q_ALL, criterio));
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                empleados.add(makeEmpleado(rs));
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return empleados;
    }

    @Override
    public void update(Empleado obj) {
        try {
            Conexion conexion = Conexion.getInstance();
            PreparedStatement ps = conexion.getConnection().prepareStatement(String.format("%s %s",Empleado.UPDATE, obj.getId()));
            Integer i = 1;
            ps.setLong(i++, obj.getId());
            ps.setString(i++, obj.getNombre());
            ps.setString(i++, obj.getApellido());
            ps.setString(i++, obj.getFechaNacimiento());
            ps.setLong(i++, obj.getGerente().getId());
            ps.setLong(i, obj.getPlaza().getId());
            ps.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Long id) {
        try {
            Conexion conexion = Conexion.getInstance();
            PreparedStatement ps = conexion.getConnection().prepareStatement(String.format(Empleado.DELETE));
            Integer i = 1;
            ps.setLong(i, id);
            ps.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Empleado makeEmpleado(ResultSet rs){
        Integer i = 1;
        Empleado empleado = null;
        try {
            empleado = new Empleado(rs.getLong(i++), rs.getString(i++), rs.getString(i++),rs.getString(i++), (Empleado) rs.getObject(i++), (Plaza) rs.getObject(i));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return empleado;
    }
}
