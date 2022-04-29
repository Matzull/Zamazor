package DAO.Articulo;

import ModeloDominio.Articulo;

import java.util.List;
/**
 * esta clase representa la interfaz de la fachada de la clase DAOarticulo
 * que se encarga de llamar a las funciones del DAO según el cliente quiera
 */
public interface IFachadaDaoArticulo {

    public boolean altaArticulo(Articulo art);

    public boolean bajaArticulo(int id);

    public boolean modificarArticulo(Articulo art);

    public List<Articulo> buscarArticulos(String nombre);

    public Articulo consultarArticulo(int id);

}
