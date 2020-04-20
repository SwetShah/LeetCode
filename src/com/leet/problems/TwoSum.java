package com.leet.problems;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TwoSum {

	static Map<String,Object> input = new HashMap<String, Object>();
	
	static {
		System.out.println("===========================================================================================");
		System.out.println("Executing "+TwoSum.class.getSimpleName()+" problem");
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("Enter the size of array");
			int size = scanner.nextInt();
			int[] elements = new int[size];
			System.out.println("Enter the elements of array");
			for (int i = 0; i < size; i++) {
				elements[i] = scanner.nextInt();
			}
			System.out.println("Enter the target");
			int target = scanner.nextInt();
			
			input.put("inputArray", elements);
			input.put("target", target);
		} catch (Exception e) {
			throw e;
		}
		
	}
	public static int[] getResult() {
		
		int[] inputArray = (int[]) input.get("inputArray");
		int target = (int) input.get("target");
		
		int[] response = getSum(inputArray, target);
		return response;
	}

	private static int[] getSum(int[] inputArray, int target) {
		
		Map<Integer, Integer> searchMap = new HashMap<Integer, Integer>(); 
		int[] response = new int[2];
		for(int i=0; i<inputArray.length; i++){
			int complement = target - inputArray[i];
			if(searchMap.containsKey(complement) && searchMap.get(complement)!= i){
				response[0] = i;
				response[1] = searchMap.get(complement);
				break;
			}
			searchMap.put(inputArray[i], i);
		}
		return response;
	}
}
