package ModeloDominio;

public class Comprador {
    private Integer id;
    private String nombre;
    private String email;
    private String puntoDeEntrega;
    private String cuenta;

    //Constructor vacio para valores por defecto
    public Comprador(){
        id = 0;
        nombre = "";
        email = "";
        puntoDeEntrega = "";
        cuenta = "";
    }

    //Contructor con parametros. Lo mas seguro que se use este para coger los valores de la BBDD
    public Comprador(Integer id, String name, String nombre, String email, String puntoDeEntrega){
        this.id = id;
        this.nombre = name;
        this.email = email;
        this.puntoDeEntrega = puntoDeEntrega;
    }

    //region Getters y setters
    public Integer getId() { return id;}

    public String getNombre() { return nombre;}

    public void setId(Integer id) {
        this.id = id;
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

    public String getPuntoDeEntrega() {
        return puntoDeEntrega;
    }

    public void setPuntoDeEntrega(String puntoDeEntrega) {
        this.puntoDeEntrega = puntoDeEntrega;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }
    //endregion
}