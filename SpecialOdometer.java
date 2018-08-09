import java.awt.List;
import java.util.ArrayList;

public class SpecialOdometer {

	
     int numOfDigits;
     ArrayList<Integer> arrli = new ArrayList<Integer>();
     public Odometer(int numOfDigits){
    	  this.numOfDigits=numOfDigits;
    	 
     }
     
     public int nextNum ( int num)
     {
    	  int index= arrli.indexOf(num);
    	  if(index+1 > arrli.size())
    	  {
    		  index=(index+1)%arrli.size();
    		  return arrli.get(index);
    	  }
    	  else
        return arrli.get(index+1);
    	  
     }
     
     public int incrementN(int n, int num){
     
    	 
    int index=arrli.indexOf(num);
    if((index + n)>arrli.size())
    {
    	index=index%(arrli.size());
    	   return arrli.get(index);
    }
    else
     return arrli.get(index+n);
    
 
    	 
     }
     
     public int prevNum(int num){
    	 
    	 int index= arrli.indexOf(num);
    	
    	 if(index-1<0)
   	  return arrli.get(arrli.size()-1);
    	 else
    		 return arrli.get(index-1);
    	 
    	 
     }
     
     
     public int decrementN(int n, int num){
    	 int k=0;
    	 
    	    int index=arrli.indexOf(num);
    	    if((index - n)<arrli.size())
    	    {
    	    	k= arrli.size()-n+index;
    	    	
    	    	
    	    }
    	    
    	    return arrli.get(k);
    	 
    	 
     }
     
     
     public int difference(int num1, int num2)
     {
    	 
    	 
     }
     
     
	

}
