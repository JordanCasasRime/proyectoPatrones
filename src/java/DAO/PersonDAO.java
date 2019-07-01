package DAO;

import Class.Person;
import Interfaces.IConnection;
import Interfaces.IPersonDAO;
import java.util.ArrayList;

public class PersonDAO implements IPersonDAO {

    private IConnection connection;

    public void setConexion(IConnection conexion) {
        this.connection = conexion;
    }

    public void conectando() {
        System.out.println("Estoy conectado");
    }
   
    @Override
    public void mostrarNombre() {
        // TODO Auto-generated method stub

    }

    @Override
    public void setConnection(IConnection conexion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void create(Person t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Person> readAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Person readID(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Person t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
