package com.sudhir.scope;

public class Main {

	public static void main(String[] args) {
		
		ScopeCheck sc = new ScopeCheck();
		//System.out.println(sc.getPrivateVar());
		sc.timesTwo();
		
		System.out.println("*******************************");
		
		ScopeCheck.InnerClass innerClass = sc.new InnerClass();
		
		innerClass.printVal();
	}
}
