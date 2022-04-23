package DAO.Vendedor;

import ModeloDominio.Comprador;

import java.util.List;

public class FachadaDaoCompradorImpl implements IFachadaDaoComprador {

    private IDAOAComprador Dao;

    public FachadaDaoCompradorImpl(){Dao = new DAOcomprador();}

    @Override
    public boolean altaComprador(Comprador c) {
        return Dao.altaComprador(c);
    }

    @Override
    public boolean modificarComprador(Comprador c) {
        return Dao.modificarComprador(c);
    }

    @Override
    public boolean bajaComprador(int id) {
        return Dao.bajaComprador(id);
    }

    @Override
    public List<Comprador> buscarComprador(String nombre) {return Dao.buscarComprador(nombre);}

    @Override
    public Comprador consultarComprador(int id) {
        return Dao.consultarComprador(id);
    }
}
