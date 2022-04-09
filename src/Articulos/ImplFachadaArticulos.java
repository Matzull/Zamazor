package Articulos;

import java.util.ArrayList;
import java.util.List;

public class ImplFachadaArticulos implements FachadaArticulos {           //Implementacion de la fachada del articulo

    private SAArticulos sa;

    @Override
    public boolean altaArticulo(Articulo a) {
        return sa.altaArticulo(a);
    }

    @Override
    public boolean modificarArticulo(Articulo a) {
        return sa.modificarArticulo(a);
    }

    @Override
    public boolean bajaArticulo(Articulo a) {
        return sa.bajaArticulo(a);
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
