package DAO;

import ModeloDominio.Articulo;

import java.util.List;

public interface IFachadaDaoArticulo {

    public boolean altaArticulo(Articulo art);
    public boolean bajaArticulo(int id);
    public boolean modificarArticulo(Articulo art);
    public List<Articulo> buscarArticulos(String nombre);
    public Articulo consultarArticulo(int id);

}
