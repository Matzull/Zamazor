package ModeloDominio;

import javax.swing.*;

public class Comprador {
    private Integer id;
    private String nombre;
    private String email;
    private String direccion;

    //Constructor vacio para valores por defecto
    public Comprador(){
        id = 0;
        nombre = "";
        email = "";
        direccion = "";
    }

    //Contructor con parametros. Lo mas seguro que se use este para coger los valores de la BBDD
    public Comprador(Integer id, String name, String nombre, String email, String direccion){
        this.id = id;
        this.nombre = name;
        this.email = email;
        this.direccion = direccion;
    }

    //Agrupa varias funciones en IntelliJ, para eclipse hace falta un plug in
    //region Getters y setters
    public Integer getId() {
        return id;
    }

    public String getNombre() { return nombre;}

}