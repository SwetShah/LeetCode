package com.leet.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MedianOfTwoSortedArrays {

	static Map<String,Object> input = new HashMap<String,Object>();
	
	static{
		System.out.println("===========================================================================================");
		System.out.println("Executing "+MedianOfTwoSortedArrays.class.getSimpleName()+" problem");
		try (Scanner scanner = new Scanner(System.in)) {
			
			System.out.println("Enter the size of 1st array");
			int size1 = scanner.nextInt();
			System.out.println("Enter the elements of 1st array");
			int[] array1 = new int[size1];
			for (int i = 0; i < size1; i++) {
				array1[i] = scanner.nextInt();
			}
			
			System.out.println("Enter the size of 2nd array");
			int size2 = scanner.nextInt();
			System.out.println("Enter the elements of 2nd array");
			int[] array2 = new int[size2];
			for (int i = 0; i < size2; i++) {
				array2[i] = scanner.nextInt();
			}
			
			input.put("Array1", array1);
			input.put("Array2", array2);
			
		} catch (Exception e) {
			throw e;
		}
	}
	
	public static double getResult() {
		
		int[] nums1 = (int[]) input.get("Array1");
		int[] nums2 = (int[]) input.get("Array2");
		return findMedianSortedArrays(nums1, nums2);
	}
	
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		
		int size1 = nums1.length;
		int size2 = nums2.length;
		int finalSize = (size1 + size2)/2 + 1;
		int result[] = new int[finalSize];
		
		int i=0, j=0, res = 0;
		while(res < finalSize){
			int element1 = Integer.MIN_VALUE;
			int element2 = Integer.MIN_VALUE;
			
			if(size1!=0 && i!=size1){
				element1 = nums1[i];
			}
			if(size2!=0 && j!=size2){
				element2 = nums2[j];
			}
			if(element1 < element2 && element1!= Integer.MIN_VALUE){
				result[res] = element1;
				i++;
				res++;
			}
			else if(element1>element2 && element2!=Integer.MIN_VALUE){
				result[res] = element2;
				j++;
				res++;
			}
			else{
				if(element1 != Integer.MIN_VALUE && element2!=Integer.MIN_VALUE){
					result[res] = element1;
					i++;
				}
				else if(element1!= Integer.MIN_VALUE){
					result[res] = element1;
					i++;
				}
				else if(element2!= Integer.MIN_VALUE){
					result[res] = element2;
					j++;
				}
				res++;
			}
		}
		double answer;
		// If total size is odd then return the last element of resultant array
		if((size1+size2)%2!=0){
			answer = result[finalSize-1]; // Last elements of final Array
		}else{
			answer = (result[finalSize-1] + result[finalSize-2])/2d; //Average of last 2 elements
		}
		return answer;
	}
}
