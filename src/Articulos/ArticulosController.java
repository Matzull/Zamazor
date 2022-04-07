package Articulos;

public class ArticulosController {

    private Articulos a;

    //Constructor vacio. Valores por defecto
    public ArticulosController(){
        this.a = new Articulos();
    }
    
    //Constructor con parametros. Contectar con BBDD
    public ArticulosController(Integer id, Integer rating, Integer sellerId, String name, String description,
                               String department, Boolean stock){
        this.a = new Articulos(id, rating, sellerId, name, description, department, stock);
    }

    public void addObserver(ArticulosObserver o){
        a.addObserver(o);
    }

    public void removeObserver(ArticulosObserver o){
        a.removeObserver(o);
    }
}
