package DAO;

import Class.Headquarters;
import DataBase.MongoDB;
import Interfaces.IConnection;
import Interfaces.IHeadquartersDAO;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import java.util.ArrayList;

public class HeadquartersDAO implements IConnection, IHeadquartersDAO {
    
    private IConnection connection;
    private static MongoDB mongodb;
    private static DBCollection collection;
    private static HeadquartersDAO dao;
    
    public void setConexion(IConnection conexion) {
        this.connection = conexion;
    }

    public synchronized static HeadquartersDAO getInstance () {
        if (dao == null){
            dao = new HeadquartersDAO();
            connection();
        }
        return dao;
    }
    
    private static void connection() {
        mongodb = MongoDB.getInstance();
        collection = mongodb.getDatabase().getCollection("sedes");
    }

    @Override
    public void disconnection() {
        mongodb.disconnection();
    }

    @Override
    public void create(Headquarters headquarters) {
        Headquarters newHeadquarters = (Headquarters) headquarters.clone();
        BasicDBObject sedeU = (BasicDBObject) collection.find().sort(new BasicDBObject("sedeId", -1)).limit(1).next();
        int idU = 1;
        if (sedeU != null) {
            if (sedeU.get("sedeId") != null) {
                idU = (int) sedeU.get("sedeId") + 1;
            }
        }
        BasicDBObject documento = new BasicDBObject("nombre", newHeadquarters.getName()).append("sedeId", idU).append("direccion", newHeadquarters.getAddress()).append("aforo", newHeadquarters.getCapacity());
        collection.insert(documento);
    }

    @Override
    public ArrayList<Headquarters> readAll() {
        DBCursor sedes = collection.find();
        ArrayList<Headquarters> sedesA = new ArrayList<Headquarters>();
        sedes.forEach((sede) -> {
            Headquarters h = new Headquarters((String) sede.get("nombre"), (String) sede.get("direccion"), (int) sede.get("aforo"), (int) sede.get("sedeId"));
            sedesA.add(h);
        });
        return sedesA;
    }

    @Override
    public Headquarters readID(int id) {
        BasicDBObject sede = (BasicDBObject) collection.findOne(new BasicDBObject("sedeId", id));
        int idU = 1;
        if (sede != null) {
            return new Headquarters((String) sede.get("nombre"), (String) sede.get("direccion"), (int) sede.get("aforo"), (int) sede.get("sedeId"));
        }
        return null;
    }

    @Override
    public void update(Headquarters headq) {
        collection.update(new BasicDBObject().append("sedeId", headq.getHeadquartersId()),
        new BasicDBObject("$set", new BasicDBObject("nombre", headq.getName()).append("direccion", headq.getAddress()).append("aforo", headq.getCapacity())));
    }

    @Override
    public void delete(int id) {
        collection.remove(new BasicDBObject().append("sedeId", id));
    }
    
}
