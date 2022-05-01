package DAO.Pedido;

import ModeloDominio.Pedido;

import java.util.List;
public interface IDAOPedido {

    public boolean altaPedido(Pedido p);

    public boolean bajaPedido(int id);

    public boolean modificarPedido(Pedido p);

    public List<Pedido> buscarPedido(String id);

    public Pedido consultarPedido(int id, boolean mode);

}
