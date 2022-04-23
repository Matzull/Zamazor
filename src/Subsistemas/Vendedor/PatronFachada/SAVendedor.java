package Subsistemas.Vendedor.PatronFachada;

import ModeloDominio.Vendedor;
import Subsistemas.Vendedor.DAO.FachadaDAOVendedorImpl;

import java.util.List;

public class SAVendedor implements ISAVendedor{

    private FachadaDAOVendedorImpl DAO;

    public SAVendedor(){DAO = new FachadaDAOVendedorImpl();}

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
    public Vendedor consultarVendedor(int id) {
        return DAO.consultarVendedor(id);
    }
}
