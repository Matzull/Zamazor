package Articles;

import java.util.ArrayList;
import java.util.List;

public class Articles implements Observable<ArticlesObserver>{
    //Quiza estaria bien que todos los objetos hereden de uno general, solo son = 2 atributos asi que igual no es muy interesante
    //Atributos de articulos, puse los nombres en ingles porque siempre nos dicen que hagamos eso pero se pueden cambiar
    private Integer id;             //
    private String name;            //
    private Boolean stock;          //
    private String description;     // Quiza tb seria mejor static, pero mismo problema que en el rating
    private static Integer rating;  // No todos los articulos son iguales, asi que el static seria mejor de objetos que hereden de este
    private String department;      //
    private Integer sellerId;       //Company, enterprise si preferis
    private List<ArticlesObserver> observers;   //Lista de observadores para el MVC

    //Constructor vacio para valores por defecto
    public Articles(){
        id = 0;
        name = "";
        stock = false;
        description = "";
        rating = 0;
        department = "";
        sellerId = 0;
        this.observers = new ArrayList<ArticlesObserver>();
    }

    //Contructor con parametros. Lo mas seguro que se use este para coger los valores de la BBDD
    public Articles(Integer id, Integer rating, Integer sellerId, String name, String description,
                    String department, Boolean stock){
        this.id = id;
        this.name = name;
        this.stock = stock;
        this.description = description;
        this.rating = rating;
        this.department = department;
        this.sellerId = sellerId;
        this.observers = new ArrayList<ArticlesObserver>();
    }

    //Agrupa varias funciones en IntelliJ, para eclipse hace falta un plug in
    //region Getters y setters
    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Boolean getStock() {
        return stock;
    }

    public String getDescription() {
        return description;
    }

    public static Integer getRating() {
        return rating;
    }

    public String getDepartment() {
        return department;
    }

    public Integer getSellerId() {
        return sellerId;
    }

    public void setId(Integer id) {     //Al ser atributo unico seria realmente necesario el setter?
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStock(Boolean stock) {
        this.stock = stock;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static void setRating(Integer rating) {
        Articles.rating = rating;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setSellerId(Integer sellerId) {
        this.sellerId = sellerId;
    }
    //endregion

    public void addObserver(ArticlesObserver o) {
        if(!observers.contains(o)) this.observers.add(o);
    }

    public void removeObserver(ArticlesObserver o) {
        if(observers.contains(o)) this.observers.remove(o);
    }
}
