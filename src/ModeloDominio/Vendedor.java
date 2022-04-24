package ModeloDominio;

import java.util.ArrayList;
import java.util.List;

public class Vendedor {

    private Integer id;
    private String nombre;
    private String email;
    private Long telefono;
    private List<Articulo> Articulos;

    public Vendedor() {
        id = 0;
        nombre = "";
        email = "";
        telefono = Long.valueOf(0);
        Articulos = new ArrayList<Articulo>();
    }

    public Vendedor(Integer id, String nombre, String email, Long telefono, List<Articulo> Articulos) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.Articulos = Articulos;
    }

    //region Getters y setters

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

    public void setArticulos(List<Articulo> Articulo) {
        this.Articulos = Articulos;
    }
    //endregion

    public String toString()
    {
        return "Funciono, nombre: " + this.nombre;
    }
}
