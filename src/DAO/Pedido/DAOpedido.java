package DAO.Pedido;

import DAO.Articulo.FachadaDaoArticuloImpl;
import DAO.Articulo.IFachadaDaoArticulo;
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


public class DAOpedido implements IDAOPedido
{
    static final String DB_URL = "jdbc:sqlite:resources/Zamazor.db";

    private String QUERY;
    private Connection conn;
    private Statement stmt;
    private ResultSet rs;

    public DAOpedido(){
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

    public boolean altaPedido(Pedido p) {
        boolean correct = false;

        QUERY = "INSERT INTO Pedido (_ID,_Comprador_id,_Repartidor_id,_Direccion,_Entregado,_Entrega,_Pedido,_Articulos)" +
                " VALUES(" + p.getId() + ","  + p.getComprador_id() + ","  + p.getRepartidor_id() + ","+ "'" + p.getDireccion() + "'" +
                 "," + p.getEntregado() + ","+ "'" + p.getEntrega() + "'" + ","+ "'" + p.getPedido() + "'" + ","+  "'" + p.getArticulos().toString() + "'" +")";

            try {
                stmt.executeUpdate(QUERY);
                correct = true;
            } catch (Exception e) {
                correct = false;
            }
            return correct;
    }

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

    public boolean modificarPedido (Pedido p) {
        boolean correct = true;
        try
        {
            QUERY = "UPDATE Pedido SET  _Comprador_id= " +p.getComprador_id() +
                    ",_Repartidor_id = " + p.getRepartidor_id() + ",_Direccion = " + "'" + p.getDireccion() + "'" +
                    ",_Entregado= " + p.getEntregado()+ ",_Entrega = " + "'" + p.getEntrega() + "'"+ ",_Pedido = "+"'" +p.getPedido() +"'" +",_Articulos = "+"'" +p.getArticulos().toString()  +"'" + " WHERE _ID = " + p.getId();
            stmt.executeUpdate(QUERY);
            correct = true;
        }
        catch (Exception e)
        {
            correct = false;
        }
        return correct;
    }

    public List<Pedido> buscarPedido (String id){
        List<Pedido> l = new ArrayList<>();
        boolean correct = false;

        if (id == "")
        {
            QUERY = "SELECT * FROM Pedido";
        }
        else
        {
            QUERY = "SELECT * FROM Pedido WHERE _Comprador_id LIKE " + "'%" + id + "%'";
        }

        try {
            rs = stmt.executeQuery(QUERY);
            try {
                while (rs.next()) {
                    Pedido pe = new Pedido();
                    pe.setId(rs.getInt("_ID"));
                    pe.setComprador_id(rs.getInt("_Comprador_id"));
                    pe.setRepartidor_id(rs.getInt("_Vendedor_id"));
                    pe.setDireccion(rs.getString("_Direccion"));
                    pe.setEntregado(rs.getBoolean("_Entregado"));
                    pe.setEntrega(rs.getString("_Entrega"));
                    pe.setPedido(rs.getString("_Pedido"));
                    pe.setArticulos(pedidoParser(rs.getString("_Articulos")));
                    l.add(pe);
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

    public Pedido consultarPedido(int id)
    {
        Pedido pe = new Pedido();
        QUERY = "SELECT * FROM Pedido WHERE _ID = " + id;

        try {
            rs = stmt.executeQuery(QUERY);
            pe.setId(rs.getInt("_ID"));
            pe.setComprador_id(rs.getInt("_Comprador_id"));
            pe.setRepartidor_id(rs.getInt("_Vendedor_id"));
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
}