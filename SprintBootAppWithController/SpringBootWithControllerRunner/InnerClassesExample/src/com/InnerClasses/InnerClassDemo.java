package com.InnerClasses;

public class InnerClassDemo {
	
	public static void main(String[] args) {
		
		OuterClass outClassObj = new OuterClass();
		
		OuterClass.InnerClass innerObj = outClassObj.new InnerClass();
		
		innerObj.display();
	}

}
