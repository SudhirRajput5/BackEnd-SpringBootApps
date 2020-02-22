package com.AnonymousInnerClasses;

public class AnonymousInnerClassbyImplementingInterface {

	public static void main(String[] args) {
		
		Runnable r = new Runnable() {
			
			public void run() {
				System.out.println("child thread");
			}
		};
		Thread t = new Thread(r);
		t.start();
		System.out.println("Parent thread");
	}
}
