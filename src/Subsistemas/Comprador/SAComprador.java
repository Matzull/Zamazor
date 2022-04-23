package Subsistemas.Comprador;

import Subsistemas.Comprador.DAO.FachadaDAOCompradorImpl;
import ModeloDominio.Comprador;

import java.util.List;

public class SAComprador implements ISAComprador {

    private FachadaDAOCompradorImpl DAO;

    public SAComprador(){DAO = new FachadaDAOCompradorImpl();}

    @Override
    public boolean altaComprador(Comprador c) {
        return DAO.altaComprador(c);
    }

    @Override
    public boolean modificarComprador(Comprador c) {
        return DAO.modificarComprador(c);
    }

    @Override
    public boolean bajaComprador(Integer id) {
        return DAO.bajaComprador(id);
    }

    @Override
    public List<Comprador> buscarComprador(String nombre) {
        return DAO.buscarComprador(nombre);
    }

    @Override
    public Comprador consultarComprador(Integer id) {
        return DAO.consultarComprador(id);
    }
}
