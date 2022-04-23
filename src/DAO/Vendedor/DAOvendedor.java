package DAO.Vendedor;

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

        QUERY = "INSERT INTO Articulos (_ID,_Nombre,_Email,_telefono,_listaVenderdores)" +
                " VALUES(" + a.getId() + "," + "'" + a.getNombre() + "'"+ ","  + a.getEmail() + ","+ a.getTelefono() +
                ","+ "'" + a.getListaVendedores() + "'" + ")";

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

        QUERY = "delete from Vendedor where _Id = " + id;
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
            QUERY = "UPDATE Vendedor SET   _Nombre = " + "'" + v.getNombre() + "'" +
                    ", _Email = " + "'" + v.getEmail() + "'" +
                    ", _Telefono = " + "'" + v.getTelefono() + "'" +
                    ", _ListaVendedores = " + "'" + v.getListaVendedores() + "'" +
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
            QUERY = "SELECT * FROM Vendedor";
        }
        else
        {
            QUERY = "SELECT * FROM Vendedor WHERE _Nombre LIKE " + "'%" + username + "%'";
        }

        try {
            rs = stmt.executeQuery(QUERY);
            try {
                while (rs.next()) {
                    Vendedor comp = new Vendedor();
                    comp.setId(rs.getInt("_ID"));
                    comp.setNombre(rs.getString("_Nombre"));
                    comp.setEmail(rs.getString("_Email"));
                    comp.setTelefono(rs.getLong("_Telefono"));
                    comp.setListaVendedores(compParser(rs.getString("_ListaVendedores")));
                    c.add(comp);
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
        Vendedor comp = new Vendedor();
        QUERY = "SELECT * FROM Comprador WHERE _ID = " + id;

        try {
            rs = stmt.executeQuery(QUERY);
            comp.setId(rs.getInt("_ID"));
            comp.setNombre(rs.getString("_Nombre"));
            comp.setEmail(rs.getString("_Email"));
            comp.setTelefono(rs.getLong("_Telefono"));
            comp.setListaVendedores(compParser(rs.getString("_ListaVendedores")));
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage() + " No se ha identificado el id");
        }
        return comp;
    }
    public List<Vendedor> compParser(String vendedor)
    {
        List <Vendedor> ret = new ArrayList<Vendedor>();
        String pedidos_id[] = vendedor.split(",");

        for (String id : pedidos_id)
        {
            //TODO llamar a dao pedido y consultar por id
        }

        return ret;
    }
}
