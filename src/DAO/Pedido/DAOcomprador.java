package DAO.Pedido;

import ModeloDominio.Articulo;
import ModeloDominio.Comprador;

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

    public boolean altaComprador(Comprador a) {
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

    public boolean modificarComprador (Articulo a) {
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

    public List<Comprador> buscarComprador (String nombre){
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

    public Articulo consultarComprador(int id)
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
            ar.setImage(Blob_to_Image(b));
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage() + " No se ha identificado el id");
        }
        return ar;
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

}