package Articulos;

import java.util.ArrayList;
import java.util.List;

public interface FachadaArticulos {                     //Fachada articulo

    boolean altaArticulo(Articulo a);
    boolean modificarArticulo(Articulo a);
    boolean bajaArticulo(Articulo a);
    List<Articulo> buscarArticulo(String nombre);
    Articulo consultarArticulo(int id);

}
