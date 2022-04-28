package Subsistemas.Vendedor;

import ModeloDominio.Vendedor;

import java.util.List;

public interface FachadaVendedor {

    public boolean altaVendedor(Vendedor v);
    public boolean modificarVendedor(Vendedor v);
    public boolean bajaVendedor(int id);
    public List<Vendedor> buscarVendedor(String nombre);
    public Vendedor consultarVendedor(String username);

}
