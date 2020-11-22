package Data;



import java.util.*;

import static Data.GoodFactory.testGood;
import static Data.GoodFactory.testGood1;



public class TestChallengeDataCollections {


    public ArrayList initArray() {
        ArrayList<Object> dataList = new ArrayList();
        dataList.add("name");
        dataList.add("$%^%$");
        dataList.add("w");
        dataList.add("");
        dataList.add("qwertyuiopasdfghjklzxcvbnmqwer");
        dataList.add("qwertyuiopasdfghjklzxcvbnmqweri");
        dataList.add("<html></html>");
        dataList.add("тест");
        dataList.add("kate test");
        return dataList;
    }


    public String getData(int dataIndex) {
        Data.TestClass.TestDataValue = initArray().get(dataIndex);
        return String.valueOf(Data.TestClass.TestDataValue);
    }

    public Integer amountOfElements() {
        TestClass.arraySize = initArray().size();
        return TestClass.arraySize;
    }

    public ArrayList userData(User user) {
        ArrayList<Object> userList = new ArrayList();
        userList.add(user.getUserLogin());
        userList.add(user.getUserPassword());
        userList.add(user.getUserFirstName());
        userList.add(user.getUserLastName());
        return userList;
    }

    public String getUsersData(User user, int dataIndex) {
        Data.TestClass.TestUserDataValue = userData(user).get(dataIndex);
        return String.valueOf(Data.TestClass.TestUserDataValue);
    }

    public Integer amountOfUserData(User user) {
        TestClass.userDataAmount = userData(user).size();
        return TestClass.userDataAmount;
    }

    public ArrayList goods(Good good) {
        ArrayList<Good> goodList = new ArrayList();
        goodList.add(testGood());
        goodList.add(testGood1());
        return goodList;
    }

    public Good getGoodsData(Good good, int dataIndex) {
        return (Good) goods(good).get(dataIndex);
    }

    public Integer amountOfGoods(Good good) {
        TestClass.goodAmount = goods(good).size();
        return TestClass.goodAmount;
    }


}














































