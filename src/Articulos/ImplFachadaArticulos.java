package Articulos;

import java.util.ArrayList;

public class ImplFachadaArticulos implements FachadaArticulos {           //Implementacion de la fachada del articulo

    private SAArticulos sa;

    @Override
    public boolean altaArticulo(Articulos a) {
        return sa.altaArticulo(a);
    }

    @Override
    public boolean modificarArticulo(Articulos a) {
        return sa.modificarArticulo(a);
    }

    @Override
    public boolean bajaArticulo(Articulos a) {
        return sa.bajaArticulo(a);
    }

    @Override
    public ArrayList<Articulos> buscarArticulo(String nombre) {
        return sa.buscarArticulo(nombre);
    }

    @Override
    public Articulos consultarArticulo(int id) {
        return sa.consultarArticulo(id);
    }
}
