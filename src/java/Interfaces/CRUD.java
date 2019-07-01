package Interfaces;

import java.util.ArrayList;

public interface CRUD<AClass> {

    void create(AClass t);
    ArrayList<AClass> readAll();
    AClass readID (int id);
    void update(AClass t);
    void delete(int id);
}
