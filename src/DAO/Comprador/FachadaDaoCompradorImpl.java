package DAO.Comprador;

import Misc.Util;
import ModeloDominio.Articulo;
import ModeloDominio.Comprador;

import java.util.List;

public class FachadaDaoCompradorImpl implements IFachadaDaoComprador {

    private IDAOAComprador Dao;

    public FachadaDaoCompradorImpl(){Dao = new DAOcomprador(Util.conn);}

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
    public Comprador consultarComprador(String username) {
        return Dao.consultarComprador(username);
    }
}
