package com.sudhir.SrpingWithControllerJPA.shared;

import java.security.SecureRandom;
import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class Utils {
	
	private final Random RANDOM = new SecureRandom();
	private final String ALPHABET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	
	public String generateUserId(int length) {
		return generateRandomString(length);
	}
	
	private String generateRandomString(int length) {
		StringBuilder returnVal = new StringBuilder();
		
		for(int i= 0;i<length;i++) {
			returnVal.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));
		}
	return new String(returnVal);
	}

}
