package com.wipro.assign;

public class Generics<T,U>{
	
	private T first;
	private U second;

	public Generics(T first, U second) {
		super();
		this.first = first;
		this.second = second;
	}

	public T getFirst() {
		return first;
	}

	public U getSecond() {
		return second;
	}

	public Generics<U,T> reverse(){
		return new Generics<>(second,first);
	}

	@Override
	public String toString() {
		return "Generics [first=" + first + ", second=" + second + "]";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Generics<Integer,String> generics= new Generics<>(10,"Deepika");
		System.out.println("Original Pair: "+generics);
		
		Generics<String, Integer> reversedPair= generics.reverse();
		System.out.println("Reversed Pair: "+reversedPair);

	}

}
