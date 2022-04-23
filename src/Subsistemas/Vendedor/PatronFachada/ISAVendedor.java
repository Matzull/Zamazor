package Subsistemas.Vendedor.PatronFachada;

import ModeloDominio.Vendedor;

import java.util.List;

public interface ISAVendedor {

    public boolean altaVendedor(Vendedor v);
    public boolean modificarVendedor(Vendedor v);
    public boolean bajaVendedor(int id);
    public List<Vendedor> buscarVendedor(String nombre);
    public Vendedor consultarVendedor(int id);

}
