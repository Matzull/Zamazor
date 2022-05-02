package View.Controllers;

import ModeloDominio.Comprador;
import ModeloDominio.Pedido;
import Subsistemas.Comprador.FachadaComprador;
import Subsistemas.Comprador.ImplFachadaComprador;

import java.util.List;

/**
 * el controlador de Comprador se encarga de llamar a las funciones de la fachada de la vista
 * para ser llamada por la logica del programa
 */

public class CompradorController {

    private Comprador c;
    private FachadaComprador fachadaComprador;

    /**
     * en la constructora vacia se insertan valores por defecto al atributo pedido de la clase
     * e inicia el atributo FachadaComprador con ImplFachadaComprador()
     */

    public CompradorController(){
        this.c = new Comprador();
        fachadaComprador = new ImplFachadaComprador();
    }

    /**
     * en la constructora con parametros asignamos los valores al atributo del Vendedor
     */

    public CompradorController(Integer id, String nombre, String email, String cuenta, String direccion, List<Pedido> pedidos, String password){
        this.c = new Comprador(id,nombre,email,cuenta,direccion,pedidos,password);
    }

    /**
     * @return devuelve el Comprador de la clase para que otras clases lo puedan usar
     */

    public Comprador getComprador(){return this.c;}

    /**
     * @param c es el Comprador a insertar en la base de datos
     * @return devuelve el booleano de la logica del programa que indica el exito de la operacion
     */

    public boolean altaComprador(Comprador c){return fachadaComprador.altaComprador(c);}

    /**
     * @param c es el Comprador a modificar en la base de datos
     * @return devuelve el booleano de la logica del programa que indica el exito de la operacion
     */

    public boolean modificarComprador(Comprador c){return fachadaComprador.modificarComprador(c);}

    /**
     * @param id es el identificador del Comprador a eliminar en la base de datos
     * @return devuelve el booleano de la logica del programa que indica el exito de la operacion
     */

    public boolean bajaComprador(Integer id){return fachadaComprador.bajaComprador(id);}

    /**
     * @param nombre es el nombre o el semejante del archivo o de los archivos a buscar en la base de datos
     * @return devuelve el Comprador resultante del nombre puesto en la barra de busqueda
     */

    public List<Comprador> buscarComprador(String nombre){return fachadaComprador.buscarComprador(nombre);}

    /**
     * @return devuelve el Comprador resultante del nombre
     */

    public List<Comprador> fullTable(){return fachadaComprador.buscarComprador("");}

    /**
     * @param username es el identificador del archivo a consultar en la base de datos
     * @return devuelve el Comprador con el mismo id que el del parametro
     */

    public Comprador consultarComprador(String username){return fachadaComprador.consultarComprador(username);}
}
