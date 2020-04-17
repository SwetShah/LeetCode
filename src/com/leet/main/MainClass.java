package com.leet.main;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.leet.problem.names.CodeNames;
import com.leet.problems.TwoSum;

public class MainClass {

	static Map<Integer, CodeNames> executionMap = new HashMap<Integer, CodeNames>();

	static {
		executionMap.put(1, CodeNames.TwoSum);
	}

	public static void main(String[] args) {

		try (Scanner scanner = new Scanner(System.in)) {
			int problemToExecute = scanner.nextInt();
			CodeNames problemName = executionMap.get(problemToExecute);

			switch (problemName) {
			case TwoSum:
				int[] result = TwoSum.class.newInstance().getResult();
				System.out.println(result);
				break;
				
			default : 
				System.out.println("No Such Problem exists");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
