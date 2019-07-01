package DataBase;

import Interfaces.IConnection;
import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

public class MongoDB implements IConnection {

    private static MongoDB databaseMongo;
    private static MongoClient instance;
    private DB database;

    private synchronized static MongoDB Singleton() {
        if (databaseMongo == null) {
            databaseMongo = new MongoDB();
            databaseMongo.setInstance(new MongoClient(new MongoClientURI("mongodb+srv://jordan:cursogg@panamericano-cjqv8.mongodb.net/test?retryWrites=true&w=majority")));
            databaseMongo.setDatabase(databaseMongo.getMongoClient().getDB("Panamericano"));
        }
        return databaseMongo;
    }

    public static MongoDB getInstance() {
        return Singleton();
    }

    public MongoClient getMongoClient () {
        return instance;
    }
    
    private void setInstance (MongoClient instance) {
        this.instance = instance;
    }

    public DB getDatabase() {
        return database;
    }

    public void setDatabase(DB database) {
        this.database = database;
    }
    
    @Override
    public void connection() {
        //instance.startSession();
    }

    @Override
    public void disconnection() {
        instance.close();
    }
    
}
