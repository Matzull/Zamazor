package Articulos;

import ModeloDominio.Articulo;

import java.util.List;

public interface ISAArticulos{

    public boolean altaArticulo(Articulo a);

    public boolean modificarArticulo(Articulo a);

    public boolean bajaArticulo(int id);

    public List<Articulo> buscarArticulo(String nombre);

    public Articulo consultarArticulo(int id);
}
