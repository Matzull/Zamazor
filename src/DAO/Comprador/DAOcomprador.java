package DAO.Comprador;

import DAO.Pedido.FachadaDaoPedidoImpl;
import DAO.Pedido.IFachadaDaoPedido;
import ModeloDominio.Comprador;
import ModeloDominio.Pedido;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static Misc.Util.hash256;


public class DAOcomprador implements IDAOAComprador
{
    static final String DB_URL = "jdbc:sqlite:resources/Zamazor.db";

    private String QUERY;
    private Connection conn;
    private Statement stmt;
    private ResultSet rs;

    public DAOcomprador(Connection conn){
        try
        {
            //Class.forName("org.sqlite.JDBC");
            this.conn = conn;
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

        QUERY = "INSERT INTO Comprador (_ID, _Nombre, _Email, _Cuenta, _Direccion, _Pedidos, _Password)" +
                " VALUES(" + a.getId() + "," + "'" + a.getNombre() + "'"+ ","  + "'" + a.getEmail() + "'" + ","  + "'" + a.getCuenta() + "'"+ "," + "'" + a.getDireccion() + "'" + ","
                + "'" + compParser(a.getPedidos()) + "'" +  "," + "'" + hash256(a.getPassword()) + "'" + ")";

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
            if (consultarComprador(c.getCuenta()).getNombre() == "")
            {
                throw new Exception("");
            }
            QUERY = "UPDATE Comprador SET   _Nombre = " + "'" + c.getNombre() + "'" +
                                            ", _Email = " + "'" + c.getEmail() + "'" +
                                            ", _Cuenta = " + "'" + c.getCuenta() + "'" +
                                            ", _Direccion = " + "'" + c.getDireccion() + "'" +
                                            ", _Pedidos = " + "'" + compParser(c.getPedidos()) + "'" +
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

    public Comprador consultarComprador(String username)
    {
        Comprador comp = new Comprador();
        QUERY = "SELECT * FROM Comprador WHERE _Cuenta = " +  "'" + username + "'";

        try {
            rs = stmt.executeQuery(QUERY);
            comp.setId(rs.getInt("_ID"));
            comp.setNombre(rs.getString("_Nombre"));
            comp.setEmail(rs.getString("_Email"));
            comp.setCuenta(rs.getString("_Cuenta"));
            comp.setDireccion(rs.getString("_Direccion"));
            comp.setPassword(rs.getString("_Password"));
            comp.setPedidos(compParser(rs.getString("_Pedidos")));
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage() + " No se ha identificado el id");
        }
        return comp;
    }

    public List<Pedido> compParser(String pedidos)
    {
        IFachadaDaoPedido PedidosDao = new FachadaDaoPedidoImpl();
        List <Pedido> ret = new ArrayList<Pedido>();
        String pedidos_id[] = pedidos.split(",");

        if(!pedidos_id[0].equals("null")) {
            for (String id : pedidos_id) {
                ret.add(PedidosDao.consultarPedido(Integer.parseInt(id), false));
            }
        }
        else
        {
            ret = null;
        }
        return ret;
    }

    public String compParser(List<Pedido> ps)
    {
        String ret = "";
        if (ps != null)
        {
            ret = ps.toString();
            ret = ret.substring(1, ret.length() - 1);
            ret = ret.replaceAll(" ", "");
        }
        return ret;
    }
}