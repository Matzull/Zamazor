package Articles;

import java.util.ArrayList;

public class SAArticle {  //Servicio de aplicacion

    public boolean createArticle(Articles a) {
        boolean exist;
        boolean resolution = false;
        //exist = DAO.existArticle(a.getId()); -> Conectarse con el DAO para comprobar si existe o no
        //if(!exist) resolution = DAO.createArticle(a); -> Guarda el objeto en la BDD
        return resolution;
    }

    public boolean modifyArticle(Articles a) {
        boolean exist;
        boolean resolution = false;
        //exist = FachadaDAO.existArticle(a.getId()); -> Conectarse con el DAO para comprobar si existe o no
        //if(exist) resolution = FachadaDAO.modifyArticle(a); -> Modifica el objeto en la BDD
        return resolution;
    }

    public boolean deleteArticle(Articles a) {
        boolean exist;
        boolean resolution = false;
        //exist = FachadaDAO.existArticle(a.getId()); -> Conectarse con el DAO para comprobar si existe o no
        //if(exist) resolution = FachadaDAO.deleteArticle(a); -> Modifica el objeto en la BDD
        return resolution;
    }

    public ArrayList<Articles> seekArticles(String name) {
        ArrayList<Articles> aux = new ArrayList<Articles>();
        // aux = FachadaDAO.seekArticles(name); -> Recibe de la BDD la lista buscada, en caso de no existir sera una lista vacia
        return aux;
    }

    public Articles searchArticle(int id) {
        //Articles aux = searchArticle(); -> Recibe de la BDD el objeto buscado, en caso de no exitir sera NULL
        return null;                            //Retornara aux
    }


}
