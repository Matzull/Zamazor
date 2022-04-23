package Subsistemas.Articulos;

import ModeloDominio.Articulo;

import java.util.List;

public interface FachadaArticulos {                     //Fachada articulo

    public boolean altaArticulo(Articulo a);
    public boolean modificarArticulo(Articulo a);
    public boolean bajaArticulo(int id);
    public List<Articulo> buscarArticulo(String nombre);
    public Articulo consultarArticulo(int id);

}
