package factories.interfaces;

import modelos.Ciudad;

import java.util.List;

public interface CiudadDAO {

    public void create(Ciudad obj);

    public Ciudad read(Long id);

    public List<Ciudad> read(String criterio);

    public void update(Ciudad obj);

    public void delete(Long id);
}
