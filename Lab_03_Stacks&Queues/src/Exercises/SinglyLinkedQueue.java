package Exercises;

import Ex9_Queue.src.ciic4020.queue.Queue;

public class SinglyLinkedQueue<E> implements Queue<E> {

	private class Node {

		private E value;
		private Node next;

		public Node(E value, Node next) {
			this.value = value;
			this.next = next;
		}

		public Node(E value) {
			this(value, null); // Delegate to other constructor
		}

		public Node() {
			this(null, null); // Delegate to other constructor
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

		public void clear() {
			value = null;
			next = null;
		}				
	} // End of Node class

	private int currentSize;
	Node head;
	Node tail;

	public SinglyLinkedQueue() {
		currentSize = 0;
		this.tail= new Node(null);
		this.head = new Node(null, tail);

	}

	@Override
	public void enqueue(E e) {
		if (e == null)
			throw new IllegalArgumentException("Parameter cannot be null");

		//Adding elements to the head of Queue
		if(this.isEmpty()) {
			this.tail = new Node(e);
			currentSize++;
		}
		else if(this.size() == 1) {
			this.head = new Node(e, tail);
			currentSize++;
		}
		/*Everytime an element is added, the head changes, in this implementation, the head is the rear of the queue
		 * In other words, the values added will be added to the back of the line
		 * */
		else if(this.size() > 1) {
			Node oldHeadNode = head;

			this.head = new Node(e, oldHeadNode);

			currentSize++;
		}


	}

	@Override
	public E dequeue() {
		E valueToReturn = null;

		if(this.isEmpty()) {

			return null;
		}
		else if(this.size() == 1) {
			valueToReturn = head.getValue();
			head.clear();
			tail.clear();
			currentSize--;
		}
		else if(this.size() > 1) {
			Node rmNode = tail;

			Node newTail = head;

			for(int i = this.size() - 1; i > 0; newTail = newTail.getNext(), i--);



			tail.setValue(newTail.getValue());

			valueToReturn  = rmNode.getValue();

			currentSize--;

		}

		return valueToReturn;
	}

	@Override
	public E front() {
		return tail.getValue();
	}

	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

	@Override
	public void clear() {
		while (!isEmpty())
			dequeue();
	}

	@Override
	public int size() {
		return currentSize;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E[] toArray() {

		if(this.isEmpty())
			throw new ArrayIndexOutOfBoundsException("The current queue is empty");

		E[] theArray = (E[]) new Object[size()];

		int i = 0;

		if(this.size() == 1) {
			theArray[0] = tail.getValue();
			return theArray;
		}
		//Left most element is the rear of the line, right most element is the front
		for (Node curNode = head; !curNode.equals(tail); curNode = curNode.getNext()) {
			theArray[i++] = curNode.getValue();
		}
		theArray[i] = tail.getValue();

		return theArray;
	}

//	public static void main(String[] args) {
//		Queue<Object> newQ = new SinglyLinkedQueue<Object>();
//
//
//		newQ.enqueue(2);
//		newQ.enqueue(4);
//		newQ.enqueue(6);
//		newQ.enqueue(7);
//		newQ.enqueue(8);
//		newQ.enqueue(10);
//		newQ.clear();
//		newQ.enqueue(1);
//		newQ.enqueue(1);
//
//		System.out.print("[ ");
//		for(Object obj : newQ.toArray()) {
//			System.out.print(obj + ", ");
//		}
//		System.out.println(" ]");
//
//	}

}
