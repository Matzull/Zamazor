package DAO.Comprador;

import ModeloDominio.Comprador;

import java.util.List;

public interface IFachadaDaoComprador {

    public boolean altaComprador(Comprador comp);

    public boolean bajaComprador(int id);

    public boolean modificarComprador(Comprador comp);

    public List<Comprador> buscarComprador(String username);

    public Comprador consultarComprador(String username);

}
