package basics;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class linkedlistexample {
	
	public static void main(String[] args) {
		
		LinkedList<String> list = new LinkedList<>();
		addInOrder(list, "ankit");
		addInOrder(list, "abhin");
		addInOrder(list, "rohit");
		addInOrder(list, "paritosh");
		addInOrder(list, "sudhir");
		addInOrder(list, "ankit");
		
		System.out.println(list);
		visit(list);
		
	}
	
	public static boolean addInOrder(LinkedList<String> lis, String element) {
		ListIterator<String> lisIterator = lis.listIterator();
		
		while(lisIterator.hasNext()) {
			int comparision = 
					lisIterator.next().compareTo(element);
			
			if(comparision == 0) {
				System.out.println("City already present");
				return false;
			}else if(comparision >0) {
				lisIterator.previous();
				lisIterator.add(element);
				return true;
			}else if(comparision < 0) {
				//move to next city
			}
		}
		lis.add(element);
		return true;
	}
	
	public static void visit(LinkedList cities) {
		
		Scanner in = new Scanner(System.in);
		boolean quit = false;
		boolean goingforward = true;
		ListIterator<String> listIterator = cities.listIterator();
		
		if(cities.isEmpty()) {
			System.out.println("No cities in list");
			return;
		}else {
			System.out.println("Now visiting " + listIterator.next());
			printMenu();
		}
		
		while(!quit) {
			int action = in.nextInt();
			in.nextLine();
		switch(action) {	
		case 0:
			System.out.println("Holidays are over");
			quit = true;
			break;
			
		case 1:
			if(!goingforward) {
				if(listIterator.hasNext()) {
					listIterator.next();
				}
				goingforward = true;
			}
			if(listIterator.hasNext()) {
				System.out.println("now visiting" + listIterator.next());
				}else {
					System.out.println("reached end of the list");
				}
			break;
		case 2:
			if(goingforward) {
				if(listIterator.hasPrevious()) {
					listIterator.previous();
				}
				goingforward = false;
			}
			if(listIterator.hasPrevious()) {
				System.out.println("now visiting " + listIterator.previous());
			}else {
				System.out.println("reached begining of the list");
			}
			break;
			
		case 3:
			printMenu();
			break;
			} 
			
		}
		
	}
	
	private static void printMenu() {
		System.out.println("Available actions \n");
		System.out.println("0 - quit");
		System.out.println("1 - next");
		System.out.println("2 - prevous");
	}
}
