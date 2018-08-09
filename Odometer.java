import java.util.*;

public class Odometer {

    int numOfDigit;
    List<Integer> allNumb;

    Odometer(int numOfDigit){
        this.numOfDigit = numOfDigit;
    }

    public int nextNum (int num)
    {
        int index= allNumb.indexOf(num);
        index=(index+1)%allNumb.size();
        return allNumb.get(index);

    }

    public int incrementN(int n, int num){


        int index=allNumb.indexOf(num);
        if((index + n) >= allNumb.size())
        {
            index=(index+n)%(allNumb.size());
            return allNumb.get(index);
        }
        else
            return allNumb.get(index+n);
        
    }

    public int prevNum(int num){

        int index= allNumb.indexOf(num);

        if(index-1<0)
            return allNumb.get(allNumb.size()-1);
        else
            return allNumb.get(index-1);
        
    }


    public int decrementN(int n, int num){
        int index=allNumb.indexOf(num);
        int sizeAllNum = allNumb.size();
        if((index - n) < 0)
        {
            return allNumb.get((n-index)%allNumb.size());
        }
        return allNumb.get(index-n);
    }

    public int getDifference(int num1, int num2) {
        
        int index1 = allNumb.indexOf(num1);
        int index2 = allNumb.indexOf(num2);
        int size = allNumb.size();

        if(index1 <= index2 )return index2-index1;
        return (size-index1+index2);

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
//        System.out.print(o.allNumb);
        System.out.println("1 " + o.nextNum(123));
        System.out.println("2 " + o.nextNum(789));
        System.out.println("3 " + o.incrementN(100000, 123));
        System.out.println("4 " + o.incrementN(100000, 789));
        System.out.println("5 " + o.prevNum(123));
        System.out.println("6 " + o.prevNum(789));
        System.out.println("7 " + o.decrementN(100000, 123));
        System.out.println("8 " + o.decrementN(100000,789));
        System.out.println("9 " + o.getDifference(789, 123));
        System.out.println("10 " + o.getDifference(123,789));
    }
}
