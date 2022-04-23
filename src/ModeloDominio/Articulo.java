package ModeloDominio;

import javax.swing.*;
import java.awt.*;

public class Articulo{

    private Integer id;                 //
    private String nombre;              //
    private Double precio;              //
    private Boolean stock;              //
    private String descripcion;         //
    private Double valoracion;          //
    private String tipo;                //
    private Integer idVendedor;         //
    private ImageIcon _image;

    //Constructor vacio para valores por defecto
    public Articulo(){
        id = 0;
        nombre = "";
        stock = false;
        precio = 0.0;
        descripcion = "";
        valoracion = 0.0;
        tipo = "";
        idVendedor = 0;
        _image = null;
    }

    //Contructor con parametros. Lo mas seguro que se use este para coger los valores de la BBDD
    public Articulo(Integer id, Double valoracion, Double precio, Integer idVendedor, String name, String descripcion,
                    String tipo, Boolean stock, ImageIcon image){
        this.id = id;
        this.nombre = name;
        this.stock = stock;
        this.precio = precio;
        this.descripcion = descripcion;
        this.valoracion = valoracion;
        this.tipo = tipo;
        this.idVendedor = idVendedor;
        this._image = image;
    }

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

    public double getValoracion() {
        return valoracion;
    }

    public int getVendedor_id(){return idVendedor;}

    public String getTipo() {
        return tipo;
    }

    public double getPrecio(){return this.precio;}

    public Integer getIdVendedor() {
        return idVendedor;
    }

    public ImageIcon getImage(){return _image;}

    public void setId(Integer id) {     //Al ser atributo unico seria realmente necesario el setter?
        this.id = id;
    }

    public void setImage(ImageIcon img){this._image = img;}

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setStock(Boolean stock) {
        this.stock = stock;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setValoracion(Double valoracion) {
        this.valoracion =  valoracion;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setVendedor_id(Integer idVendedor) {
        this.idVendedor = idVendedor;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }
    //endregion

    public Articulo esIgual(Articulo a){
        if(a.equals(this)) return this;
        else return null;
    }

}
