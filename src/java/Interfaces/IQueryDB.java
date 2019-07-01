package Interfaces;

import Class.Publication;
import Class.User;

public interface IQueryDB {
    
    public void listPublish();
    public void publicationSearch(String publication);
    public void createPublication(Publication publication);
    public void uploadCommet(Publication publication);
    public void commetHistory (User user);
    
}
