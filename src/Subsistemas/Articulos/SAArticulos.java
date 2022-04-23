package Subsistemas.Articulos;

import DAO.Articulo.FachadaDaoArticuloImpl;
import DAO.Articulo.IFachadaDaoArticulo;
import ModeloDominio.Articulo;

import java.util.List;

public class SAArticulos implements ISAArticulos{  //Servicio de aplicacion

    private IFachadaDaoArticulo DAO;

    public SAArticulos()
    {
        DAO = new FachadaDaoArticuloImpl();
    }

    public boolean altaArticulo(Articulo a) {
        return DAO.altaArticulo(a);
    }

    public boolean modificarArticulo(Articulo a) {
        return DAO.modificarArticulo(a);
    }

    public boolean bajaArticulo(int id) {
        return DAO.bajaArticulo(id);
    }

    public List<Articulo> buscarArticulos(String nombre) {
        return DAO.buscarArticulos(nombre);
    }

    public Articulo consultarArticulo(int id) {
        return DAO.consultarArticulo(id);
    }

}
