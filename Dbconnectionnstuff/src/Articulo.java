public class Articulo {

    private int id;
    private String nombre;
    private int precio;
    private Boolean stock;
    private String descripcion;
    private static int valoracion;
    private String tipo;
    private int vendedor_id;

    public Articulo() {

    }

    public String getNombre() {
        return nombre;
    }

    public Boolean getStock() {
        return stock;
    }

    public int getPrecio(){
        return precio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public static int getValoracion() {
        return valoracion;
    }

    public static void setValoracion(int valoracion) {
        Articulo.valoracion = valoracion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getVendedor_id() {
        return vendedor_id;
    }

    public void setVendedor_id(int vendedor_id) {
        this.vendedor_id = vendedor_id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setStock(Boolean stock) {
        this.stock = stock;
    }
}
