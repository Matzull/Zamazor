package View.Controllers;

import ModeloDominio.Articulo;
import ModeloDominio.Vendedor;
import Subsistemas.Vendedor.FachadaVendedor;
import Subsistemas.Vendedor.ImplFachadaVendedor;

import java.util.List;

public class VendedorController {

    private Vendedor v;
    private FachadaVendedor fachadaVendedor;

    public VendedorController(){
        this.v = new Vendedor();
        fachadaVendedor = new ImplFachadaVendedor();
    }

    public VendedorController(Integer id, String nombre, String email, Long telefono, List<Articulo> Articulos, String password){
        this.v = new Vendedor(id,nombre,email,telefono,Articulos, password);
    }

    public Vendedor getVendedor(){return this.v;}

    public boolean altaVendedor(Vendedor v){return fachadaVendedor.altaVendedor(v);}

    public boolean modificarVendedor(Vendedor v){return fachadaVendedor.modificarVendedor(v);}

    public boolean bajaVendedor(Integer id){return fachadaVendedor.bajaVendedor(id);}

    public List<Vendedor> buscarVendedor(String nombre){return fachadaVendedor.buscarVendedor(nombre);}

    public List<Vendedor> fullTable(){return fachadaVendedor.buscarVendedor("");}

    public Vendedor consultarVendedor(String username){return fachadaVendedor.consultarVendedor(username);}

}
