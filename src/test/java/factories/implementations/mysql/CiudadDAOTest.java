package factories.implementations.mysql;

import factories.interfaces.implementations.mysql.CiudadDAO;
import factories.interfaces.implementations.mysql.EmpleadoDAO;
import factories.interfaces.implementations.mysql.PlazaDAO;
import modelos.Ciudad;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class CiudadDAOTest {

    //*Leer todas las plazas de una ciudad y obtener sus empleados. (1 punto)

    private Ciudad ciudad = new Ciudad(new Long("10"), "Coahuila", 1);

    @Test
    public void aCreateTest(){
        factories.interfaces.CiudadDAO ciudadDAO = new CiudadDAO();
        ciudadDAO.create(ciudad);
        //Assert.assertEquals(ciudad, new CiudadDAO().read(new Long("10")));
        String nombreCiudad = "Coahuila";
        Ciudad ciudad2 = ciudadDAO.read(new Long("10"));
        Assert.assertEquals(nombreCiudad, ciudad2.getNombre());
    }

    @Test
    public void bReadTest(){
        factories.interfaces.CiudadDAO ciudadDAO = new CiudadDAO();
        Ciudad ciudad2 = ciudadDAO.read(new Long("10"));
        Assert.assertEquals(ciudad.getId(), ciudad2.getId());
    }

    @Test
    public void cReadTest(){
        factories.interfaces.CiudadDAO ciudadDAO = new CiudadDAO();
        List<Ciudad> ciudades = ciudadDAO.read("WHERE activo = 1");
        for (Ciudad c: ciudades) {
            Assert.assertNotNull(c);
        }
    }

    @Test
    public void

}
