package Data;

public class UserFactory {

    public static User testUser(){
       String userLogin=Utils.userTestData.userLogin;
       String userPassword=Utils.userTestData.userPassword;
        String userFirstName=Utils.userTestData.userFirstName;
        String userLastName=Utils.userTestData.userLastName;

        User user = new User(userLogin,userPassword,userFirstName,userLastName);
        return user;
    }


}
