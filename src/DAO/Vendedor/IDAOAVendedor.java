package DAO.Vendedor;

import ModeloDominio.Vendedor;

import java.util.List;
/**
 * Esta es la interfaz de la clase DAOvendedor que se encarga de recopilar
 * los datos de la tabla Vendedores de la base de datos y conectarlos con la logica del programa
 */
public interface IDAOAVendedor {
     /**
      * @param v este parametro es el vendedor seleccionado por el cliente
      * @return llama a la funcion altaVendedor del DAO y devuelve el booleano
      *          de confirmacion de exito de la operacion
      */
     boolean altaVendedor(Vendedor v);
     /**
      * @param id este parametro es el id del vendedor seleccionado por el cliente
      * @return llama a la funcion bajaVendedor del DAO y devuelve el booleano
      *      de confirmacion de exito de la operacion
      */
     boolean bajaVendedor(int id);
     /**
      * @param v este parametro es el vendedor seleccionado por el cliente
      * @return llama a la funcion modificarVendedor del DAO y devuelve el booleano
      *      de confirmacion de exito de la operacion
      */
     boolean modificarVendedor(Vendedor v);
     /**
      * @param nombre este parametro es el nombre aproximado del vendedor escrito por el cliente
      * @return llama a la funcion buscarVendedor del DAO y devuelve la lista de vendedores a
      *          mostrar
      */
     List<Vendedor> buscarVendedor(String nombre);
     /**
      * @param username este parametro es el nombre de usuario del vendedor seleccionado por el cliente
      * @return llama a la funcion consultarVendedor del DAO y devuelve el vendedor a mostrar
      */
     Vendedor consultarVendedor(String username);
}
