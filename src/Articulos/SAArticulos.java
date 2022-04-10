package Articulos;

import DAO.DAOarticulo;
import DAO.IFachadaDao;

import java.util.ArrayList;
import java.util.List;

public class SAArticulos {  //Servicio de aplicacion

    IFachadaDao DAO;

    public SAArticulos()
    {
        DAO = new DAOarticulo();
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

    public List<Articulo> buscarArticulo(String nombre) {
        return DAO.buscarArticulos(nombre);
    }

    public Articulo consultarArticulo(int id) {
        return DAO.consultarArticulo(id);
    }

}
