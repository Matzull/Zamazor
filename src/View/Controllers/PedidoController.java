package View.Controllers;

import ModeloDominio.Articulo;
import ModeloDominio.Pedido;
import Subsistemas.Pedido.FachadaPedido;
import Subsistemas.Pedido.ImplFachadaPedido;

import java.util.List;

/**
 * el controlador de Pedido se encarga de llamar a las funciones de la fachada de la vista
 * para ser llamada por la logica del programa
 */

public class PedidoController {

    private Pedido p;
    private FachadaPedido fachadaPedido;

    /**
     * en la constructora vacia se insertan valores por defecto al atributo pedido de la clase
     * e inicia el atributo FachadaPedido con ImplFachadaPedido()
     */

    public PedidoController(){
        this.p = new Pedido();
        fachadaPedido = new ImplFachadaPedido();
    }

    /**
     * en la constructora con parametros asignamos los valores al atributo del Pedido
     */

    public PedidoController(Integer id, Integer comprador_id, Integer vendedor_id, String direccion, Boolean entregado, String entrega, String pedido, List<Articulo> articulos){
        this.p = new Pedido(id, vendedor_id, comprador_id, direccion, entregado, entrega, pedido, articulos);
    }

    /**
     * @return devuelve el Pedido de la clase para que otras clases lo puedan usar
     */

    public Pedido getPedido(){return this.p;}

    /**
     * @param p es el Pedido a insertar en la base de datos
     * @return devuelve el booleano de la logica del programa que indica el exito de la operacion
     */

    public boolean altaPedido(Pedido p){return fachadaPedido.altaPedido(p);}

    /**
     * @param p es el Pedido a modificar en la base de datos
     * @return devuelve el booleano de la logica del programa que indica el exito de la operacion
     */

    public boolean modificarPedido(Pedido p){return fachadaPedido.modificarPedido(p);}

    /**
     * @param id es el identificador del Pedido a eliminar en la base de datos
     * @return devuelve el booleano de la logica del programa que indica el exito de la operacion
     */

    public boolean bajaPedido(Integer id){return fachadaPedido.bajaPedido(id);}

    /**
     * @param nombre es el nombre o el semejante del archivo o de los archivos a buscar en la base de datos
     * @return devuelve toda la lista de Pedidos resultante del nombre puesto en la barra de busqueda
     */

    public List<Pedido> buscarPedido(String nombre){return fachadaPedido.buscarPedido(nombre);}

    /**
     * @return devuelve toda la lista de pedidos resultante del nombre del vendedor
     */

    public List<Pedido> fullTable(){return fachadaPedido.buscarPedido("");}

    /**
     * @param id es el identificador del archivo a consultar en la base de datos
     * @param mode es el identificador del modo a consultar en la base de datos
     * @return devuelve el Pedido con el mismo id que el del parametro
     */

    public Pedido consultarPedido(int id, boolean mode){return fachadaPedido.consultarPedido(id, mode);}

    /**
     * @return devuelve toda la lista de pedidos resultante del nombre del vendedor y de su lista de articulos
     */

    public List<Articulo> fullTableP() {
    	return p.getArticulos();
    }
}
