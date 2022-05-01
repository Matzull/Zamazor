package ModeloDominio;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private Integer id;
    private Integer comprador_id;
    private Integer repartidor_id;
    private String direccion;
    private Boolean entregado;
    private String entrega;
    private String pedido;
    private List<Articulo> articulos;

    public Pedido(){
        id = 0;
        comprador_id = 0;
        repartidor_id = 0;
        direccion = "";
        entregado = false;
        entrega = "";
        pedido = "";
        articulos = new ArrayList<Articulo>();
    }

    public Pedido(Integer id, Integer comprador_id, Integer repartidor_id, String direccion,
                  Boolean entregado, String entrega, String pedido, List<Articulo> articulos){
        this.id = id;
        this.comprador_id = comprador_id;
        this.repartidor_id = repartidor_id;
        this.direccion = direccion;
        this.entregado = entregado;
        this.entrega = entrega;
        this.pedido = pedido;
        this.articulos = articulos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getComprador_id() {
        return comprador_id;
    }

    public void setComprador_id(Integer comprador_id) {
        this.comprador_id = comprador_id;
    }

    public Integer getRepartidor_id() {
        return repartidor_id;
    }

    public void setRepartidor_id(Integer repartidor_id) {
        this.repartidor_id = repartidor_id;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Boolean getEntregado() {
        return entregado;
    }

    public void setEntregado(Boolean entregado) {
        this.entregado = entregado;
    }

    public String getEntrega() {
        return entrega;
    }

    public void setEntrega(String entrega) {
        this.entrega = entrega;
    }

    public String getPedido() {
        return pedido;
    }

    public void setPedido(String pedido) {
        this.pedido = pedido;
    }

    public List<Articulo> getArticulos() {
        return articulos;
    }

    public void setArticulos(List<Articulo> articulos) {
        this.articulos = articulos;
    }

    public String toString()
    {
        return Integer.toString(this.id);
    }

}
