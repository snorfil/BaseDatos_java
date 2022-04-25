package basedatos;

import basedatos.tablas.Categoria;
import basedatos.tablas.DAO;
import basedatos.tablas.Film;

import java.util.ArrayList;

public class FilmDAO extends PatternDAO implements DAO<Film> {

    @Override
    public int insertOne(Film c) {
        return 0;
    }

    @Override
    public Categoria getById(Integer id) {
        return null;
    }

    @Override
    public ArrayList<Film> getAll() {
        return null;
    }

    @Override
    public int update(Film objectModified) {
        return Integer.parseInt(null);
    }

    @Override
    public Boolean deleteById(int id) {
        return null;
    }
}
