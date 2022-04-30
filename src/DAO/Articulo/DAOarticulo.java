package DAO.Articulo;

import Misc.Util;
import ModeloDominio.Articulo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Esta es la clase DAOarticulo que se encarga de recopilar
 * los datos de la tabla Articulo de la base de datos y conectarlos con la logica del programa
 *
 * @author Marcos Alonso, Andres Espejo, Sergio Dominguez, Juan Jerez, Alex, Norberto, Miguel
 */

public class DAOarticulo implements IDAOArticulo
{

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
    public DAOarticulo(Connection conn){
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
     * esta funcion se encarga de insertar un articulo en la base de datos, para ello hacemos
     * una consulta INSERT para insertar todos los atributos de la clase articulo, y actualizamos esa consulta
     * en la base de datos.
     *
     * @param a es el articulo a insertar, con el cogemos cada uno de los atributos de
     *          su clase y los registramos en la base de datos
     * @return devuelve un booleano que indica si se ha insertado correctamente en la base de datos(true) o si no
     */
    public boolean altaArticulo(Articulo a) {
        boolean correct = false;

        QUERY = "INSERT INTO Articulos (_ID,_Nombre,_Precio,_Stock,_Description,_Valoracion,_Tipo,_Vendedor_id)" +
                " VALUES(" + a.getId() + "," + "'" + a.getNombre() + "'"+ ","  + a.getPrecio() + ","+ a.getStock() +
                 ","+ "'" + a.getDescripcion() +"'" + ","+ a.getValoracion() + ","+ "'" + a.getTipo() + "'" + ","+  a.getVendedor_id() +")";

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
     *      en la base de datos.
     * @param id es el id del articulo a eliminar ya que es el identificador unico de este
     * @return devuelve un booleano que indica si se ha borrado correctamente de la base de datos(true) o si no
     */
    public boolean bajaArticulo (int id){
        boolean correct = false;

        QUERY = "delete from Articulos where _Id = " + id;
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
     * esta funcion se encarga de modificar un articulo en la base de datos, para ello hacemos
     *      una consulta UPDATE para modificar el articulo de la base de datos con el del parametro,
     *      y actualizamos esa consulta en la base de datos.
     * @param a es el articulo a modificar, con el cogemos cada uno de los parametros de
     *          su clase y los registramos en la base de datos,
     * @return devuelve un booleano que indica si se ha modificado correctamente en la base de datos(true) o si no
     */
    public boolean modificarArticulo (Articulo a) {
        boolean correct = true;
        try
        {
            if (consultarArticulo(a.getId()).getNombre() == "")
            {
                throw new Exception("");
            }
            QUERY = "UPDATE Articulos SET  _Nombre = " + "'" + a.getNombre() + "'" + ",_Precio= " +a.getPrecio() +
                    ",_Stock = " + a.getStock() + ",_Description = " + "'" + a.getDescripcion() + "'" +
                    ",_Valoracion = " +a.getValoracion()+ ",_Tipo = " + "'" + a.getTipo() + "'"+ ",_Vendedor_id = "+a.getVendedor_id() +  " WHERE _ID = " + a.getId();
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
     * esta funcion se encarga de buscar un articulo en la base de datos, para ello hacemos
     *      una consulta SELECT y usamos como condicion LIKE para que recoga nombres que
     *      empiezen por los caracteres insertados para modificar el articulo de la base de datos con el del parametro.
     * @param nombre es el nombre del articulo a modificar, con el cogemos cada uno
     *               de los parametros de su clase y los registramos en la base de datos
     * @return devuelve un booleano que indica si se ha realizado la busqueda correctamente
     *         en la base de datos(true) o si no
     */
    public List<Articulo> buscarArticulos (String nombre){
        List<Articulo> l = new ArrayList<Articulo>();
        boolean correct = false;

        if (nombre == "")
        {
            QUERY = "SELECT * FROM Articulos";
        }
        else
        {
            QUERY = "SELECT * FROM Articulos WHERE _Nombre LIKE " + "'%" + nombre + "%'";
        }

        try {
            rs = stmt.executeQuery(QUERY);
            try {
                while (rs.next()) {
                    Articulo ar = new Articulo();
                    ar.setId(rs.getInt("_ID"));
                    ar.setDescripcion(rs.getString("_Description"));
                    ar.setNombre(rs.getString("_Nombre"));
                    ar.setPrecio(rs.getDouble("_Precio"));
                    ar.setStock(rs.getBoolean("_Stock"));
                    ar.setTipo(rs.getString("_Tipo"));
                    ar.setVendedor_id(rs.getInt("_Vendedor_id"));
                    ar.setValoracion(rs.getDouble("_Valoracion"));
                    byte[] b = rs.getBytes("_Imagen");
                    ar.setImage(Util.Blob_to_Image(b));
                    l.add(ar);
                }
            } catch (NullPointerException e) {
                throw new NullPointerException("los articulos no estan en la base de datos");
            }
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage() + " No se ha identificado el nombre");
        }
        return l;
    }
    /**
     * esta funcion se encarga de consultar un articulo en la base de datos, para ello hacemos
     *      *      una consulta SELECT para consultar el articulo de la base de datos cuyo id sea el mismo que el
     *      *      de la consulta.
     * @param id es el id del articulo a consultar, con el cogemos cada uno
     *               de los parametros de su clase y los registramos en la base de datos
     * @return devuelve un booleano que indica si se ha realizado la consulta correctamente
     *         en la base de datos(true) o si no
     */
    public Articulo consultarArticulo(int id)
    {
        Articulo ar = new Articulo();
        QUERY = "SELECT * FROM Articulos WHERE _ID = " + id;

        try {
            rs = stmt.executeQuery(QUERY);
            ar.setId(rs.getInt("_ID"));
            ar.setDescripcion(rs.getString("_Description"));
            ar.setNombre(rs.getString("_Nombre"));
            ar.setPrecio(rs.getDouble("_Precio"));
            ar.setStock(rs.getBoolean("_Stock"));
            ar.setTipo(rs.getString("_Tipo"));
            ar.setVendedor_id(rs.getInt("_Vendedor_id"));
            ar.setValoracion(rs.getDouble("_Valoracion"));
            byte[] b = rs.getBytes("_Imagen");
            ar.setImage(Util.Blob_to_Image(b));
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage() + " No se ha  identificado el id");
        }
        return ar;
    }

}