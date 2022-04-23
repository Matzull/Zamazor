package Subsistemas.Pedido.PatronFachada;

import ModeloDominio.Pedido;
import Subsistemas.Pedido.DAO.FachadaDAOPedidoImpl;

import java.util.List;

public class SAPedido implements ISAPedido {

    private FachadaDAOPedidoImpl DAO;

    public SAPedido(){DAO = new FachadaDAOPedidoImpl();}


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
