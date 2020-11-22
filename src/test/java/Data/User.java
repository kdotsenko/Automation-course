package Data;

public class User {
    private String userLogin;
    private String userPassword;
    private String userFirstName;
    private String userLastName;

    public User(String userLogin, String userPassword, String userFirstName, String userLastName){

        this.userLogin=userLogin;
        this.userPassword=userPassword;
        this.userFirstName=userFirstName;
        this.userLastName=userLastName;

    }

    public void setUserLogin(String userLogin){
        this.userLogin=userLogin;
    }

    public void setUserPassword(String userPassword){
        this.userPassword=userPassword;
    }

    public void setUserFirstName(String userFirstName){
        this.userFirstName=userFirstName;
    }

    public void setUserLastName(String userLastName){
        this.userLastName=userLastName;
    }

    public String getUserLogin(){
        return userLogin;
    }

    public String getUserPassword(){
        return userPassword;
    }

    public String getUserFirstName(){
        return userFirstName;
    }

    public String getUserLastName(){
        return userLastName;
    }


}
