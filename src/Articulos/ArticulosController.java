package Articulos;

import java.util.List;

public class ArticulosController {

    private Articulo a;
    private ImplFachadaArticulos fachadaArticulos;

    //Constructor vacio. Valores por defecto
    public ArticulosController(){
        this.a = new Articulo();
        this.fachadaArticulos = new ImplFachadaArticulos();
    }
    
    //Constructor con parametros. Contectar con BBDD
    public ArticulosController(Integer id, Integer rating, Integer sellerId, String name, String description,
                               String department, Boolean stock){
        this.a = new Articulo(id, rating, sellerId, name, description, department, stock);
    }

    public void addObserver(ArticulosObserver o){
        a.addObserver(o);
    }

    public void removeObserver(ArticulosObserver o){
        a.removeObserver(o);
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

}
