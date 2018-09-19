import java.util.Random;
public class Engine {

	private int numDigits;
	private int [] secretNumber;
	private Random randomNumberGenerator = new Random();

	
	public int [] convertNumToDigitArray(String number){

		
		 int numDigits = number.length();
		    int[] convertNumToDigitArray = new int[numDigits];
		    for(int i = 0; i <= numDigits; i++)
		    {
		        convertNumToDigitArray[i] =  number.charAt(i) - '0';
		    }
		    return convertNumToDigitArray;
		}
		  
		    
		 
	
	 public int getNumDigits(){
	    	return this.numDigits;
	}
	 
	 public int[] getSecretNumber(){
		 return this.secretNumber;
	 }
	 
	 public void generateNewSecret(){
		 int number = randomNumberGenerator.nextInt(((int)Math.pow(10, numDigits) - ((int)Math.pow(10, numDigits-1)))) + ((int)Math.pow(10, numDigits-1));
	     int numberB = numDigits;
	     for (int i = 0; i < numDigits; i++)
	        {
	             
	            secretNumber[i] = (int)((number/(Math.pow(10, numberB-1))));   
	            if (number<10)
	                break;
	            number = number%((int)(Math.pow(10, numberB-1)));
	             
	            numberB--;
	            
	        }
	            
		
	 }
	 
	 public void setNumDigits(int numDigits){
		 this.numDigits = numDigits;
		 secretNumber = new int[numDigits];
	 }
	 
	 public void setSecretNumber(int[] secretNumber){
		 
		 this.secretNumber = secretNumber;
		 
	 }
}
