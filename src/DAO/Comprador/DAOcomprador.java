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

/**
 * Esta es la clase DAOcomprador que se encarga de recopilar
 * los datos de la tabla Comprador de la base de datos y conectarlos con la logica del programa
 *
 * @author Marcos Alonso, Andres Espejo, Sergio Dominguez, Juan Jerez, Alex, Norberto, Miguel
 */
public class DAOcomprador implements IDAOAComprador
{
    static final String DB_URL = "jdbc:sqlite:resources/Zamazor.db";

    private String QUERY;
    private Connection conn;
    private Statement stmt;
    private ResultSet rs;
    /**
     * En la constructora inicializamos la conexion a la base de datos para no llamarla cada vez que
     * se llame a una funcion y tener el codigo redundante
     *
     * conectamos con la base de datos con conn y creamos una consulta con stmt
     */
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
    /**
     * esta funcion se encarga de insertar un comprador en la base de datos, para ello hacemos
     * una consulta INSERT para insertar todos los compradores de la clase Comprador, y actualizamos esa consulta
     * en la base de datos.
     *
     * @param a es el comprador a insertar, con el cogemos cada uno de los atributos de
     *          su clase y los registramos en la base de datos
     * @return devuelve un booleano que indica si se ha insertado correctamente en la base de datos(true) o si no
     */
    //Metodo getpedidos devuelve una Lista (convertir a String)
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
    /**
     * esta funcion se encarga de eliminar un comprador de la base de datos, para ello hacemos
     *      una consulta DELETE para eliminar el comprador de la base de datos cuyo id sea el mismo que el
     *      de la consulta, y actualizamos esa consulta en la base de datos.
     * @param id es el id del comprador a eliminar ya que es el identificador unico de este
     * @return devuelve un booleano que indica si se ha borrado correctamente de la base de datos(true) o si no
     */
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
    /**
     * esta funcion se encarga de modificar un comprador en la base de datos, para ello hacemos
     *      una consulta UPDATE para modificar el comprador de la base de datos con el del parametro,
     *      y actualizamos esa consulta en la base de datos.
     * @param c es el comprador a modificar, con el cogemos cada uno de los parametros de
     *          su clase y los registramos en la base de datos,
     * @return devuelve un booleano que indica si se ha modificado correctamente en la base de datos(true) o si no
     */
    public boolean modificarComprador (Comprador c) {
        boolean correct = true;
        try
        {
            //if (consultarComprador(c.getCuenta()).getNombre() == "")
           // {
            //    throw new Exception("");
           // }
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
    /**
     * esta funcion se encarga de buscar un comprador en la base de datos, para ello hacemos
     *      una consulta SELECT y usamos como condicion LIKE para que recoga nombres que
     *      empiezen por los caracteres insertados para modificar el comprador de la base de datos con el del parametro.
     * @param nombre es el nombre del comprador a modificar, con el cogemos cada uno
     *               de los parametros de su clase y los registramos en la base de datos
     * @return devuelve un booleano que indica si se ha realizado la busqueda correctamente
     *         en la base de datos(true) o si no
     */
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
    /**
     * esta funcion se encarga de consultar un comprador en la base de datos, para ello hacemos
     *     una consulta SELECT para consultar el comprador de la base de datos cuyo nombre de usuario sea el mismo que el
     *     de la consulta.
     * @param username es el nombre de usuario del comprador a consultar, con el cogemos cada uno
     *               de los parametros de su clase y los registramos en la base de datos
     * @return devuelve un booleano que indica si se ha realizado la consulta correctamente
     *         en la base de datos(true) o si no
     */
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
