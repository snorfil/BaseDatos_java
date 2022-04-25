package basedatos.tablas;

import java.util.Date;

public class Actor {
    private Integer idActor;
    private String firstName;
    private String lastName;
    private Date timestamp;

    public Actor(Integer idActor) {
        this.idActor = idActor;
    }
}
