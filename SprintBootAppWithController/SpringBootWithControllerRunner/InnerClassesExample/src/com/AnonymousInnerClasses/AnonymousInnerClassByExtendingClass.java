package com.AnonymousInnerClasses;

public class AnonymousInnerClassByExtendingClass {
	public static void main(String[] args) {
		
		Thread t = new Thread() {
			public void run() {
				System.out.println("child thread");
			}
		};
		
		t.start();
		System.out.println("main thread");
	}

}
