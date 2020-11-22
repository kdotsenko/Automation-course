package Data;

import static Data.Utils.goodsData.possibleUserLoginOrPassword;

public class GoodFactory {

    public static Good testGood(){

        String goodName=Utils.goodsData.goodName;
        String goodDescription=Utils.goodsData.goodDescription;
        String startDate=Utils.goodsData.startDate;
        String endDate=Utils.goodsData.endDate;

        Good good=new Good(goodName, goodDescription, startDate,endDate);
                return good;
    }

    public static Good testGood1(){

        String goodName1=Utils.goodsData.goodName1;
        String goodDescription1=Utils.goodsData.goodDescription1;
        String startDate1=Utils.goodsData.startDate1;
        String endDate1=Utils.goodsData.endDate1;

        Good good1=new Good( goodName1, goodDescription1, startDate1,endDate1);
        return good1;
    }
}
