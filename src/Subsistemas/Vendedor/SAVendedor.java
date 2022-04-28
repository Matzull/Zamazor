package Subsistemas.Vendedor;

import DAO.Vendedor.FachadaDaoVendedorImpl;
import ModeloDominio.Vendedor;

import java.util.List;

public class SAVendedor implements ISAVendedor{

    private FachadaDaoVendedorImpl DAO;

    public SAVendedor(){DAO = new FachadaDaoVendedorImpl();}

    @Override
    public boolean altaVendedor(Vendedor v) {
        return DAO.altaVendedor(v);
    }

    @Override
    public boolean modificarVendedor(Vendedor v) {
        return DAO.modificarVendedor(v);
    }

    @Override
    public boolean bajaVendedor(int id) {
        return DAO.bajaVendedor(id);
    }

    @Override
    public List<Vendedor> buscarVendedor(String nombre) {
        return DAO.buscarVendedor(nombre);
    }

    @Override
    public Vendedor consultarVendedor(String username) {
        return DAO.consultarVendedor(username);
    }
}
