package DAO.Comprador;

import ModeloDominio.Articulo;
import ModeloDominio.Comprador;
import ModeloDominio.Pedido;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class DAOcomprador implements IDAOAComprador
{
    static final String DB_URL = "jdbc:sqlite:resources/Zamazor.db";

    private String QUERY;
    private Connection conn;
    private Statement stmt;
    private ResultSet rs;

    public DAOcomprador(){
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

    ////Metodo getpedidos devuelve una Lista (convertir a String)
    public boolean altaComprador(Comprador a) {
        boolean correct = false;

        QUERY = "INSERT INTO Articulos (_ID, _Nombre, _Email, _Cuenta, _Direccion, _Pedidos, _Password)" +
                " VALUES(" + a.getId() + "," + "'" + a.getNombre() + "'"+ ","  + "'" + a.getEmail() + "'" + "," + "'" + a.getDireccion() + "'" + ","
                + "'" + a.getPedidos() + "'" +  "," + "'" + a.getPassword() + "'" + ")";

            try {
                stmt.executeUpdate(QUERY);
                correct = true;
            } catch (Exception e) {
                correct = false;
            }
            return correct;
    }

    public boolean bajaComprador (int id){
        boolean correct = false;

        QUERY = "delete from Comprador where _Id = " + id;
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

    public boolean modificarComprador (Comprador c) {
        boolean correct = true;
        try
        {
            if (consultarComprador(c.getId()).getNombre() == "")
            {
                throw new Exception("");
            }
            QUERY = "UPDATE Articulos SET   _Nombre = " + "'" + c.getNombre() + "'" +
                                            ", _Email = " + "'" + c.getEmail() + "'" +
                                            ", _Cuenta = " + "'" + c.getCuenta() + "'" +
                                            ", _Direccion = " + "'" + c.getDireccion() + "'" +
                                            ", _Pedidos = " + "'" + c.getPedidos() + "'" +
                                            ", _Password = " + "'" + c.getPassword() + "'" + " WHERE _ID = " + c.getId();

            stmt.executeUpdate(QUERY);
            correct = true;
        }
        catch (Exception e)
        {
            correct = false;
        }
        return correct;
    }

    public List<Comprador> buscarComprador (String nombre){
        List<Comprador> c = new ArrayList<Comprador>();
        boolean correct = false;

        if (nombre == "")
        {
            QUERY = "SELECT * FROM Comprador";
        }
        else
        {
            QUERY = "SELECT * FROM Comprador WHERE _Nombre LIKE " + "'%" + nombre + "%'";
        }

        try {
            rs = stmt.executeQuery(QUERY);
            try {
                while (rs.next()) {
                    Comprador comp = new Comprador();
                    comp.setId(rs.getInt("_ID"));
                    comp.setNombre(rs.getString("_Nombre"));
                    comp.setEmail(rs.getString("_Email"));
                    comp.setCuenta(rs.getString("_Cuenta"));
                    comp.setDireccion(rs.getString("_Direccion"));
                    comp.setPedidos(compParser(rs.getString("_Pedidos")));
                    comp.setPassword(rs.getString("_Password"));
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

    public Comprador consultarComprador(int id)
    {
        Comprador comp = new Comprador();
        QUERY = "SELECT * FROM Comprador WHERE _ID = " + id;

        try {
            rs = stmt.executeQuery(QUERY);
            comp.setId(rs.getInt("_ID"));
            comp.setNombre(rs.getString("_Nombre"));
            comp.setEmail(rs.getString("_Email"));
            comp.setCuenta(rs.getString("_Cuenta"));
            comp.setDireccion(rs.getString("_Direccion"));
            comp.setPedidos(compParser(rs.getString("_Pedidos")));
            comp.setPassword(rs.getString("_Password"));
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage() + " No se ha identificado el id");
        }
        return comp;
    }

    public List<Pedido> compParser(String pedidos)
    {
        List <Pedido> ret = new ArrayList<Pedido>();
        String pedidos_id[] = pedidos.split(",");

        for (String id : pedidos_id)
        {
            //TODO llamar a dao pedido y consultar por id
        }

        return ret;
    }
}