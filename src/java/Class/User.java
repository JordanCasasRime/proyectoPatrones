package Class;

import Interfaces.IClone;

public class User implements IClone  {

    private String email;
    private String password;
    private int personId;

    public User() {
    }

    public User(String email, String password, int personId) {
        this.email = email;
        this.password = password;
        this.personId = personId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int userId) {
        this.personId = userId;
    }

    @Override
    public IClone clone() {
        IClone headquarters = new User(this.email, this.password, this.personId);
        return headquarters;
    }

}
