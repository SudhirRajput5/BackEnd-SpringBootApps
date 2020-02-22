package com.AnonymousInnerClasses;

public class InnerClassInsideMethod {

	public static void main(String[] args) {
		
		Thread t = new Thread(new Runnable () {
			public void run() {
				System.out.println("child thread");
			}
		});
		t.start();
		System.out.println("Main thread");
	}
}
