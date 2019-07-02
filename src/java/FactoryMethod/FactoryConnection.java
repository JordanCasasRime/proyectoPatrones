package FactoryMethod;

import DAO.HeadquartersDAO;
import DAO.PersonDAO;
import DAO.PublicationDAO;
import DAO.UserDAO;
import Interfaces.CRUD;

public class FactoryConnection {
    
    public CRUD getConnection (String connection) {
        switch (connection) {
            case "Headquarters" : return HeadquartersDAO.getInstance();
            case "Person" : return PersonDAO.getInstance();
            case "Publication" : return PublicationDAO.getInstance();
            case "User" : return UserDAO.getInstance();
        }
        return null;
    }
    
}
