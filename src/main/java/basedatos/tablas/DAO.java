package basedatos.tablas;

import java.util.ArrayList;

public interface DAO<T>{

    int insertOne(T c);
    Categoria getById(Integer id);
    ArrayList<T> getAll();

    int update(T objectModified);

    Boolean deleteById(int id);
}
