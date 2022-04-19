package Articulos;

import ModeloDominio.Articulo;

import java.util.List;

public interface FachadaArticulos {                     //Fachada articulo

    boolean altaArticulo(Articulo a);
    boolean modificarArticulo(Articulo a);
    boolean bajaArticulo(int id);
    List<Articulo> buscarArticulo(String nombre);
    Articulo consultarArticulo(int id);

}
