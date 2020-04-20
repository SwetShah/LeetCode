package com.leet.problems;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import com.leet.support.ListNode;

public class AddTwoNumbers {
	
	List<ListNode> linkedList = new ArrayList<ListNode>();
	static{
		
		
	}
	
	public void getResult(){
		
		ListNode listNode2_1 = new ListNode(1);
		ListNode listNode4_1 = new ListNode(8);
		listNode2_1.next = listNode4_1;
		
		ListNode listNode5_2 = new ListNode(0);

		addTwoNumbers(listNode2_1, listNode5_2);
		
		
	}
	public ListNode addTwoNumbers(ListNode l1, ListNode l2){
		StringBuilder l1String = new StringBuilder();
		StringBuilder l2String = new StringBuilder();
		do{
			if(l1 != null){
				l1String.append(l1.val);
				l1 = l1.next;
			}
			if(l2 != null){
				l2String.append(l2.val);
				l2 = l2.next;
			}
		}
		while(l1!= null || l2!=null);
		BigInteger value1 = new BigInteger(l1String.reverse().toString());
		BigInteger value2 = new BigInteger(l2String.reverse().toString());
		BigInteger sum = value1.add(value2);
		StringBuilder response =  new StringBuilder(sum+"");
		ListNode [] nodes = new ListNode[response.length()];
		for(int i=response.length()-1; i>=0; i--){
			ListNode listNode = new ListNode(Integer.parseInt(response.charAt(i)+""));
			nodes[i] = listNode;
			listNode = null;
		}
		for(int i=nodes.length-2; i>=0; i--){
			nodes[i+1].next = nodes[i];
		}
		return nodes[nodes.length-1];
	}
}
