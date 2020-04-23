package com.leet.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.leet.problem.names.CodeNames;
import com.leet.problems.AddTwoNumbers;
import com.leet.problems.LongestSubstringWithoutRepeatingCharacters;
import com.leet.problems.TwoSum;

public class MainClass {

	static Map<Integer, CodeNames> executionMap = new HashMap<Integer, CodeNames>();

	static {
		executionMap.put(1, CodeNames.TwoSum);
		executionMap.put(2, CodeNames.AddTwoNumbers);
		executionMap.put(3, CodeNames.LongestSubstringWithoutRepeatingCharacters);
	}

	public static void main(String[] args) {

		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("Enter Program number to execute");
			int problemToExecute = scanner.nextInt();
			CodeNames problemName = executionMap.get(problemToExecute);

			switch (problemName) {
			case TwoSum:
			{
				int[] result = TwoSum.class.newInstance().getResult();
				System.out.println(result);
				break;
			}
			
			case AddTwoNumbers:
			{
				AddTwoNumbers.class.newInstance().getResult();
				break;
			}
			
			case LongestSubstringWithoutRepeatingCharacters:
			{
				int result = LongestSubstringWithoutRepeatingCharacters.class.newInstance().getResult();
				System.out.println(result);
				break;
			}
			default : 
				System.out.println("No Such Problem exists");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
