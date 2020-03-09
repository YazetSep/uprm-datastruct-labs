package Exercises;

import java.util.Scanner;

import Ex8_Stack.src.ciic4020.stack.ArrayStack;
import Ex8_Stack.src.ciic4020.stack.Stack;
import Ex9_Queue.src.ciic4020.queue.DoublyLinkedQueue;
import Ex9_Queue.src.ciic4020.queue.Queue;

public class Palindromes {
	
	public static String isPalindrome() {
		//Creates a new scanner type object
		Scanner sc = new Scanner(System.in);
		
		//Uses the scanner to read user input
		String input = sc.nextLine();
		
		//Skips spaces
		String spaceSkip = input.replaceAll("[\\W]", "");
		
		//Creates a new Stack to store the read values
		Stack<String> newStack = new ArrayStack<String>(10);
		
		//Creates a new DoublyLinkedQueue
		Queue<String> newQueue = new DoublyLinkedQueue<String>();
		
		//iterates through user input and pushes it in the stack
		for(char c: spaceSkip.toCharArray()) {
			newStack.push(String.valueOf(c).toLowerCase());
		}
		
		//iterates through user inputs and enqueues it in the queue and at the same time checks if it's values is the same as the stack's pop
		for(char c: spaceSkip.toCharArray()){
			newQueue.enqueue(String.valueOf(c).toLowerCase());
			if(!newQueue.dequeue().equals(newStack.pop()) && !newStack.isEmpty())
				return "is Not a Palindrome";
				
		}
		
		return "Palindrome";
	}
	
	public static void main(String[] args) {
		System.out.println(isPalindrome());
	}
	
	
}
