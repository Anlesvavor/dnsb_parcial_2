package modelos;

import static modelos.Model.fieldsToInsert;

public class Plaza {

    public static final String FIELDS = "id, categoria, ciudad_id";
    public static final String TABLE = "plazas";
    public static final String Q_ALL = String.format("SELECT %s FROM %s", FIELDS, TABLE);
    public static final String Q_BY_ID = String.format("%s WHERE id = ", Q_ALL);
    public static final String INSERT = String.format("INSERT INTO %s (%s) VALUES %s", TABLE, FIELDS, fieldsToInsert(3));
    public static final String UPDATE = String.format("UPDATE %s SET id = ?, categoria = ?, ciudad_id = ? WHERE id =", TABLE);
    public static final String DELETE = String.format("DELETE FROM %s WHERE id = ?", TABLE);

    private Long id;
    private String categoria;
    private Ciudad ciudad;

    public Plaza() {
    }

    public Plaza(Long id, String categoria, Ciudad ciudad) {
        this.id = id;
        this.categoria = categoria;
        this.ciudad = ciudad;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    @Override
    public String toString() {
        return "Plaza{" +
                "id=" + id +
                ", categoria='" + categoria + '\'' +
                ", ciudad=" + ciudad +
                '}';
    }
}
