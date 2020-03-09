package Ex9_Queue.src.ciic4020.queue;

public interface QueueFactory<E> {

	public Queue<E> newInstance();

}