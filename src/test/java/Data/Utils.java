package Data;

import Pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.security.SecureRandom;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import static java.time.LocalDate.now;

public class Utils {

    public static class goodsData{
public static LocalTime theStartTime;
      public static String generateRandomTimer(){
        return String.valueOf(dateGen());
      }

      public static LocalTime dateGen(){

          Random generator =new Random();
          theStartTime=LocalTime.MIN.plusSeconds(generator.nextLong());
          return theStartTime;
      }

     public static LocalTime endDate(){
         Random generator =new Random();
         LocalTime endTime= LocalTime.MIN.plusSeconds(generator.nextLong());
         return endTime;
     }


      public static String finalEndDate() {

          LocalTime endTestTime = endDate();

          if (endTestTime.isBefore(theStartTime)) {

              do {
                  Random generator1 = new Random();
               LocalTime   NewEndTime = LocalTime.MIN.plusSeconds(generator1.nextLong());
                 endTestTime=NewEndTime;

              }
              while (endTestTime.isBefore(theStartTime));
          }

          return String.valueOf(endTestTime);
      }

        static final String AB = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        public static String generateRandomStringTest(int length){

            StringBuilder sb = new StringBuilder();
            for( int i = 0; i < length; i++ )
                sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
            return sb.toString();

        }

        static SecureRandom rnd = new SecureRandom();
        static final String time="1234567890";
        public static String generateRandomNumbersOnly(int length){
            StringBuilder sb = new StringBuilder();
            for( int i = 0; i < length; i++ )
                sb.append( time.charAt( rnd.nextInt(time.length()) ) );
            return sb.toString();
        }
        public static Integer generateRandomNumber(int length){
            Random r = new Random();
            int c = (int)(r.nextInt(length) + 'a');
            return c;

        }

        public static Object possibleUserLoginOrPassword(){
            Object userLoginGenerated= generateRandomStringTest(5)+generateRandomNumber(4);
            return userLoginGenerated;
        }

        public static String goodName= (String) possibleUserLoginOrPassword();
        public static  String goodDescription=(String) possibleUserLoginOrPassword();
        public static  String startDate=generateRandomTimer();
        public static String endDate=finalEndDate();
        public static String goodName1= (String) possibleUserLoginOrPassword();
        public static  String goodDescription1=(String) possibleUserLoginOrPassword();
        public static  String startDate1=generateRandomTimer();
        public static String endDate1=finalEndDate();

    }


    public static class userTestData{

        public static Integer generateRandomNumber(int length){
            Random r = new Random();
            int c = (int)(r.nextInt(length) + 'a');
           return c;

        }


        static final String AB = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        static SecureRandom rnd = new SecureRandom();
        static final String time="1234567890";
        public static String generateRandomStringTest(int length){

            StringBuilder sb = new StringBuilder();
            for( int i = 0; i < length; i++ )
                sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
            return sb.toString();

        }

        public static Object possibleUserLoginOrPassword(){
            Object userLoginGenerated= generateRandomStringTest(5)+generateRandomNumber(4);
            return userLoginGenerated;
        }

        public static String possibleUserNames(){
            String userName= generateRandomStringTest(7);
            return userName;
        }

        static String userLogin= (String) possibleUserLoginOrPassword();
        static  String userPassword=(String) possibleUserLoginOrPassword();
        static  String userFirstName=possibleUserNames();
        static String userLastName=possibleUserNames();


    }





    public static class randomCPN{


        static SecureRandom rnd = new SecureRandom();
        static final String firstNumberOptions="123456789";

        public static String generateRandomFirstNumber(int length){

            StringBuilder sb = new StringBuilder();
            for( int i = 0; i < length; i++ )
                sb.append( firstNumberOptions.charAt( rnd.nextInt(firstNumberOptions.length()) ) );
                return sb.toString();
        }


        public static Integer generateRandomThirdNumber(){
            int third=1 + (int) (Math.random() * 52);
            return third;
        }

        public static String finalThird(){
            Integer finalThird =generateRandomThirdNumber();
            String stringOfFinalThird=String.valueOf(finalThird);
            if (finalThird<10){
                String newFinalThird="0"+stringOfFinalThird;
                stringOfFinalThird=newFinalThird;
            }
            return stringOfFinalThird;
        }

        public static Integer generateRandomForthNumber(){
            int forth= 1 + (int) (Math.random() * 999);
            return forth;
        }

