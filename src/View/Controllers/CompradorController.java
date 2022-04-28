package View.Controllers;

import ModeloDominio.Comprador;
import ModeloDominio.Pedido;
import Subsistemas.Comprador.FachadaComprador;
import Subsistemas.Comprador.ImplFachadaComprador;

import java.util.List;

public class CompradorController {

    private Comprador c;
    private FachadaComprador fachadaComprador;

    public CompradorController(){
        this.c = new Comprador();
        fachadaComprador = new ImplFachadaComprador();
    }

    public CompradorController(Integer id, String nombre, String email, String cuenta, String direccion, List<Pedido> pedidos, String password){
        this.c = new Comprador(id,nombre,email,cuenta,direccion,pedidos,password);
    }

    public Comprador getComprador(){return this.c;}

    public boolean altaComprador(Comprador c){return fachadaComprador.altaComprador(c);}

    public boolean modificarComprador(Comprador c){return fachadaComprador.modificarComprador(c);}

    public boolean bajaComprador(Integer id){return fachadaComprador.bajaComprador(id);}

    public List<Comprador> buscarComprador(String nombre){return fachadaComprador.buscarComprador(nombre);}

    public List<Comprador> fullTable(){return fachadaComprador.buscarComprador("");}

    public Comprador consultarComprador(String username){return fachadaComprador.consultarComprador(username);}
}
