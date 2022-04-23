package DAO.Vendedor;

import ModeloDominio.Vendedor;

import java.util.List;

public interface IDAOAVendedor {
     boolean altaVendedor(Vendedor v);

     boolean bajaVendedor(int id);

     boolean modificarVendedor(Vendedor v);

     List<Vendedor> buscarVendedor(String username);

     Vendedor consultarVendedor(int id);
}
