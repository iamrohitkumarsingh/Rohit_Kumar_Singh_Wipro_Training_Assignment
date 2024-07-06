package com.wipro.assign;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PersonSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Person> person=new ArrayList<>();
		person.add(new Person("Deepika",23));
		person.add(new Person("Priyanka",25));
		person.add(new Person("Rukmini",50));
		person.add(new Person("Manjunath",55));
		person.add(new Person("Aishwarya",23));
		
		person.sort(Comparator.comparingInt(Person::getAge));
		
		person.forEach(System.out::println);
	}

}
