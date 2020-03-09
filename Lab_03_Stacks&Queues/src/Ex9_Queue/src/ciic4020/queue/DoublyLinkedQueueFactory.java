package Ex9_Queue.src.ciic4020.queue;

public class DoublyLinkedQueueFactory<E> implements QueueFactory<E> {

	@Override
	public Queue<E> newInstance() {
		return new DoublyLinkedQueue<E>();
	}

}