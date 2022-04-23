package ModeloDominio;

import java.util.ArrayList;
import java.util.List;

public class Vendedor {

    private Integer id;
    private String nombre;
    private String email;
    private Long telefono;
    private List<Vendedor> listaVendedores;

    public Vendedor() {
        id = 0;
        nombre = "";
        email = "";
        telefono = Long.valueOf(0);
        listaVendedores = new ArrayList<Vendedor>();
    }

    public Vendedor(Integer id, String nombre, String email, Long telefono, List<Vendedor> listaVendedores) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.listaVendedores = listaVendedores;
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

    public List<Vendedor> getListaVendedores() {
        return listaVendedores;
    }

    public void setListaVendedores(List<Vendedor> listaVendedores) {
        this.listaVendedores = listaVendedores;
    }


    //endregion
}
