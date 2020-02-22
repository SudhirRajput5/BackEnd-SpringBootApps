package cts.sudhir;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Unit1Exercise {

	 	public static void main(String[] args) {
			
	 		List<Person> people = Arrays.asList(
	 		new Person("Charles", "Dickens", 60),
	 		new Person("Lewis","Carroll", 42),
	 		new Person("Thomas", "Carlele", 51),
	 		new Person("Charlotte","Bronte",45),
	 		new Person("Matthew", "Arnold", 39)
	 		);
	 		
	 		
	 		//Sort list by last name	
	 		Collections.sort(people, new Comparator<Person>() {

				@Override
				public int compare(Person p1, Person p2) {
					return p1.getLastName().compareTo(p2.getLastName());
				}});
	 		
	 		System.out.println("Print all Person" + people);
	 		printlastNameWithC(people);
		}

		private static void printlastNameWithC(List<Person> people) {

			for(Person p:people) {
				if(p.getLastName().startsWith("C"))
				System.out.println(p);
			}
			
		}
}
