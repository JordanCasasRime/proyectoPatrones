//Patron de Plantilla

package TemplateMethod;

import Class.Person;
import Class.User;
import DAO.UserDAO;

public abstract class AccessPlataform {
    
    private User user;
    private int userId;
    private UserDAO userDao;
    private String userType;
    private Person person;
    
    public void gatherInformation(String username, String password) {
        setUser(new User());
        getUser().setEmail(username);
        getUser().setPassword(password);
        setUserDao(getUserDao().getInstance());
    }
    
    public boolean authenticate() {
        User user = getUserDao().readEmail(getUser().getEmail());
        if (user != null){
            if(user.equals(getUser().getPassword())) {
                setUser(user);
                return true;
            }
            return false;
        }
        return false;
    }
    
    public abstract boolean showPage();

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserDAO getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDAO userType) {
        this.userDao = userType;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
    
}
