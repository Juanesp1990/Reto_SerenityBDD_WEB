package co.com.sofka.models.automationpractice;

public class Register {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String address;
    private String city;
    private String codePostal;
    private String mobilePhone;

    public String getFirstName () {
        return firstName;
    }

    public void setFirstName (String firstName) {
        this.firstName = firstName;
    }

    public String getLastName () {
        return lastName;
    }

    public void setLastName (String lastName) {
        this.lastName = lastName;
    }

    public String getEmail () {
        return email;
    }

    public void setEmail (String email) {
        this.email = email;
    }

    public String getPassword () {
        return password;
    }

    public void setPassword (String password) {
        this.password = password;
    }

    public String getAddress () {
        return address;
    }

    public void setAddress (String address) {
        this.address = address;
    }

    public String getCity () {
        return city;
    }

    public void setCity (String city) {
        this.city = city;
    }

    public String getCodePostal () {
        return codePostal;
    }

    public void setCodePostal (String codePostal) {
        this.codePostal = codePostal;
    }

    public String getMobilePhone () {
        return mobilePhone;
    }

    public void setMobilePhone (String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }
}
