package domain;

public class User {
    private  String username;
    private  String password;
    private   int  phoneNum;
    private  String email;

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", phoneNum=" + phoneNum +
                ", email='" + email + '\'' +
                '}';
    }

    public User(String username, String password, int phoneNum, String email) {
        this.username = username;
        this.password = password;
        this.phoneNum = phoneNum;
        this.email = email;
    }

    public String getUsername() {

        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(int phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
