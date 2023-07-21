package com.blogPost.controller;

public class Demo {
	
	public static void main(String[] args) {
		String s1 = "I am prem gupta";
		String[] strArray = s1.split(" ");
		String s2 = "";
		for(int i=0;i<strArray.length;i++) {
			String temp = strArray[i];
			for(int j=temp.length()-1;j>=0;j--) {
				s2 = s2 + temp.charAt(j);	
				}
			s2 = s2 + " ";
		}
		
		System.out.println(s2);
		System.out.println("hello");
	}

}
