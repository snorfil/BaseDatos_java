package basedatos;

import basedatos.tablas.Categoria;
import basedatos.tablas.DAO;

import java.sql.*;
import java.util.Date;
import java.util.ArrayList;
import java.util.Scanner;

public class CategoriaDAO extends PatternDAO implements DAO<Categoria> {

    public static void main(String[] args) {
        final CategoriaDAO c = new CategoriaDAO();




        new Thread(new Runnable() {
            @Override
            public void run() {
                Scanner in = new Scanner(System.in);
                in.nextLine();

//                c.getAll();
                Date date = new Date();
                final basedatos.tablas.Categoria categoria = new basedatos.tablas.Categoria(100,"sex",date);
//                System.out.println("El resultado de la insercion fue ->  " + c.insertOne(categoria));
//                c.getById(1);
                c.update(categoria);

            }
        }).start();
    }
    public CategoriaDAO() {
        super();
    }

    @Override
    public int insertOne(Categoria c) {
        Connection con = null;
        int resultado = -1;

        try {
            con = DriverManager.getConnection(host,usr,pass);
            PreparedStatement ps = con.prepareStatement("insert into category values(?,?,?)");
            ps.setInt(1,c.getIdCategoria());
            ps.setString(2,c.getName());
            ps.setDate(3, new java.sql.Date(c.getLastUpdate().getTime()) );

            resultado = ps.executeUpdate();
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return resultado;
    }

    /**
     *
     * @param id
     * @return null if doesn´t exist
     */
    @Override
    public Categoria getById(Integer id) {
        String name;
        Date lastUpdate;
        Categoria categoria = null ;

        Connection con = null;

        try {
            con = DriverManager.getConnection(host,usr,pass);
            PreparedStatement ps = con.prepareStatement("SELECT * from category where category_id=" + id );
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                id = rs.getInt(1);
                name = rs.getString(2);
                lastUpdate = rs.getDate(3);

                categoria = new Categoria(id,name,lastUpdate);
            }
            rs.close();
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        System.out.println("getById -> " + categoria);
        return categoria;
    }

    @Override
    public ArrayList<Categoria> getAll() {
        String name;
        Date lastUpdate;
        int id;
        ArrayList<Categoria> categorias = new ArrayList<Categoria>();

        Connection con = null;

        try {
            con = DriverManager.getConnection(host,usr,pass);
            PreparedStatement ps = con.prepareStatement("SELECT * from category" );
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                id = rs.getInt(1);
                name = rs.getString(2);
                lastUpdate = rs.getDate(3);

                categorias.add(new Categoria(id,name,lastUpdate));
            }
            rs.close();
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        System.out.println(categorias);
        return categorias;
    }

    @Override
    public int update(Categoria objectModified) {
        Connection con = null;
        int resultado = -1;

        try {
            con = DriverManager.getConnection(host,usr,pass);
            PreparedStatement ps = con.prepareStatement("UPDATE category SET category_id=?,name=?,last_update=? WHERE category_id=?");
            ps.setInt(1,objectModified.getIdCategoria());
            ps.setString(2,objectModified.getName());
            ps.setDate(3, new java.sql.Date(objectModified.getLastUpdate().getTime()) );
            ps.setInt(4,objectModified.getIdCategoria());

            resultado = ps.executeUpdate();
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return resultado;
    }

    @Override
    public Boolean deleteById(int id) {
        Connection con = null;
        boolean result = false;
        try
        {

            con = DriverManager.getConnection(host, usr, pass);

            String query = "delete from category where id= ?";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, id);
            result = preparedStmt.execute();

        }
        catch (Exception e)
        {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
        finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return result;
    }
}
