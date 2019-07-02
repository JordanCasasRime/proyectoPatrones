
import Class.Headquarters;
import Class.Publication;
import DAO.HeadquartersDAO;
import DAO.PersonDAO;
import DAO.PublicationDAO;
import DataBase.MongoDB;
import Interfaces.CRUD;
import Interfaces.IConnection;
import com.mongodb.DB;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Prueba {

    public static void main(String[] args) {
        
//        MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb+srv://jordan:cursogg@panamericano-cjqv8.mongodb.net/test?retryWrites=true&w=majority"));
//        MongoDB mongo = MongoDB.getInstance();
//        mongoClient = mongo.getMongoClient();
//        List<String> databases = mongoClient.getDatabaseNames();
//        for (String dbName : databases) {
//            System.out.println("- Database: " + dbName);
//            
//            DB db = mongoClient.getDB(dbName);
//            
//            Set<String> collections = db.getCollectionNames();
//            for (String colName : collections) {
//                System.out.println("\t + Collection: " + colName);
//            }
//        }
//        
//        mongoClient.close();
//         
//
//       
//                MongoDB aux1 = MongoDB.getInstance();
//                MongoDB aux2 = MongoDB.getInstance();
//                MongoDB aux3 = MongoDB.getInstance();
//                System.out.println(aux1.hashCode());
//                System.out.println(aux2.hashCode());
//                System.out.println(aux3.hashCode());
//                
        
//        HeadquartersDAO conexion = HeadquartersDAO.getInstance();
////        HeadquartersDAO conexion2 = HeadquartersDAO.getInstance();
////        HeadquartersDAO conexion3 = HeadquartersDAO.getInstance();
////        
////        System.out.println(conexion.hashCode());
////        System.out.println(conexion2.hashCode());
////        System.out.println(conexion3.hashCode());
//
//
//        ArrayList<Headquarters> sees = conexion.readAll();
//        sees.forEach((sede) -> {
//             System.out.println(sede.getName());
//        });
//        conexion.disconnection();


//            ConexionMongo conexion = new ConexionMongo();
//            System.out.println("conectado");
//            ArrayList<Sede> sedes =conexion.obtenerSedes();
//            System.out.println("Pasando array");
//            conexion.cerrarConexion();
//            System.out.println("Cerrando");
        
//        Headquarters h = new Headquarters("nombre", "direccion", 20, 1);
//        Headquarters h2 = (Headquarters) h.clone();
//        
//        if (h2 != null)
//            System.out.println("se clono");
//        System.out.println(h2 == h);

        System.out.println("Hola");
        CRUD h =  HeadquartersDAO.getInstance();
        
        System.out.println("Intenciando");
        
        ArrayList<Headquarters> sees = h.readAll();
        sees.forEach((sede) -> {
             System.out.println(sede.getName());
             System.out.println(sede.getAddress());
             System.out.println(sede.getCapacity());
             System.out.println(sede.getHeadquartersId());
        });

    }

}
