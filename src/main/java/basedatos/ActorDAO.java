package basedatos;

import basedatos.tablas.Actor;
import basedatos.tablas.Categoria;
import basedatos.tablas.DAO;

import java.util.ArrayList;

public class ActorDAO extends PatternDAO implements DAO<Actor>
{
    @Override
    public int insertOne(Actor c) {
        return 0;
    }

    @Override
    public Categoria getById(Integer id) {
        return null;
    }

    @Override
    public ArrayList<Actor> getAll() {
        return null;
    }

    @Override
    public int update(Actor objectModified)
    {
        return Integer.parseInt(null);
    }

    @Override
    public Boolean deleteById(int id) {
        return null;
    }
}
