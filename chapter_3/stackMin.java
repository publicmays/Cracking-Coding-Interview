/**
 * 3.2 - Stack Min
 * How would you design a stack that has a function min which returns
 * min element. Push, Pop, min should operate in O(1) time
 */

public class StackWithMin2() extends Stack<Integer> {
	Stack<Integer> s2;
	public StackWithMin2() {
		s2 = new Stack<Integer>();
	}
	public void push(int value) {
		if (value <= min())
			s2.push(value);
		super.push(value);
	}
	public Integer pop() {
		int value = super.pop();
		if (value == min())
			s2.pop();
		return value;
	}
	public int min() {
		if (s2.isEmpty())
			return Integer.MAX_VALUE;
		else
			return s2.peek();
	}
}