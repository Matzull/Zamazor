package ModeloDominio;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Comprador {
    private Integer id;
    private String nombre;
    private String email;
    private String cuenta;
    private String direccion;
    private List<Pedido> pedidos;
    private String password;

    //Constructor vacio para valores por defecto
    public Comprador(){
        id = 0;
        nombre = "";
        email = "";
        direccion = "";
        pedidos = new ArrayList<Pedido>();
        password = "";
    }

    //Contructor con parametros. Lo mas seguro que se use este para coger los valores de la BBDD
    public Comprador(Integer id, String nombre, String email, String cuenta, String direccion, List<Pedido> pedidos, String password){
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.cuenta = cuenta;
        this.direccion = direccion;
        this.pedidos = pedidos;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String toString()
    {
        return "Funciono, nombre: " + this.nombre;
    }

}