package factories.interfaces;

import modelos.Plaza;

import java.util.List;

public interface PlazaDAO {

    public void create(Plaza obj);

    public Plaza read(Long id);

    public List<Plaza> read(String criterio);

    public void update(Plaza obj);

    public void delete(Long id);

}