        public static String finalFourth(){
            Integer finalFourth =generateRandomForthNumber();
            String stringOfFinalFourth=String.valueOf(finalFourth);
            if (finalFourth<100){
                String newFinalFourthLess100="0"+stringOfFinalFourth;
                stringOfFinalFourth=newFinalFourthLess100;
            }
            if (finalFourth<10){
                String newFinalFourthLess10="00"+stringOfFinalFourth;
                stringOfFinalFourth=newFinalFourthLess10;
            }
            return stringOfFinalFourth;
        }

    public static LocalDate randomDate(int stYear, int stMonth, int stDay, int endYear, int endMonth, int endDay){
        LocalDate startDate= LocalDate.of(stYear, stMonth, stDay);
        long start = startDate.toEpochDay();
        LocalDate endDate= LocalDate.of(endYear, endMonth, endDay);
        long end = endDate.toEpochDay();
        long randomDate = ThreadLocalRandom.current().nextLong(start, end);
       return LocalDate.ofEpochDay(randomDate);
    }

    public static LocalDate finalRandomDate() {
            LocalDate finalRandomDate=randomDate(1900, 01, 01, 1999, 12, 31);
        String firstNumberString = firstNumber;
        int firstNumber = Integer.parseInt(firstNumberString);
        LocalDate currentDate= now();
        int currentYear=currentDate.getYear();
        int currentMonth=currentDate.getMonthValue();
        int currentDay=currentDate.getDayOfMonth();

        if (firstNumber==1 || firstNumber==2 ) {
            finalRandomDate=  randomDate(1900, 01, 01, 1999, 12, 31);
        } else if (firstNumber==3 || firstNumber==4){
            finalRandomDate=randomDate(1800, 01, 01, 1899, 12, 31);
        }else if (firstNumber==5 || firstNumber==6){
            finalRandomDate=randomDate(2000, 01, 01, currentYear, currentMonth, currentDay );
        }

        return finalRandomDate;


    }


        public static String secondNumberWithRemovedYearStart() {

         String sb=(String.valueOf(finalRandomDate()).substring(2));
           return sb;
        }

        public static String secondNumberFinal(){
            String secondNumberFinal= String.valueOf(secondNumberWithRemovedYearStart()).replace("-", "");
            return secondNumberFinal;
        }


        public static ArrayList<Integer> toMultiplyOn(){
            ArrayList<Integer> intToMultiplyCPNOn= new ArrayList<>();
            intToMultiplyCPNOn.add(2);
            intToMultiplyCPNOn.add(7);
            intToMultiplyCPNOn.add(9);
            intToMultiplyCPNOn.add(1);
            intToMultiplyCPNOn.add(4);
            intToMultiplyCPNOn.add(6);
            intToMultiplyCPNOn.add(3);
            intToMultiplyCPNOn.add(5);
            intToMultiplyCPNOn.add(8);
            intToMultiplyCPNOn.add(2);
            intToMultiplyCPNOn.add(7);
            intToMultiplyCPNOn.add(9);
           // System.out.println("CPN mulptipier: "+intToMultiplyCPNOn);
            return intToMultiplyCPNOn;

        }



        public static ArrayList<Integer> finalNumberArrayToInteger(){

            String[] arrayElements = String.valueOf(CPNcalc).split("");
           ArrayList<Integer> intCPNArrayList= new ArrayList<>();
           int i=0;

           while(i<12){
                   int element= Integer.parseInt(arrayElements[i]);
               intCPNArrayList.add(element);
               i++;
           }
        //    System.out.println("CPN array: "+intCPNArrayList);
           return intCPNArrayList;
        }


        public static Integer getThirteenDigit(){
           int i=0;
           int Sum=0;

           while(i<12){
             int multipResult=  finalNumberArrayToInteger().get(i)*toMultiplyOn().get(i);
             i++;
             //  System.out.println("Mult result: "+multipResult);
               Sum=multipResult+Sum;

           }
           // System.out.println("Mult sum result: "+Sum);

           Integer resultOfThirteen= Sum % 11;
         //   System.out.println("13: "+resultOfThirteen);
           return resultOfThirteen;
        }

        public static String finalThirteenth(){
            int thirteenDidgit=getThirteenDigit();

            if (thirteenDidgit==10){
                thirteenDidgit=1;
            }
            return String.valueOf(thirteenDidgit);
        }


        public static String CPNToCalculate(){
            firstNumber=generateRandomFirstNumber(1);
            String CPNToCalculate=firstNumber+secondNumberFinal()+ finalThird()+ finalFourth();
            CPNcalc=CPNToCalculate;
            return CPNToCalculate;
        }
public static String firstNumber;
        public static String CPN(){
            CPNcalc=CPNToCalculate();
            String CPN=CPNcalc+finalThirteenth();
             System.out.println("cpn is: "+CPN);
             return CPN;
        }
public static String CPNcalc;
    }


}