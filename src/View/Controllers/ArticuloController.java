package View.Controllers;

import Subsistemas.Articulos.FachadaArticulos;
import Subsistemas.Articulos.ImplFachadaArticulos;
import ModeloDominio.Articulo;

import javax.swing.*;
import java.util.List;

/**
 * el controlador de articulo se encarga de llamar a las funciones de la fachada de la vista
 * para ser llamada por la logica del programa
 */
public class ArticuloController {
    private Articulo a;
    private FachadaArticulos fachadaArticulos;


    /**
     * en la constructora vacia se insertan valores por defecto al atributo articulo de la clase
     * e inicia el atributo fachadaArticulos con ImplFachadaArticulos()
     */
    public ArticuloController(){
        this.a = new Articulo();
        this.fachadaArticulos = new ImplFachadaArticulos();
    }
    

    /**
     * en la constructora con parametros asignamos los valores al atributo del articulo
     */
    public ArticuloController(Integer id, Double rating, Double precio, Integer sellerId, String name, String description,
                              String department, Boolean stock, ImageIcon image){
        this.a = new Articulo(id, rating, precio, sellerId, name, description, department, stock, image);
    }

    /**
     * @return devuelve el articulo de la clase para que otras clases lo puedan usar
     */
    public Articulo getArticulo() {
    	return this.a;
    }
    /**
     * @param a es el articulo a modificar en la base de datos
     * @return devuelve el booleano de la logica del programa que indica el exito de la operacion
     */
    public boolean modificarArticulo(Articulo a) { 
    	return fachadaArticulos.modificarArticulo(a);
    }

    /**
     * @return devuelve toda la lista de articulos de la base de datos que es pasada por la fachada de la logica
     */
    public List<Articulo> fullTable()
    {
        return fachadaArticulos.buscarArticulo("");
    }

    /**
     * @param a es el articulo a insertar en la base de datos
     * @return devuelve el booleano de la logica del programa que indica el exito de la operacion
     */
    public boolean altaArticulo(Articulo a)
    {
        return fachadaArticulos.altaArticulo(a);
    }
    /**
     * @param id es el identificador del articulo a eliminar en la base de datos
     * @return devuelve el booleano de la logica del programa que indica el exito de la operacion
     */
    public boolean bajaArticulo(Integer id)
    {
        return fachadaArticulos.bajaArticulo(id);
    }
    /**
     * @param nombre es el nombre o el semejante del archivo o de los archivos a buscar en la base de datos
     * @return devuelve toda la lista de articulos resultante del nombre puesto en la barra de busqueda
     */
    public List<Articulo> buscarArticulo(String nombre)
    {
        return fachadaArticulos.buscarArticulo(nombre);
    }
    /**
     * @param id es el identificador del archivo a consultar en la base de datos
     * @return devuelve el articulo con el mismo id que el del parametro
     */
    public Articulo consultarArticulo(int id)
    {
        return fachadaArticulos.consultarArticulo(id);
    }


}
