public class MyQueue<T> {
	private static class QueueNode<T> {
		private T data;
		private QueueNode<T> next;
		public QueueNode(T data) {
			this.data = data;
		}
	}
	private QueueNode<T> first;
	private QueueNode<T> last;

	public void add(T item) {

		QueueNode<T> t = new QueueNode(item);
		if (last) 
			last.next = t;
		last = t;
		if (!first) 
			first = last;
	}

	public T remove() {
		if (!first)	throw new NoSuchElementException();

		T _data = first.data;
		first = first.next;
		if (!first)
			last = null;

		return _data;

	}
	public T peek() {
		if (!first)	throw new NoSuchElementException();
		return first.data;
	}
	public boolean isEmpty() {
		return first == null;
	}
}