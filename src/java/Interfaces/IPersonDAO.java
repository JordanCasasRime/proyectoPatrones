package Interfaces;

import Class.Person;

public interface IPersonDAO extends CRUD<Person> {
    
    void mostrarNombre();
    void setConnection(IConnection conexion);
    
}
