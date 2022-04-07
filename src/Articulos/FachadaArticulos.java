package Articulos;

import java.util.ArrayList;

public interface FachadaArticulos {                     //Fachada articulo

    boolean altaArticulo(Articulos a);
    boolean modificarArticulo(Articulos a);
    boolean bajaArticulo(Articulos a);
    ArrayList<Articulos> buscarArticulo(String nombre);
    Articulos consultarArticulo(int id);

}
