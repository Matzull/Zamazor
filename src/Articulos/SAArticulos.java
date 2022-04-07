package Articulos;

import java.util.ArrayList;

public class SAArticulos {  //Servicio de aplicacion

    public boolean altaArticulo(Articulos a) {
        boolean exist;
        boolean resolution = false;
        //exist = DAO.existArticle(a.getId()); -> Conectarse con el DAO para comprobar si existe o no
        //if(!exist) resolution = DAO.createArticle(a); -> Guarda el objeto en la BDD
        return resolution;
    }

    public boolean modificarArticulo(Articulos a) {
        boolean exist;
        boolean resolution = false;
        //exist = FachadaDAO.existArticle(a.getId()); -> Conectarse con el DAO para comprobar si existe o no
        //if(exist) resolution = FachadaDAO.modifyArticle(a); -> Modifica el objeto en la BDD
        return resolution;
    }

    public boolean bajaArticulo(Articulos a) {
        boolean exist;
        boolean resolution = false;
        //exist = FachadaDAO.existArticle(a.getId()); -> Conectarse con el DAO para comprobar si existe o no
        //if(exist) resolution = FachadaDAO.deleteArticle(a); -> Modifica el objeto en la BDD
        return resolution;
    }

    public ArrayList<Articulos> buscarArticulo(String nombre) {
        ArrayList<Articulos> aux = new ArrayList<Articulos>();
        // aux = FachadaDAO.seekArticles(name); -> Recibe de la BDD la lista buscada, en caso de no existir sera una lista vacia
        return aux;
    }

    public Articulos consultarArticulo(int id) {
        //Articles aux = searchArticle(); -> Recibe de la BDD el objeto buscado, en caso de no exitir sera NULL
        return null;                            //Retornara aux
    }


}
