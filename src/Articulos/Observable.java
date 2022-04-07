package Articulos;

public interface Observable<T> {        //Interfaz necesaria para el patron observer. MVC

    //Metodos obligatorios para el patron observer -> MVC
    public void addObserver(T o);
    public void removeObserver(T o);

}
