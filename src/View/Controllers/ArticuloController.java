package View.Controllers;

import Subsistemas.Articulos.FachadaArticulos;
import Subsistemas.Articulos.ImplFachadaArticulos;
import ModeloDominio.Articulo;

import javax.swing.*;
import java.util.List;

public class ArticuloController {
    private Articulo a;
    private FachadaArticulos fachadaArticulos;

    //Constructor vacio. Valores por defecto
    public ArticuloController(){
        this.a = new Articulo();
        this.fachadaArticulos = new ImplFachadaArticulos();
    }
    
    //Constructor con parametros. Contectar con BBDD
    public ArticuloController(Integer id, Double rating, Double precio, Integer sellerId, String name, String description,
                              String department, Boolean stock, ImageIcon image){
        this.a = new Articulo(id, rating, precio, sellerId, name, description, department, stock, image);
    }

    public Articulo getArticulo() {
    	return this.a;
    }

    public boolean modificarArticulo(Articulo a) { 
    	return fachadaArticulos.modificarArticulo(a);
    }

    public List<Articulo> fullTable()
    {
        return fachadaArticulos.buscarArticulo("");
    }

    public boolean altaArticulo(Articulo a)
    {
        return fachadaArticulos.altaArticulo(a);
    }

    public boolean bajaArticulo(Integer id)
    {
        return fachadaArticulos.bajaArticulo(id);
    }

    public List<Articulo> buscarArticulo(String nombre)
    {
        return fachadaArticulos.buscarArticulo(nombre);
    }

    public Articulo consultarArticulo(int id)
    {
        return fachadaArticulos.consultarArticulo(id);
    }


}
