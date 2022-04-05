package Articles;

import java.util.ArrayList;

public class ArticleFont implements ArticleFront{           //Implementacion de la fachada del articulo

    private SAArticle sa;

    @Override
    public boolean createArticle(Articles a) {
        return sa.createArticle(a);
    }

    @Override
    public boolean modifyArticle(Articles a) {
        return sa.modifyArticle(a);
    }

    @Override
    public boolean deleteArticle(Articles a) {
        return sa.deleteArticle(a);
    }

    @Override
    public ArrayList<Articles> seekArticles(String name) {
        return sa.seekArticles(name);
    }

    @Override
    public Articles searchArticle(int id) {
        return sa.searchArticle(id);
    }
}
