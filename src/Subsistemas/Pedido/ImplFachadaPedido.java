package Subsistemas.Pedido;

import ModeloDominio.Pedido;

import java.util.List;

public class ImplFachadaPedido implements FachadaPedido {

    private ISAPedido sa;

    public ImplFachadaPedido(){sa = new SAPedido();}


    @Override
    public boolean altaPedido(Pedido p) {
        return sa.altaPedido(p);
    }

    @Override
    public boolean modificarPedido(Pedido p) {
        return sa.modificarPedido(p);
    }

    @Override
    public boolean bajaPedido(int id) {
        return sa.bajaPedido(id);
    }

    @Override
    public List<Pedido> buscarPedido(String nombre) {
        return sa.buscarPedido(nombre);
    }

    @Override
    public Pedido consultarPedido(int id) {
        return sa.consultarPedido(id);
    }
}
