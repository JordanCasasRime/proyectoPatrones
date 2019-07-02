package DAO;

import Class.Publication;
import DataBase.MongoDB;
import Interfaces.IConnection;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import java.util.ArrayList;
import Interfaces.IPublicationDAO;

public class PublicationDAO implements IPublicationDAO {

    public static PublicationDAO getInstance() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private IConnection connection;
    private MongoDB mongodb;
    private DBCollection collection;

    public PublicationDAO() {
        connection();
    }

    public void setConexion(IConnection conexion) {
        this.connection = conexion;
    }

    public void connection() {
        mongodb = MongoDB.getInstance();
        collection = mongodb.getDatabase().getCollection("publicaciones");
    }

    public void disconnection() {
        mongodb.disconnection();
    }

    @Override
    public void create(Publication publication) {
        BasicDBObject publicacionU = (BasicDBObject) collection.find().sort(new BasicDBObject("publicacionId", -1)).limit(1).next();
        int idU = 1;
        if (publicacionU != null) {
            if (publicacionU.get("publicacionId") != null) {
                idU = (int) publicacionU.get("publicacionId") + 1;
            }
        }
        BasicDBObject documento = new BasicDBObject("titulo", publication.getTitle()).append("publicacionId", idU).append("descripcion", publication.getDescription()).append("fecha", publication.getDate()).append("categoria", publication.getCategoria());
        collection.insert(documento);
    }

    @Override
    public ArrayList<Publication> readAll() {
        DBCursor publicaciones = collection.find();
        ArrayList<Publication> publicacionA = new ArrayList<Publication>();
        publicaciones.forEach((publicacion) -> {
            publicacionA.add(new Publication((String) publicacion.get("titulo"), (String) publicacion.get("descripcion"), (String) publicacion.get("fecha"), (String) publicacion.get("categoria"), (int) publicacion.get("publicacionId")));
        });
        return publicacionA;
    }

    @Override
    public Publication readID(int id) {
        BasicDBObject publicacion = (BasicDBObject) collection.findOne(new BasicDBObject("publicacionId", id));
        int idU = 1;
        if (publicacion != null) {
            return new Publication((String) publicacion.get("titulo"), (String) publicacion.get("descripcion"), (String) publicacion.get("fecha"), (String) publicacion.get("categoria"), (int) publicacion.getInt("publicacionId"));
        }
        return null;
    }

    @Override
    public void update(Publication publicacion) {
        collection.update(new BasicDBObject().append("publicacionId", publicacion.getPublicationId()),
        new BasicDBObject("$set", new BasicDBObject("titulo", publicacion.getTitle()).append("descripcion", publicacion.getDescription()).append("fecha", publicacion.getDate()).append("categoria", publicacion.getCategoria())));
    }

    @Override
    public void delete(int id) {
        collection.remove(new BasicDBObject().append("publicacionId", id));
    }

}
