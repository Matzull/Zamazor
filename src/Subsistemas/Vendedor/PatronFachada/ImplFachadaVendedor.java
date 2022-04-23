package Subsistemas.Vendedor.PatronFachada;

import ModeloDominio.Vendedor;

import java.util.List;

public class ImplFachadaVendedor implements FachadaVendedor{

    private ISAVendedor sa;

    public ImplFachadaVendedor(){sa = new SAVendedor();}

    @Override
    public boolean altaVendedor(Vendedor v) {
        return sa.altaVendedor(v);
    }

    @Override
    public boolean modificarVendedor(Vendedor v) {
        return sa.modificarVendedor(v);
    }

    @Override
    public boolean bajaVendedor(int id) {
        return sa.bajaVendedor(id);
    }

    @Override
    public List<Vendedor> buscarVendedor(String nombre) {
        return sa.buscarVendedor(nombre);
    }

    @Override
    public Vendedor consultarVendedor(int id) {
        return sa.consultarVendedor(id);
    }
}
