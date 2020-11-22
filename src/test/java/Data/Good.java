package Data;

public class Good {
    private String goodName;
    private String goodDescription;
    private String startDate;
    private String endDate;

    public Good(String goodName, String goodDescription, String startDate, String endDate){

        this.goodName=goodName;
        this.goodDescription=goodDescription;
        this.startDate=startDate;
        this.endDate=endDate;

    }

    public void setGoodName(String goodName){
        this.goodName=goodName;
    }

    public void setGoodDescription(String goodDescription){
        this.goodDescription=goodDescription;
    }

    public void setStartDate(String startDate){
        this.startDate=startDate;
    }

    public void setEndDate(String endDate){
        this.endDate=endDate;
    }

    public String getGoodName(){
        return goodName;
    }

    public String getGoodDescription(){
        return goodDescription;
    }

    public String getStartDate(){
        return startDate;
    }

    public String getEndDate(){
        return endDate;
    }
}
