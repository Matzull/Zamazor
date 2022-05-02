package ModeloDominio;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Vendedor {
    /**
     * dicho Pedido tiene como atributos un identificador id, un nombre, un email,
     * un telefono, una lista de Articulos y una contraseña.
     */
    private Integer id;
    private String nombre;
    private String email;
    private Long telefono;
    private List<Articulo> Articulos;
    private String password;
    /**
     * este constructor vacio se usa para valores por defecto
     */
    public Vendedor() {
        id = 0;
        nombre = "";
        email = "";
        telefono = Long.valueOf(0);
        Articulos = new ArrayList<Articulo>();
        password = "";
    }
    /**
     * este constructor se usa para coger los valores de la base de datos
     */
    public Vendedor(Integer id, String nombre, String email, Long telefono, List<Articulo> Articulos, String password) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.Articulos = Articulos;
        this.password = password;
    }

    /**
     * creamos todos los getters y los setters de los atributos de la clase
     */

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

    public Long getTelefono() {
        return telefono;
    }

    public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }

    public List<Articulo> getArticulos() {
        return Articulos;
    }

    public void setArticulos(List<Articulo> Articulos) {
        this.Articulos = Articulos;
    }
    //endregion

    public String toString()
    {
        return "Funciono, nombre: " + this.nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
