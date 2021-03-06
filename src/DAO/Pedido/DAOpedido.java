package DAO.Pedido;

import DAO.Articulo.FachadaDaoArticuloImpl;
import DAO.Articulo.IFachadaDaoArticulo;
import ModeloDominio.Articulo;
import ModeloDominio.Pedido;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Esta es la clase DAOpedido que se encarga de recopilar
 * los datos de la tabla Pedidos de la base de datos y conectarlos con la logica del programa
 *
 * @author Marcos Alonso, Andres Espejo, Sergio Dominguez, Juan Jerez, Alex, Norberto, Miguel
 */
public class DAOpedido implements IDAOPedido
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
    public DAOpedido(Connection conn){
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
     * esta funcion se encarga de insertar un pedido en la base de datos, para ello hacemos
     * una consulta INSERT para insertar todos los atributos de la clase pedido, y actualizamos esa consulta
     * en la base de datos.
     *
     * @param p es el pedido a insertar, con el cogemos cada uno de los atributos de
     *          su clase y los registramos en la base de datos
     * @return devuelve un booleano que indica si se ha insertado correctamente en la base de datos(true) o si no
     */
    public boolean altaPedido(Pedido p) {
        boolean correct = false;

        QUERY = "INSERT INTO Pedido (_ID,_Comprador_id,_Repartidor_id,_Direccion,_Entregado,_Entrega,_Pedido,_Articulos)" +
                " VALUES(" + p.getId() + ","  + p.getComprador_id() + ","  + p.getRepartidor_id() + ","+ "'" + p.getDireccion() + "'" +
                 "," + p.getEntregado() + ","+ "'" + p.getEntrega() + "'" + ","+ "'" + p.getPedido() + "'" + ","+  "'" + pedidoParser(p.getArticulos()) + "'" +")";

            try {
                stmt.executeUpdate(QUERY);
                correct = true;
            } catch (Exception e) {
                correct = false;
            }
            return correct;
    }
    /**
     * esta funcion se encarga de eliminar un pedido de la base de datos, para ello hacemos
     *      una consulta DELETE para eliminar el pedido de la base de datos cuyo id sea el mismo que el
     *      de la consulta, y actualizamos esa consulta en la base de datos.
     * @param id es el id del pedido a eliminar ya que es el identificador unico de este
     * @return devuelve un booleano que indica si se ha borrado correctamente de la base de datos(true) o si no
     */
    public boolean bajaPedido (int id){
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
     * esta funcion se encarga de modificar un pedido en la base de datos, para ello hacemos
     *      una consulta UPDATE para modificar el pedido de la base de datos con el del parametro,
     *      y actualizamos esa consulta en la base de datos.
     * @param p es el pedido a modificar, con el cogemos cada uno de los parametros de
     *          su clase y los registramos en la base de datos,
     * @return devuelve un booleano que indica si se ha modificado correctamente en la base de datos(true) o si no
     */
    public boolean modificarPedido (Pedido p) {
        boolean correct = true;
        try
        {
            QUERY = "UPDATE Pedido SET  _Comprador_Id= " +p.getComprador_id() +
                    ",_Repartidor_Id = " + p.getRepartidor_id() + ",_Direccion = " + "'" + p.getDireccion() + "'" +
                    ",_Entregado= " + p.getEntregado()+ ",_Entrega = " + "'" + p.getEntrega() + "'"+ ",_Pedido = "+"'" +p.getPedido() +"'" +",_Articulos = "+"'" + pedidoParser(p.getArticulos())  +"'" + " WHERE _ID = " + p.getId();
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
     * esta funcion se encarga de buscar un pedido en la base de datos, para ello hacemos
     *      una consulta SELECT y usamos como condicion LIKE para que recoga nombres que
     *      empiezen por los caracteres insertados para modificar el pedido de la base de datos con el del parametro.
     * @param id es el nombre del pedido a modificar, con el cogemos cada uno
     *               de los parametros de su clase y los registramos en la base de datos
     * @return devuelve un booleano que indica si se ha realizado la busqueda correctamente
     *         en la base de datos(true) o si no
     */
    public List<Pedido> buscarPedido (String id){
        List<Pedido> l = new ArrayList<>();
        boolean correct = false;

        if (id == "")
        {
            QUERY = "SELECT * FROM Pedido";
        }
        else
        {
            QUERY = "SELECT * FROM Pedido WHERE _Comprador_Id LIKE " + "'%" + id + "%'";
        }

        try {
            rs = stmt.executeQuery(QUERY);
            try {
                while (rs.next()) {
                    Pedido pe = new Pedido();
                    pe.setId(rs.getInt("_ID"));
                    pe.setComprador_id(rs.getInt("_Comprador_Id"));
                    pe.setRepartidor_id(rs.getInt("_Repartidor_Id"));
                    pe.setDireccion(rs.getString("_Direccion"));
                    pe.setEntregado(rs.getBoolean("_Entregado"));
                    pe.setEntrega(rs.getString("_Entrega"));
                    pe.setPedido(rs.getString("_Pedido"));
                    pe.setArticulos(pedidoParser(rs.getString("_Articulos")));
                    l.add(pe);
                }
            } catch (NullPointerException e) {
                throw new NullPointerException("Los pedidos no estan en la base de datos");
            }
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage() + " No se ha identificado el nombre");
        }
        return l;
    }
    /**
     * esta funcion se encarga de consultar un pedido en la base de datos, para ello hacemos
     *      una consulta SELECT para consultar el pedido de la base de datos cuyo id sea el mismo que el
     *      de la consulta.
     * @param id es el id del pedido a consultar, con el cogemos cada uno
     *               de los parametros de su clase y los registramos en la base de datos
     * @param mode si mode es false coge el id del Pedido y si es true coge el id del comprador
     *             para ver cual es el ultimo pedido de este
     * @return devuelve un booleano que indica si se ha realizado la consulta correctamente
     *         en la base de datos(true) o si no
     */
    public Pedido consultarPedido(int id, boolean mode)//mode = false -> modo normal; mode = true -> modo comprador_id
    {

        Pedido pe = new Pedido();
        QUERY = "SELECT * FROM Pedido WHERE _ID = " + id;
        if (mode)
        {
            QUERY = "SELECT * FROM Pedido WHERE _Comprador_Id = " + id + " AND _Pedido =" + "'" + "null" + "'";
        }


        try {
            rs = stmt.executeQuery(QUERY);
            pe.setId(rs.getInt("_ID"));
            pe.setComprador_id(rs.getInt("_Comprador_Id"));
            pe.setRepartidor_id(rs.getInt("_Repartidor_Id"));
            pe.setDireccion(rs.getString("_Direccion"));
            pe.setEntregado(rs.getBoolean("_Entregado"));
            pe.setEntrega(rs.getString("_Entrega"));
            pe.setPedido(rs.getString("_Pedido"));
            pe.setArticulos(pedidoParser(rs.getString("_Articulos")));
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage() + " No se ha identificado el id");
        }
        return pe;
    }

    public static ImageIcon Blob_to_Image(byte[] img)
    {
        ImageIcon ret = null;

        try{
            ByteArrayInputStream inStreambj = new ByteArrayInputStream(img);
            BufferedImage image = ImageIO.read(inStreambj);

            ret = new ImageIcon(image.getScaledInstance(202, (int)((202.0 / image.getWidth()) * image.getHeight()), Image.SCALE_SMOOTH));
        }
        catch (Exception e)
        {
            System.out.println("Cannot load image");
        }
        return ret;
    }

    public List<Articulo> pedidoParser(String articulos)
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

    public String pedidoParser(List<Articulo> arts)
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