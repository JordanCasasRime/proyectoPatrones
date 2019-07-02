package DAO;

import Class.User;
import DataBase.MongoDB;
import Interfaces.IConnection;
import Interfaces.IUserDAO;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import java.util.ArrayList;

public class UserDAO implements IConnection, IUserDAO {
    
    private IConnection connection;
    private static MongoDB mongodb;
    private static DBCollection collection; 
    private static UserDAO dao;
    
    public void setConexion(IConnection conexion) {
        this.connection = conexion;
    }

    public synchronized static UserDAO getInstance () {
        if (dao == null){
            dao = new UserDAO();
            connection();
        }
        return dao;
    }
    
    private static void connection() {
        mongodb = MongoDB.getInstance();
        collection = mongodb.getDatabase().getCollection("usuarios");
    }

    @Override
    public void disconnection() {
        mongodb.disconnection();
    }

    @Override
    public void create(User user) {
        User newUser = (User) user.clone();
        BasicDBObject userU = (BasicDBObject) collection.find().sort(new BasicDBObject("personaId", -1)).limit(1).next();
        int idU = 1;
        if (userU != null) {
            if (userU.get("personaId") != null) {
                idU = (int) userU.get("personaId") + 1;
            }
        }
        BasicDBObject documento = new BasicDBObject("correo", newUser.getEmail()).append("personaId", idU).append("contrasenia", newUser.getPassword());
        collection.insert(documento);
    }

    @Override
    public ArrayList<User> readAll() {
        DBCursor usuarios = collection.find();
        ArrayList<User> ususarioA = new ArrayList<User>();
        usuarios.forEach((usuario) -> {
            ususarioA.add(new User((String) usuario.get("correo"), (String) usuario.get("contrasenia"), (int) usuario.get("personaId")));
        });
        return ususarioA;
    }

    @Override
    public User readID(int id) {
        BasicDBObject user = (BasicDBObject) collection.findOne(new BasicDBObject("personaId", id));
        int idU = 1;
        if (user != null) {
            return new User((String) user.get("correo"), (String) user.get("contrasenia"), (int) user.get("personaId"));
        }
        return null;
    }
    
    @Override
    public User readEmail(String email){
        BasicDBObject user = (BasicDBObject) collection.findOne(new BasicDBObject("correo", email));
        if (user != null) {
            return new User((String) user.get("correo"), (String) user.get("contrasenia"), (int) user.get("personaId"));
        }
        return null;
    }

    @Override
    public void update(User user) {
        collection.update(new BasicDBObject().append("personaId", user.getPersonId()),
        new BasicDBObject("$set", new BasicDBObject("correo", user.getEmail()).append("contrasenia", user.getPassword())));
    }

    @Override
    public void delete(int id) {
        collection.remove(new BasicDBObject().append("personaId", id));
    }
    
}
