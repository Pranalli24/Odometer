import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

import java.lang.reflect.Array;
import java.util.*;

public class Odometer {

    int numOfDigit;
    List<Integer> allNumb;

    Odometer(int numOfDigit){
        this.numOfDigit = numOfDigit;
    }

    private int generateMinNumber(){

        int temp = 1;

        for (int i=2;i<=numOfDigit;i++){
            temp = temp * 10 + i;
        }
        return temp;

    }

    private int generateMaxNumber(){
        int temp = 0;

        for (int i =numOfDigit; i>0; i--){
            temp = temp * 10 + (10-i);
        }
        return temp;
    }

    private boolean isSorted(int num){

        String numString = String.valueOf(num);

        for (int i=0;i<numString.length()-1;i++){
            if (numString.charAt(i) > numString.charAt(i+1)){
                return false;
            }
        }
        return true;

    }

    private  boolean isRepeated(int num){

        String numString = String.valueOf(num);
        List<String> allCharInNum = Arrays.asList(numString.split(""));

        for (int i=0; i<allCharInNum.size()-1; i++){
            if (allCharInNum.get(i).equals(allCharInNum.get(i+1))){
                return true;
            }
        }
        return false;

    }

    private boolean isValid(int num){

        return isSorted(num) && !isRepeated(num);

    }

    private void generateAllNumbers (){

        allNumb = new ArrayList<>();

        int minNumber = generateMinNumber();
        int maxnumber = generateMaxNumber();
        for (int i = minNumber; i<=maxnumber; i++){
            if (isValid(i)){
                allNumb.add(i);
            }
        }

    }

    public static  void main (String []args){
        Odometer o = new Odometer(3);
        o.generateAllNumbers();
        System.out.print(o.allNumb);
    }
}
