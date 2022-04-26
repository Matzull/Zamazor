package Subsistemas.Pedido;

import DAO.Pedido.*;
import ModeloDominio.Pedido;

import java.util.List;

public class SAPedido implements ISAPedido {

    private FachadaDaoPedidoImpl DAO;

    public SAPedido(){DAO = new FachadaDaoPedidoImpl();}


    @Override
    public boolean altaPedido(Pedido p) {
        return DAO.altaPedido(p);
    }

    @Override
    public boolean modificarPedido(Pedido p) {
        return DAO.modificarPedido(p);
    }

    @Override
    public boolean bajaPedido(int id) {
        return DAO.bajaPedido(id);
    }

    @Override
    public List<Pedido> buscarPedido(String nombre) {
        return DAO.buscarPedido(nombre);
    }

    @Override
    public Pedido consultarPedido(int id) {
        return DAO.consultarPedido(id);
    }
}
