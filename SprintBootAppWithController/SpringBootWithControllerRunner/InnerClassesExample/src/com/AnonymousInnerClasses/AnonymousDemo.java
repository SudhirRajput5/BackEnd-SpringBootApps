package com.AnonymousInnerClasses;

public class AnonymousDemo {

	public static void main(String[] args) {
		
		Age oj1 = new Age() {
			
			@Override
			public void getAge() {
				System.out.println("Age is " +x);
			}
		};
		
		oj1.getAge();
	}
}
