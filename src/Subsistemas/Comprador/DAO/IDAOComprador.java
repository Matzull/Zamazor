package Subsistemas.Comprador.DAO;

import ModeloDominio.Comprador;

import java.util.List;

public interface IDAOComprador {

    public boolean altaComprador(Comprador comprador);
    public boolean modificarComprador(Comprador comprador);
    public boolean bajaComprador(Integer id);
    public List<Comprador> buscarComprador(String nombre);
    public Comprador consultarComprador(Integer id);

}
