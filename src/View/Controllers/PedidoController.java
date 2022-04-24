package View.Controllers;

import ModeloDominio.Articulo;
import ModeloDominio.Pedido;
import Subsistemas.Pedido.ImplFachadaPedido;

import java.util.List;

public class PedidoController {

    private Pedido p;
    private ImplFachadaPedido fachadaPedido;

    public PedidoController(){
        this.p = new Pedido();
    }

    public PedidoController(Integer id, Integer comprador_id, Integer vendedor_id, String direccion, Boolean entregado, String entrega, String pedido, List<Articulo> articulos){
        this.p = new Pedido(id, vendedor_id, comprador_id, direccion, entregado, entrega, pedido, articulos);
    }

    public Pedido getPedido(){return this.p;}

    public boolean altaPedido(Pedido p){return fachadaPedido.altaPedido(p);}

    public boolean modificarPedido(Pedido p){return fachadaPedido.modificarPedido(p);}

    public boolean bajaPedido(Integer id){return fachadaPedido.bajaPedido(id);}

    public List<Pedido> buscarPedido(String nombre){return fachadaPedido.buscarPedido(nombre);}

    public List<Pedido> fullTable(){return fachadaPedido.buscarPedido("");}

    public Pedido consultarPedido(int id){return fachadaPedido.consultarPedido(id);}
}
