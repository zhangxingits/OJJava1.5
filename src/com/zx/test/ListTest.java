package com.zx.test;

import java.util.ArrayList;
import java.util.List;

public class ListTest {
	public static void main(String args[]){
		List<List<String>> strList=new ArrayList<List<String>>();
		List<String> strings1=new ArrayList<String>();
		List<String> strings2=new ArrayList<String>();
		List<String> strings3=new ArrayList<String>();
		List<String> strings4=new ArrayList<String>();
		strings1.add("String11");
		strings1.add("String12");
		strings2.add("String21");
		strings2.add("String22");
		strings2.add("String23");
		strings3.add("String31");
		strings4.add("String41");
		strings4.add("String42");
		strList.add(strings1);
		strList.add(strings2);
		strList.add(strings3);
		strList.add(strings4);
		for (List<String> string : strList) {
			for (String string2 : string) {
				System.out.print(string2+" ");
			}
			System.out.println();
		}
	}
}
