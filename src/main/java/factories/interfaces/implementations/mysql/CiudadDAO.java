package factories.interfaces.implementations.mysql;

import conexiones.Conexion;
import modelos.Ciudad;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CiudadDAO  implements factories.interfaces.CiudadDAO {



    @Override
    public void create(Ciudad obj) {
        try {
            Conexion conexion = Conexion.getInstance();
            PreparedStatement ps = conexion.getConnection().prepareStatement(Ciudad.INSERT);
            Integer i = 1;
            ps.setLong(i++, obj.getId());
            ps.setString(i++, obj.getNombre());
            ps.setInt(i, obj.getActivo());
            ps.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Ciudad read(Long id) {
        Ciudad ciudad = null;
        try {
            Conexion conexion = Conexion.getInstance();
            PreparedStatement ps = conexion.getConnection().prepareStatement(String.format("%s %s",Ciudad.Q_BY_ID, id));
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                ciudad = makeCiudad(rs);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return ciudad;
    }

    @Override
    public List<Ciudad> read(String criterio) {
        List<Ciudad> ciudades = null;
        try {
            Conexion conexion = Conexion.getInstance();
            Statement st = conexion.getConnection().createStatement();
            ResultSet rs = st.executeQuery(String.format("%s %s", Ciudad.Q_ALL, criterio));
            if (rs.next()){
                ciudades.add(makeCiudad(rs));
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return ciudades;
    }

    @Override
    public void update(Ciudad obj) {
        try {
            Conexion conexion = Conexion.getInstance();
            PreparedStatement ps = conexion.getConnection().prepareStatement(String.format("%s %s",Ciudad.UPDATE, obj.getId()));
            Integer i = 1;
            ps.setLong(i++, obj.getId());
            ps.setString(i++, obj.getNombre());
            ps.setInt(i, obj.getActivo());
            ps.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Long id) {
        try {
            Conexion conexion = Conexion.getInstance();
            PreparedStatement ps = conexion.getConnection().prepareStatement(String.format(Ciudad.DELETE));
            Integer i = 1;
            ps.setLong(i++, id);
            ps.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Ciudad makeCiudad(ResultSet rs){
        Integer i = 1;
        Ciudad ciudad = null;
        try {
            ciudad = new Ciudad(rs.getLong(i++), rs.getString(i++), rs.getInt(i));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ciudad;
    }
}
