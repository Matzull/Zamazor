package DAO.Vendedor;

import ModeloDominio.Vendedor;

import java.util.List;

public interface IFachadaDaoVendedor {

    public boolean altaVendedor(Vendedor v);

    public boolean bajaVendedor(int id);

    public boolean modificarVendedor(Vendedor v);

    public List<Vendedor> buscarVendedor(String username);

    public Vendedor consultarVendedor(String username);

}
