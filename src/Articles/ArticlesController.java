package Articles;

public class ArticlesController {

    private Articles a;

    public ArticlesController(){
        this.a = new Articles();
    }

    public ArticlesController(Integer id, Integer rating, Integer sellerId, String name, String description,
                              String department, Boolean stock){
        this.a = new Articles(id, rating, sellerId, name, description, department, stock);
    }

    public void addObserver(ArticlesObserver o){
        a.addObserver(o);
    }

    public void removeObserver(ArticlesObserver o){
        a.removeObserver(o);
    }
}
