package Subsistemas.Pedido;

import ModeloDominio.Pedido;

import java.util.List;

public interface ISAPedido {

    public boolean altaPedido(Pedido p);
    public boolean modificarPedido(Pedido p);
    public boolean bajaPedido(int id);
    public List<Pedido> buscarPedido(String nombre);
    public Pedido consultarPedido(int id, boolean mode);

}
