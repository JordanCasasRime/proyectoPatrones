package TemplateMethod;

import Class.Person;
import DAO.PersonDAO;

public class AccessUser extends AccessPlataform {

    @Override
    public boolean showPage() {
        if (authenticate()) {
            PersonDAO personDao = PersonDAO.getInstance();
            super.setPerson(personDao.readID(super.getUser().getPersonId()));
            if (super.getPerson().getUserType().equals("normal"));
            return true;
        }
        return false;
    }
    
}
