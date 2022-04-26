package View.Controllers;

import ModeloDominio.Comprador;
import ModeloDominio.Pedido;
import Subsistemas.Comprador.ImplFachadaComprador;

import java.util.List;

public class CompradorController {

    private Comprador c;
    private ImplFachadaComprador fachadaComprador;

    public CompradorController(){this.c = new Comprador();}

    public CompradorController(Integer id, String nombre, String email, String cuenta, String direccion, List<Pedido> pedidos, String password){
        this.c = new Comprador(id,nombre,email,cuenta,direccion,pedidos,password);
    }

    public Comprador getComprador(){return this.c;}

    public boolean altaComprador(Comprador c){return fachadaComprador.altaComprador(c);}

    public boolean modificarComprador(Comprador c){return fachadaComprador.modificarComprador(c);}

    public boolean bajaComprador(Integer id){return fachadaComprador.bajaComprador(id);}

    public List<Comprador> buscarComprador(String nombre){return fachadaComprador.buscarComprador(nombre);}

    public List<Comprador> fullTable(){return fachadaComprador.buscarComprador("");}

    public Comprador consultarComprador(int id){return fachadaComprador.consultarComprador(id);}
}
