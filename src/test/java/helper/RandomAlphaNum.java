package helper;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomAlphaNum {
	
	public String randomNumber() {
		 
	    int length = 3;
	    boolean useLetters = false;
	    boolean useNumbers = true;
	    String generatedNumber = RandomStringUtils.random(length, useLetters, useNumbers);  
	    return(generatedNumber);
	}
	
	public String randomString() {
		 
	    int length = 3;
	    boolean useLetters = false;
	    boolean useNumbers = true;
	    String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);

	    return(generatedString);
	}

}
