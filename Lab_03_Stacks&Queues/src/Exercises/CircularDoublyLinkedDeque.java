package Exercises;

import Ex9_Deque.Deque;

public class CircularDoublyLinkedDeque<E> implements Deque<E> {

	private class Node {
		private E value;
		private Node next, prev;

		public Node(E value, Node next, Node prev) {
			this.value = value;
			this.next = next;
			this.prev = prev;
		}

		public Node(E value) {
			this(value, null, null); // Delegate to other constructor
		}

		public Node() {
			this(null, null, null); // Delegate to other constructor
		}

		public E getValue() {
			return value;
		}

		public void setValue(E value) {
			this.value = value;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}

		public Node getPrev() {
			return prev;
		}

		public void setPrev(Node prev) {
			this.prev = prev;
		}

		public void clear() {
			value = null;
			next = prev = null;
		}				
	} // End of Node class

	int currentSize;
	Node header;

	public CircularDoublyLinkedDeque() {	
		currentSize = 0;
		header = new Node(null, header, header);

	}

	@Override
	public int size() {
		return currentSize;
	}

	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

	@Override
	public void clear() {
		while(!isEmpty()) {
			removeFirst();
		}
	}

	@Override
	public E getFirst() {
		return header.getNext().getValue();
	}

	@Override
	public E getLast() {
		return header.getNext().getValue();
	}

	@Override
	public void addFirst(E element) throws IllegalArgumentException {

		if(element.equals(null))
			throw new IllegalArgumentException("Parameter cannot be null");

		Node newNode = new Node(element);

		if(isEmpty()) {
			header.setNext(newNode);
			header.setPrev(newNode);
			newNode.setPrev(header);
			newNode.setNext(header);
			currentSize++;

		}
		else {

			header.getNext().setPrev(newNode);
			Node temp = header.getNext();

			header.setNext(newNode);
			newNode.setNext(temp);
			newNode.setPrev(header);
			currentSize++;


		}


	}

	@Override
	public void addLast(E element) throws IllegalArgumentException {
		if(element.equals(null))
			throw new IllegalArgumentException("Parameter cannot be null");

		Node newNode = new Node(element);

		if(isEmpty()) {
			header.setNext(newNode);
			header.setPrev(newNode);
			newNode.setPrev(header);
			newNode.setNext(header);
			currentSize++;
		}
		else {
			header.getPrev().setNext(newNode);
			Node temp = header.getPrev();

			header.setPrev(newNode);
			newNode.setPrev(temp);
			newNode.setNext(header);
			currentSize++;


		}
	}

	@Override
	public E removeFirst() {
		Node rmNode;

		if(isEmpty())
			return null;

		rmNode = header.getNext();		
		header.setNext(header.getNext().getNext());
		header.getNext().clear();

		currentSize--;

		
		return rmNode.getValue();
	}

	@Override
	public E removeLast() {
		Node rmNode;

		if(isEmpty())
			return null;

		rmNode = header.getPrev();		
		header.setPrev(header.getPrev().getPrev());
		header.getPrev().clear();

		currentSize--;
		
		return rmNode.getValue();
	}

	@Override
	public E[] toArray() {
		if(this.isEmpty())
			throw new ArrayIndexOutOfBoundsException("The current queue is empty");

		E[] theArray = (E[]) new Object[size()];

		int i = 0;

		if(this.size() == 1) {
			theArray[0] = header.getNext().getValue();
			return theArray;
		}
		
		//Left most element is the rear of the line, right most element is the front
		for (Node curNode = header.getNext(); !curNode.equals(header); curNode = curNode.getNext()) {
			theArray[i++] = curNode.getValue();
		}
		

		return theArray;
	}
	
//	public static void main(String[] args) {
//		CircularDoublyLinkedDeque<Object> newCQ = new CircularDoublyLinkedDeque<Object>();
//		
//		newCQ.addFirst(2);
//		newCQ.addFirst(4);
//		newCQ.addFirst(6);
//		newCQ.addFirst(8);
//		
//		newCQ.addLast(1);
//		newCQ.addLast(3);
//		newCQ.addLast(5);
//		newCQ.addLast(7);
//		
//		for (Object object : newCQ.toArray()) {
//			System.out.print(object + " , ");
//		}
//
//
//	}

}
