package Subsistemas.Vendedor.DAO;

import ModeloDominio.Vendedor;

import java.util.List;

public class DAOVendedor implements IDAOVendedor{
    @Override
    public boolean altaVendedor(Vendedor v) {
        return false;
    }

    @Override
    public boolean modificarVendedor(Vendedor v) {
        return false;
    }

    @Override
    public boolean bajaVendedor(int id) {
        return false;
    }

    @Override
    public List<Vendedor> buscarVendedor(String nombre) {
        return null;
    }

    @Override
    public Vendedor consultarVendedor(int id) {
        return null;
    }
}
