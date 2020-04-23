package com.leet.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;


public class LongestSubstringWithoutRepeatingCharacters {
	
	static String input = "";
	static{
		System.out.println("===========================================================================================");
		System.out.println("Executing "+LongestSubstringWithoutRepeatingCharacters.class.getSimpleName()+" problem");
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("Enter the input String:");
			input = scanner.next();
		} catch (Exception e) {
			throw e;
		}
	}

	public int getResult(){
		return lengthOfLongestSubstring(input);
	}
	
	 public int lengthOfLongestSubstring(String inputString) {
		 int max = 0;
	     Map<Character, Integer> map = new HashMap<Character, Integer>();
	     for(int i=0; i<inputString.length(); i++){
	    	 
	    	 if(!map.containsKey(inputString.charAt(i))){
	    		 map.put(inputString.charAt(i), i);
	    	 }
	    	 else{
	    		 max = max >= map.size() ? max : map.size();
	    		 int start = map.get(inputString.charAt(i));
	    		 int end = i;
	    		 Map<Character, Integer> newMap = new HashMap<Character, Integer>();
	    		 for(int j = start+1; j<i; j++){
	    			 newMap.put(inputString.charAt(j), j);
	    		 }
	    		 map = new HashMap<Character, Integer>(newMap);
	    		 map.put(inputString.charAt(i), i);
	    		 
	    	 }
	    	 if(i == inputString.length()-1){
	    		 max = max >= map.size() ? max : map.size();
	    	 }
	     }
		 return max;
	 }
}
