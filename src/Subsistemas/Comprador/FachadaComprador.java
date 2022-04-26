package Subsistemas.Comprador;

import ModeloDominio.Comprador;

import java.util.List;

public interface FachadaComprador {

    public boolean altaComprador(Comprador c);
    public boolean modificarComprador(Comprador c);
    public boolean bajaComprador(Integer id);
    public List<Comprador> buscarComprador(String nombre);
    public Comprador consultarComprador(Integer id);

}
