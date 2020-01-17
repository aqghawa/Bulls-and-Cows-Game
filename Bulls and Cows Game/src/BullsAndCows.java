import java.util.Random;

public class BullsAndCows {
	
	public static boolean contains(int[] list, int num) {
		for(int i =0; i<list.length;i++) {
			if(list[i]==num) {
				return true;
			}
		}	
		return false;
	}
	
	public static int[] generateSecretDigits(int num) {
		Random rand = new Random(num);
		int[] list = new int[4];
		int randInt;
		for(int i = 0; i<4; i++) {
			randInt = rand.nextInt(10);
			while(contains(list,randInt)) {
				randInt = rand.nextInt(10);
			}
			list[i]=randInt;
		}	
		return list;
	}
	
	public static int[] extractDigits(int inputInt){
		    
		   inputInt = Math.abs(inputInt);
		    
		    String inputString = "" + inputInt;
		    int inputStringLength = inputString.length();
		    
		    int lengthOfArray = 0;
		    if(inputStringLength<4){
		      lengthOfArray = 4;
		    } else {
		      lengthOfArray = inputStringLength;
		    }
		    
		    int[] input = new int[lengthOfArray];
		    
		    if(inputStringLength<4){
		      int numberOf0 = 4-inputStringLength;
		      for(int i=0; i<numberOf0; i++){
		        input[i] = 0;
		      }
		      for(int i=0; i<4-numberOf0; i++){
		        String temp = "" + inputString.charAt(i);
		        input[numberOf0+i] = Integer.parseInt(temp);
		      }
		      
		    } else {
		      for(int i=0; i<inputStringLength; i++){
		        String temp = "" + inputString.charAt(i);
		        input[i] = Integer.parseInt(temp);
		      }
		    }
		    return input;
		  }
		  
	public static int getNumOfBulls(int[] secret, int[] input){
	    
	    if(secret.length != input.length){
	      throw new IllegalArgumentException("invalid input, length of input does not match the length of the secret number");
	    }
	    

	    int numberOfBulls = 0;
	    for(int i=0; i<secret.length; i++){
	      if(secret[i]==input[i]){
	        numberOfBulls++;
	      }
	    }
	    return numberOfBulls;
	  }

	public static int getNumOfCows(int[] secret, int[] input){
	    
	    if(secret.length != input.length){
	      throw new IllegalArgumentException("invalid input, length of input does not match the length of the secret number");
	    }
	    
	    int numberOfCows = 0;
	    for(int i=0; i<secret.length; i++){
	      int check = secret[i];
	      if(contains(input,check) && secret[i] != input[i]){
	        numberOfCows++;
	      }
	    }
	    return numberOfCows;
	  }
	
	
	
	public static void main(String[] args) {
		int[] list = extractDigits(1);
		for(int i=0; i<list.length; i++) {
			System.out.println(list[i]);
		}
	}
}
