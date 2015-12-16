/**
 * 3.3 - Stack of Plates
 * Imagine a stack of plates, if the stack gts too high, it might topple
 * Therefore in real life, we would like to start a new stack when the previous
 * stack exceeds some threshold. Implement a data structure SetOfStacks. Should be composed
 * of several stacks and sould create a new stack once the previous exceeds
 * capacity. SetOfStacks.push() and SetOfStacks.pop() should behave identically to
 * a single stack
 * Follow Up
 * Implement a function popAt(int index) which performs a pop operation on a specific
 * sub-stack
 */

class SetOfStacks {
	ArrayList<Stack> stacks = new new ArrayList<Stack>();
	public int capacity;
	public SetOfStacks(int capacity) {
		this.capacity = capacity;
	}
	public Stack getLastStack() {
		if(stacks.size() == 0)	return null;
		return stacks.get(stacks.size()-1);
	}
	public void push(int v) {
		Stack last = getLastStack();
		if (last && !last.isFull()) 
			last.push(v);
		else {
			Stack s = new Stack(capacity);
			s.push(v);
			stacks.add(s);
		}
	}
	public int pop() {
		Stack last = getLastStack();
		if (!last)	throw new EmptyStackException();
		int v = last.pop();
		if (last.size == 0)
			stacks.remove(stacks.size()-1);
		return v;
	}
	public boolean isEmpty() {
		Stack last = getLastStack();
		return last == null || last.isEmpty();
	}
	public int popAt(int index) {
		return leftShift(index, true);
	}
	public int leftShift(int index, boolean removeTop) {
		Stack stack = stacks.get(index);
		int removed_item;
		if (removeTop)
			removed_item = stack.pop();
		else
			removed_item = stack.removeBottom();

		if(stack.isEmpty())
			stacks.remove(index);

		else if (stacks.size() > index + 1) {
			int v = leftShift(index+1, false);
			stack.push(v);
		}
		return removed_item;

	}
}

public class Stack {
	private int capacity;
	public Node top, bottom;
	public int size = 0;

	public Stack(int capacity) {	this.capacity = capacity;	}
	public isFull() {	return capacity == size;	}

	public void join(Node above, Node below) {
		if (below)	below.above = above;
		if (above)	above.below = below;
	}
	public boolean push (int v) {
		if (size >= capacity)	
			return false;
		++size;
		Node n = new Node(v);
		if (size == 1)
			bottom = n;
		join(n, top);
		top = n;
		return true;
	}

	public int pop() {
		Node t = top;
		top = top.below;
		--size;
		return t.value;
	}

	public boolean isEmpty() {
		return size == 0;
	}
	public int removeBottom() {
		Node b = bottom;
		bottom = bottom.above;
		if (bottom != null)	bottom.below = null;
		--size;
		return b.value;
	}
}

/* 
1 2 3 4 5

	3

v = (4, false)
	removed_item = 1
	v = (5, false)
		removed_item = 2
			v = ()
			4,5,1,2
*/