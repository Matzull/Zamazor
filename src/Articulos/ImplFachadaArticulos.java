package Articulos;

import ModeloDominio.Articulo;

import java.util.List;

public class ImplFachadaArticulos implements FachadaArticulos {           //Implementacion de la fachada del articulo

    private ISAArticulos sa;

    public ImplFachadaArticulos()
    {
        sa = new SAArticulos();
    }

    @Override
    public boolean altaArticulo(Articulo a) {
        return sa.altaArticulo(a);
    }

    @Override
    public boolean modificarArticulo(Articulo a) {
        return sa.modificarArticulo(a);
    }

    @Override
    public boolean bajaArticulo(int id) {
        return sa.bajaArticulo(id);
    }

    @Override
    public List<Articulo> buscarArticulo(String nombre) {
        return sa.buscarArticulo(nombre);
    }

    @Override
    public Articulo consultarArticulo(int id) {
        return sa.consultarArticulo(id);
    }

}
