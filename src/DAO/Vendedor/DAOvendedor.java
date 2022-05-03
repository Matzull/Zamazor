package DAO.Vendedor;

import DAO.Articulo.FachadaDaoArticuloImpl;
import DAO.Articulo.IFachadaDaoArticulo;
import ModeloDominio.Articulo;
import ModeloDominio.Vendedor;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static Misc.Util.hash256;
/**
 * Esta es la clase DAOvendedor que se encarga de recopilar
 * los datos de la tabla Vendedores de la base de datos y conectarlos con la logica del programa
 *
 * @author Marcos Alonso, Andres Espejo, Sergio Dominguez, Juan Jerez, Alex, Norberto, Miguel
 */
public class DAOvendedor implements IDAOAVendedor
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
    public DAOvendedor(Connection conn){
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
     * esta funcion se encarga de insertar un vendedor en la base de datos, para ello hacemos
     * una consulta INSERT para insertar todos los atributos de la clase Vendedor, y actualizamos esa consulta
     * en la base de datos.
     *
     * @param a es el vendedor a insertar, con el cogemos cada uno de los atributos de
     *          su clase y los registramos en la base de datos
     * @return devuelve un booleano que indica si se ha insertado correctamente en la base de datos(true) o si no
     */
    public boolean altaVendedor(Vendedor a) {
        boolean correct = false;

        QUERY = "INSERT INTO Vendedores (_ID,_Nombre,_Email,_Telefono,_Articulos, _Password)" +
                " VALUES(" + a.getId() + "," + "'" + a.getNombre() + "'"+ "," + "'"+ a.getEmail() + "'" + ","+ a.getTelefono() +
                "," + "'" + vendedorParser(a.getArticulos()) + "'" + "," + "'" + hash256(a.getPassword()) + "'" + ")";

        try {
            stmt.executeUpdate(QUERY);
            correct = true;
        } catch (Exception e) {
            correct = false;
        }
        return correct;
    }

    /**
     * esta funcion se encarga de eliminar un articulo de la base de datos, para ello hacemos
     *      una consulta DELETE para eliminar el articulo de la base de datos cuyo id sea el mismo que el
     *      de la consulta, y actualizamos esa consulta en la base de datos.
     * @param id es el id del articulo a eliminar ya que es el identificador unico de este
     * @return devuelve un booleano que indica si se ha borrado correctamente de la base de datos(true) o si no
     */
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
    /**
     * esta funcion se encarga de modificar un vendedor en la base de datos, para ello hacemos
     *      una consulta UPDATE para modificar el vendedor de la base de datos con el del parametro,
     *      y actualizamos esa consulta en la base de datos.
     * @param v es el vendedor a modificar, con el cogemos cada uno de los parametros de
     *          su clase y los registramos en la base de datos,
     * @return devuelve un booleano que indica si se ha modificado correctamente en la base de datos(true) o si no
     */
    @Override
    public boolean modificarVendedor(Vendedor v) {
        boolean correct = true;
        try
        {
            //if (consultarVendedor(v.getNombre()).getNombre() == "")
            //{
              //  throw new Exception("");
           // }
            QUERY = "UPDATE Vendedores SET   _Nombre = " + "'" + v.getNombre() + "'" +
                    ", _Email = " + "'" + v.getEmail() + "'" +
                    ", _Telefono = " + "'" + v.getTelefono() + "'" +
                    ", _Articulos = " + "'" + vendedorParser(v.getArticulos()) + "'" +
                    ", _Password = " + "'" + v.getPassword() + "'" +
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

    /**
     * esta funcion se encarga de buscar un vendedor en la base de datos, para ello hacemos
     *      una consulta SELECT y usamos como condicion LIKE para que recoga nombres que
     *      empiezen por los caracteres insertados para modificar el vendedor de la base de datos con el del parametro.
     * @param username es el nombre del vendedor a modificar, con el cogemos cada uno
     *               de los parametros de su clase y los registramos en la base de datos
     * @return devuelve un booleano que indica si se ha realizado la busqueda correctamente
     *         en la base de datos(true) o si no
     */

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
                    vend.setPassword(rs.getString("_Password"));
                    c.add(vend);
                }
            } catch (NullPointerException e) {
                throw new NullPointerException("No existen Vendedores en la base de datos");
            }
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage() + " No se ha identificado el nombre");
        }
        return c;
    }
    /**
     * esta funcion se encarga de consultar un vendedor en la base de datos, para ello hacemos
     *      *      una consulta SELECT para consultar el vendedor de la base de datos cuyo id sea el mismo que el
     *      *      de la consulta.
     * @param username es el id del vendedor a consultar, con el cogemos cada uno
     *               de los parametros de su clase y los registramos en la base de datos
     * @return devuelve un booleano que indica si se ha realizado la consulta correctamente
     *         en la base de datos(true) o si no
     */
    @Override
    public Vendedor consultarVendedor(String username) {
        Vendedor vend = new Vendedor();
        QUERY = "SELECT * FROM Vendedores WHERE _Nombre = " + "'" + username + "'";

        try {
            rs = stmt.executeQuery(QUERY);
            vend.setId(rs.getInt("_ID"));
            vend.setNombre(rs.getString("_Nombre"));
            vend.setEmail(rs.getString("_Email"));
            vend.setTelefono(rs.getLong("_Telefono"));
            vend.setPassword(rs.getString("_Password"));
            vend.setArticulos(vendedorParser(rs.getString("_Articulos")));
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

        if(!articulos_id[0].equals("null"))
        {
            for (String id : articulos_id)
            {
                ret.add(ArticulosDao.consultarArticulo(Integer.parseInt(id)));
            }
        }
        else
        {
            ret = null;
        }
        return ret;
    }

    public String vendedorParser(List<Articulo> arts)
    {
        String ret = "";
        if (arts != null)
        {
            ret = arts.toString();
            ret = ret.substring(1, ret.length() - 1);
            ret = ret.replaceAll(" ", "");
        }
        return ret;
    }
}
