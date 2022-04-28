package DAO.Vendedor;

import ModeloDominio.Vendedor;

import java.util.List;

public class FachadaDaoVendedorImpl implements IFachadaDaoVendedor{

    private IDAOAVendedor Dao;

    public FachadaDaoVendedorImpl(){Dao = new DAOvendedor();}

    @Override
    public boolean altaVendedor(Vendedor v) {
        return Dao.altaVendedor(v);
    }

    @Override
    public boolean bajaVendedor(int id) {
        return Dao.bajaVendedor(id);
    }

    @Override
    public boolean modificarVendedor(Vendedor v) {
        return Dao.modificarVendedor(v);
    }

    @Override
    public List<Vendedor> buscarVendedor(String nombre) {return Dao.buscarVendedor(nombre);}

    @Override
    public Vendedor consultarVendedor(String username) {
        return Dao.consultarVendedor(username);
    }

}
