package Subsistemas.Pedido.DAO;

import ModeloDominio.Pedido;

import java.util.List;

public class FachadaDAOPedidoImpl implements IFachadaDAOPedido {

    @Override
    public boolean altaPedido(Pedido p) {
        return false;
    }

    @Override
    public boolean modificarPedido(Pedido p) {
        return false;
    }

    @Override
    public boolean bajaPedido(int id) {
        return false;
    }

    @Override
    public List<Pedido> buscarPedido(String nombre) {
        return null;
    }

    @Override
    public Pedido consultarPedido(int id) {
        return null;
    }
}
