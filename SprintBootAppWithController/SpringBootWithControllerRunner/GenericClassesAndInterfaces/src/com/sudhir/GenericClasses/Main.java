package com.sudhir.GenericClasses;

public class Main {

	public static void main(String[] args) {
		GenericStack<String>  s1 = new GenericStack<>();
		s1.push("aaa");
		s1.push("4");
		System.out.println(s1.peek());
		System.out.println(s1.pop());
		System.out.println(s1.isEmpty());
		System.out.println(s1.peek());
	}
}
