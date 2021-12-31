package assignment1;

public class Info {
    String userName;
    int mobileNumber;
    String Email;
    String Password;

    public Info() {
        userName = "";
        mobileNumber = 0;
        Email = "";
        Password = "";
    }

    public Info(String name, int phone, String email, String Pass) {
        userName = name;
        mobileNumber = phone;
        Email = email;
        Password = Pass;
    }

    public void setUserName(String name) {
        userName = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setMobileNumber(int phone) {
        mobileNumber = phone;
    }

    public int getMobileNumber() {
        return mobileNumber;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getEmail() {
        return Email;
    }

    public void setPassword(String Pass) {
        Password = Pass;
    }

    public String getPassword() {
        return Password;
    }
}