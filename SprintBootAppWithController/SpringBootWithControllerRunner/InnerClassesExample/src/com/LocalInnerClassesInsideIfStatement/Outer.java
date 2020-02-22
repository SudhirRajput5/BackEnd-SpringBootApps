package com.LocalInnerClassesInsideIfStatement;

public class Outer {

	public int data = 10;
	public int getData() {
		return data;
	}
	
	public static void main(String args [] ) {
		Outer outer = new Outer();
		
		if(outer.getData() < 20) {
			class Inner{
				public int getValue() {
					System.out.println("inside inner class");
					return outer.data;
				}
			}
			
			Inner inner = new Inner();
			System.out.println(inner.getValue());
		}else {
			System.out.println("Inside outer class");
		}
	} 
}
