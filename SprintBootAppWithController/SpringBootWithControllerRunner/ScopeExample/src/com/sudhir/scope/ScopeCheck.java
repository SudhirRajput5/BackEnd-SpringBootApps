package com.sudhir.scope;

public class ScopeCheck {
	public int publicVar =0;
	private int varOne =1 ;
	
	public ScopeCheck() {
		System.out.println("ScopeCheck created, publicVar = " + publicVar + " privateVar = " + varOne);
	}

	public int getPrivateVar() {
		return varOne;
	}


	public void timesTwo() {
		int privateVar = 2;
		System.out.println(this.varOne);
	}
	
	public class InnerClass{
		public int privateVar = 3;
		
		
		public void printVal() {
			System.out.println(ScopeCheck.this.varOne);
		}
	}
}
