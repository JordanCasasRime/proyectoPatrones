package Class;

public class User {

    private Person datoPersonales;
    private String phone;
    private String email;
    private String password;

    public Person getDatoPersonales() {
        return datoPersonales;
    }

    public void setDatoPersonales(Person datoPersonales) {
        this.datoPersonales = datoPersonales;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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
    
}
