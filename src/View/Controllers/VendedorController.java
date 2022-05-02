package View.Controllers;

import ModeloDominio.Articulo;
import ModeloDominio.Vendedor;
import Subsistemas.Vendedor.FachadaVendedor;
import Subsistemas.Vendedor.ImplFachadaVendedor;

import java.util.List;

/**
 * el controlador de Vendedor se encarga de llamar a las funciones de la fachada de la vista
 * para ser llamada por la logica del programa
 */

public class VendedorController {

    private Vendedor v;
    private FachadaVendedor fachadaVendedor;

    /**
     * en la constructora vacia se insertan valores por defecto al atributo pedido de la clase
     * e inicia el atributo FachadaVendedor con ImplFachadaVendedor()
     */

    public VendedorController(){
        this.v = new Vendedor();
        fachadaVendedor = new ImplFachadaVendedor();
    }

    /**
     * en la constructora con parametros asignamos los valores al atributo del Vendedor
     */

    public VendedorController(Integer id, String nombre, String email, Long telefono, List<Articulo> Articulos, String password){
        this.v = new Vendedor(id,nombre,email,telefono,Articulos, password);
    }

    /**
     * @return devuelve el Pedido de la clase para que otras clases lo puedan usar
     */

    public Vendedor getVendedor(){return this.v;}

    /**
     * @param v es el Vendedor a insertar en la base de datos
     * @return devuelve el booleano de la logica del programa que indica el exito de la operacion
     */

    public boolean altaVendedor(Vendedor v){return fachadaVendedor.altaVendedor(v);}

    /**
     * @param v es el Vendedor a modificar en la base de datos
     * @return devuelve el booleano de la logica del programa que indica el exito de la operacion
     */

    public boolean modificarVendedor(Vendedor v){return fachadaVendedor.modificarVendedor(v);}

    /**
     * @param id es el identificador del Vendedor a eliminar en la base de datos
     * @return devuelve el booleano de la logica del programa que indica el exito de la operacion
     */

    public boolean bajaVendedor(Integer id){return fachadaVendedor.bajaVendedor(id);}

    /**
     * @param nombre es el nombre o el semejante del archivo o de los archivos a buscar en la base de datos
     * @return devuelve el Vendedor resultante del nombre puesto en la barra de busqueda
     */

    public List<Vendedor> buscarVendedor(String nombre){return fachadaVendedor.buscarVendedor(nombre);}

    /**
     * @return devuelve el vendedor resultante del nombre
     */

    public List<Vendedor> fullTable(){return fachadaVendedor.buscarVendedor("");}

    /**
     * @param username es el identificador del archivo a consultar en la base de datos
     * @return devuelve el Vendedor con el mismo id que el del parametro
     */

    public Vendedor consultarVendedor(String username){return fachadaVendedor.consultarVendedor(username);}

}
