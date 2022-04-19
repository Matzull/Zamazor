package DAO;

import Articulos.SAArticulos;
import ModeloDominio.Articulo;

import java.util.List;

public class FachadaDaoArticuloImpl implements IFachadaDaoArticulo {

    private IFachadaDao Dao;

    public FachadaDaoArticuloImpl(){Dao = new DAOarticulo();}

    @Override
    public boolean altaArticulo(Articulo a) {
        return Dao.altaArticulo(a);
    }

    @Override
    public boolean modificarArticulo(Articulo a) {
        return Dao.modificarArticulo(a);
    }

    @Override
    public boolean bajaArticulo(int id) {
        return Dao.bajaArticulo(id);
    }

    @Override
    public List<Articulo> buscarArticulos(String nombre) {return Dao.buscarArticulos(nombre);}

    @Override
    public Articulo consultarArticulo(int id) {
        return Dao.consultarArticulo(id);
    }
}
