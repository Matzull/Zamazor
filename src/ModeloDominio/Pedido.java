package ModeloDominio;

public class Pedido {

    private Integer id;
    private Integer comprador_id;
    private Integer repartidor_id;
    private String dirEntrega;
    private boolean entregado;

    public Pedido() {
        id = 0;
        comprador_id = 0;
        repartidor_id = 0;
        dirEntrega = "";
        entregado = false;
    }

    public Pedido(Integer id, Integer comprador_id, Integer repartidor_id, String dirEntrega, boolean entregado) {
        this.id = id;
        this.comprador_id = comprador_id;
        this.repartidor_id = repartidor_id;
        this.dirEntrega = dirEntrega;
        this.entregado = entregado;
    }

    //region Getters y setters
    public Integer getId() { return id;}

    public void setId(Integer id) { this.id = id;}

    public Integer getComprador_id() { return comprador_id;}

    public void setComprador_id(Integer comprador_id) { this.comprador_id = comprador_id;}

    public Integer getRepartidor_id() { return repartidor_id;}

    public void setRepartidor_id(Integer repartidor_id) { this.repartidor_id = repartidor_id;}

    public String getDirEntrega() { return dirEntrega;}

    public void setDirEntrega(String dirEntrega) { this.dirEntrega = dirEntrega;}

    public boolean isEntregado() { return entregado;}

    public void setEntregado(boolean entregado) { this.entregado = entregado;}

    //endregion
}
