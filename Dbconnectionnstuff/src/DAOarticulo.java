import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAOarticulo
{
    static final String DB_URL = "jdbc:sqlite:src/mydbtest.db";

    private String QUERY;
    private Connection conn;
    private Statement stmt;
    private ResultSet rs;

    public DAOarticulo(){
        try
        {
             conn = DriverManager.getConnection(DB_URL);
             stmt = conn.createStatement();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }


    public boolean altaArticulo(Articulo a) {
        boolean correct = false;

        QUERY =  "INSERT INTO " + "Zamazor" + " ("
                + "_ID" + ","
                + "_Nombre" + ","
                + "_Precio" + ","
                + "_Stock" + ","
                + "_Description" + ","
                + "_Valoracion" + ","
                + "Tipo" + ","
                + "Vendedor" +
                ") VALUES(" +
                + a.getId() + ",'"
                + a.getNombre()+ "',"
                + a.getPrecio() + ","
                + a.getStock() + ","
                + a.getDescripcion() + ","
                + a.getValoracion() + ","
                + a.getTipo() + ","
                + a.getVendedor_id() +
                ");";

        try
        {
            rs = stmt.executeQuery(QUERY);
            correct = true;
        }
        catch (SQLException e)
        {
            correct = false;
        }
        return correct;
    }

    public boolean bajaArticulo (int id){
        boolean correct = false;

        QUERY = "delete from Articulos where _Id = " + id;

        try
        {
            rs = stmt.executeQuery(QUERY);
            correct = true;
        }
        catch (SQLException e)
        {
            correct = false;
        }
        return correct;
    }


    public void ModificarArticulo (Articulo a) {

      bajaArticulo(a.getId());
      altaArticulo(a);
    }

    public List<Articulo> buscarArticulo (String nombre){
        List<Articulo> l = new ArrayList<Articulo>();

        QUERY = "SELECT * FROM Articulos WHERE _Nombre = " + nombre;

        try
        {
            rs = stmt.executeQuery(QUERY);
            while(rs.next()){

            }
            correct = true;
        }
        catch (SQLException e)
        {
            correct = false;
        }
        return correct;
    }







}