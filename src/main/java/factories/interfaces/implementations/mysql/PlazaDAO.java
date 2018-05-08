package factories.interfaces.implementations.mysql;

import conexiones.Conexion;
import modelos.Ciudad;
import modelos.Plaza;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class PlazaDAO implements factories.interfaces.PlazaDAO {
    @Override
    public void create(Plaza obj) {
        try {
            Conexion conexion = Conexion.getInstance();
            PreparedStatement ps = conexion.getConnection().prepareStatement(Plaza.INSERT);
            Integer i = 1;
            ps.setLong(i++, obj.getId());
            ps.setString(i++, obj.getCategoria());
            ps.setLong(i, obj.getCiudad().getId());
            ps.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Plaza read(Long id) {
        Plaza plaza = null;
        try {
            Conexion conexion = Conexion.getInstance();
            PreparedStatement ps = conexion.getConnection().prepareStatement(String.format("%s %s",Plaza.Q_BY_ID, id));
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                plaza = makePlaza(rs);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return plaza;
    }

    @Override
    public List<Plaza> read(String criterio) {
        List<Plaza> plaza = null;
        try {
            Conexion conexion = Conexion.getInstance();
            PreparedStatement ps = conexion.getConnection().prepareStatement(String.format("%s %s",Plaza.Q_ALL, criterio));
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                plaza.add(makePlaza(rs));
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return plaza;
    }

    @Override
    public void update(Plaza obj) {
        try {
            Conexion conexion = Conexion.getInstance();
            PreparedStatement ps = conexion.getConnection().prepareStatement(String.format("%s %s",Plaza.UPDATE, obj.getId()));
            Integer i = 1;
            ps.setLong(i++, obj.getId());
            ps.setString(i++, obj.getCategoria());
            ps.setLong(i, obj.getCiudad().getId());
            ps.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Long id) {
        try {
            Conexion conexion = Conexion.getInstance();
            PreparedStatement ps = conexion.getConnection().prepareStatement(String.format(Plaza.DELETE));
            Integer i = 1;
            ps.setLong(i, id);
            ps.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Plaza makePlaza(ResultSet rs){
        Integer i = 1;
        Plaza plaza = null;
        try {
            plaza = new Plaza(rs.getLong(i++), rs.getString(i++), (Ciudad) rs.getObject(i));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return plaza;
    }
}
