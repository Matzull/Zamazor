package DAO.Comprador;

import ModeloDominio.Articulo;
import ModeloDominio.Comprador;

import java.util.List;
public interface IDAOAComprador {

    public boolean altaComprador(Comprador comp);

    public boolean bajaComprador(int id);

    public boolean modificarComprador(Comprador comp);

    public List<Comprador> buscarComprador(String Nombre);

    public Comprador consultarComprador(int id);

}
