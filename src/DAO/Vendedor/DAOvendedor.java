package DAO.Vendedor;

import DAO.Articulo.FachadaDaoArticuloImpl;
import DAO.Articulo.IFachadaDaoArticulo;
import ModeloDominio.Articulo;
import ModeloDominio.Comprador;
import ModeloDominio.Vendedor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAOvendedor implements IDAOAVendedor
{

    static final String DB_URL = "jdbc:sqlite:resources/Zamazor.db";

    private String QUERY;
    private Connection conn;
    private Statement stmt;
    private ResultSet rs;

    public DAOvendedor(){
        try
        {
            //Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection(DB_URL);
            stmt = conn.createStatement();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public boolean altaVendedor(Vendedor a) {
        boolean correct = false;

        QUERY = "INSERT INTO Vendedores (_ID,_Nombre,_Email,_Telefono,_Articulos)" +
                " VALUES(" + a.getId() + "," + "'" + a.getNombre() + "'"+ ","  + a.getEmail() + ","+ a.getTelefono() +
                ","+ "'" + a.getArticulos() + "'" + ")";

        try {
            stmt.executeUpdate(QUERY);
            correct = true;
        } catch (Exception e) {
            correct = false;
        }
        return correct;
    }


    @Override
    public boolean bajaVendedor(int id) {
        boolean correct = false;

        QUERY = "delete from Vendedores where _Id = " + id;
        try
        {
            stmt.executeUpdate(QUERY);
            correct = true;
        }
        catch (Exception e)
        {
            correct = false;
        }
        return correct;
    }

    @Override
    public boolean modificarVendedor(Vendedor v) {
        boolean correct = true;
        try
        {
            if (consultarVendedor(v.getId()).getNombre() == "")
            {
                throw new Exception("");
            }
            QUERY = "UPDATE Vendedores SET   _Nombre = " + "'" + v.getNombre() + "'" +
                    ", _Email = " + "'" + v.getEmail() + "'" +
                    ", _Telefono = " + "'" + v.getTelefono() + "'" +
                    ", _Articulos = " + "'" + v.getArticulos() + "'" +
                    " WHERE _ID = " + v.getId();

            stmt.executeUpdate(QUERY);
            correct = true;
        }
        catch (Exception e)
        {
            correct = false;
        }
        return correct;
    }



    @Override
    public List<Vendedor> buscarVendedor(String username) {
        List<Vendedor> c = new ArrayList<Vendedor>();
        boolean correct = false;

        if (username == "")
        {
            QUERY = "SELECT * FROM Vendedores";
        }
        else
        {
            QUERY = "SELECT * FROM Vendedores WHERE _Nombre LIKE " + "'%" + username + "%'";
        }

        try {
            rs = stmt.executeQuery(QUERY);
            try {
                while (rs.next()) {
                    Vendedor vend = new Vendedor();
                    vend.setId(rs.getInt("_ID"));
                    vend.setNombre(rs.getString("_Nombre"));
                    vend.setEmail(rs.getString("_Email"));
                    vend.setTelefono(rs.getLong("_Telefono"));
                    vend.setArticulos(vendedorParser(rs.getString("_Articulos")));
                    c.add(vend);
                }
            } catch (NullPointerException e) {
                throw new NullPointerException("No existen compradores en la base de datos");
            }
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage() + " No se ha identificado el nombre");
        }
        return c;
    }

    @Override
    public Vendedor consultarVendedor(int id) {
        Vendedor vend = new Vendedor();
        QUERY = "SELECT * FROM Vendedores WHERE _ID = " + id;

        try {
            rs = stmt.executeQuery(QUERY);
            vend.setId(rs.getInt("_ID"));
            vend.setNombre(rs.getString("_Nombre"));
            vend.setEmail(rs.getString("_Email"));
            vend.setTelefono(rs.getLong("_Telefono"));
            vend.setArticulos(vendedorParser(rs.getString("_Articulo")));
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage() + " No se ha identificado el id");
        }
        return vend;
    }

    public List<Articulo> vendedorParser(String articulos)
    {
        IFachadaDaoArticulo ArticulosDao = new FachadaDaoArticuloImpl();

        List <Articulo> ret = new ArrayList<Articulo>();
        String articulos_id[] = articulos.split(",");

        for (String id : articulos_id)
        {
            ret.add(ArticulosDao.consultarArticulo(Integer.parseInt(id)));
        }

        return ret;
    }
}
