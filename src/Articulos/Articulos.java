package Articulos;

import java.util.ArrayList;
import java.util.List;

public class Articulos implements Observable<ArticulosObserver>{
    //Quiza estaria bien que todos los objetos hereden de uno general, solo son = 2 atributos asi que igual no es muy interesante
    private Integer id;                 //
    private String nombre;              //
    private Boolean stock;              //
    private String descripcion;         // Quiza tb seria mejor static, pero mismo problema que en el rating
    private static Integer valoracion;  // No todos los articulos son iguales, asi que el static seria mejor de objetos que hereden de este
    private String tipo;                //
    private Integer idVendedor;         //
    private List<ArticulosObserver> observers;   //Lista de observadores para el MVC

    //Constructor vacio para valores por defecto
    public Articulos(){
        id = 0;
        nombre = "";
        stock = false;
        descripcion = "";
        valoracion = 0;
        tipo = "";
        idVendedor = 0;
        this.observers = new ArrayList<ArticulosObserver>();
    }

    //Contructor con parametros. Lo mas seguro que se use este para coger los valores de la BBDD
    public Articulos(Integer id, Integer valoracion, Integer idVendedor, String name, String descripcion,
                     String tipo, Boolean stock){
        this.id = id;
        this.nombre = name;
        this.stock = stock;
        this.descripcion = descripcion;
        this.valoracion = valoracion;
        this.tipo = tipo;
        this.idVendedor = idVendedor;
        this.observers = new ArrayList<ArticulosObserver>();
    }

    //Agrupa varias funciones en IntelliJ, para eclipse hace falta un plug in
    //region Getters y setters
    public Integer getId() {
        return id;
    }

    public String getNombre() { return nombre;}

    public Boolean getStock() {
        return stock;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public static Integer getValoracion() {
        return valoracion;
    }

    public String getTipo() {
        return tipo;
    }

    public Integer getIdVendedor() {
        return idVendedor;
    }

    public void setId(Integer id) {     //Al ser atributo unico seria realmente necesario el setter?
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setStock(Boolean stock) {
        this.stock = stock;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public static void setValoracion(Integer valoracion) {
        Articulos.valoracion = valoracion;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setIdVendedor(Integer idVendedor) {
        this.idVendedor = idVendedor;
    }
    //endregion

    public Articulos esIgual(Articulos a){      //No deberia ser necesaria
        if(a.equals(this)) return this;
        else return null;
    }


    public void addObserver(ArticulosObserver o) {
        if(!observers.contains(o)) this.observers.add(o);
    }

    public void removeObserver(ArticulosObserver o) {
        if(observers.contains(o)) this.observers.remove(o);
    }
}
