package basedatos.tablas;

import java.util.Date;

public class Categoria {
    private Integer idCategoria;
    private String name;

    public Categoria(Integer idCategoria, String name, Date lastUpdate) {
        this.idCategoria = idCategoria;
        this.name = name;
        this.lastUpdate = lastUpdate;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    private Date lastUpdate;
}
