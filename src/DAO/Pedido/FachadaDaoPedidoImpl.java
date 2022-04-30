package DAO.Pedido;

import Misc.Util;
import ModeloDominio.Pedido;

import java.util.List;

public class FachadaDaoPedidoImpl implements IFachadaDaoPedido {

    private IDAOPedido Dao;

    public FachadaDaoPedidoImpl(){Dao = new DAOpedido(Util.conn);}

    @Override
    public boolean altaPedido(Pedido p) {
        return Dao.altaPedido(p);
    }

    @Override
    public boolean modificarPedido(Pedido p) {
        return Dao.modificarPedido(p);
    }

    @Override
    public boolean bajaPedido(int id) {
        return Dao.bajaPedido(id);
    }

    @Override
    public List<Pedido> buscarPedido(String id) {return Dao.buscarPedido(id);}

    @Override
    public Pedido consultarPedido(int id) {
        return Dao.consultarPedido(id);
    }
}
