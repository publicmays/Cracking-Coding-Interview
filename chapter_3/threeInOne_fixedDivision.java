/** 
 * 3.1 - Three in One
 * Describe how you could use a single array to implement 3 stacks 
 */

class FixedMultiStack {
	private int numberOfStacks = 3;
	private int stackCapacity;
	private int[] values;
	private int[] sizes;

	public FixedMultiStack(int stackSize) {
		stackCapacity = stackSize;
		values = new int[stackSize * numberOfStacks];
		sizes = new int[numberOfStacks];
	}

	public void push(int stackNum, int value) 
		throws FullStackException {
			if (isFull(stackNum)) throw new FullStackException();
			// increment stack pointer then update top value
			++sizes[stackNum];
			values[indexOfTop(stackNum)] = value;
	}

	public int pop(int stackNum) {
		if (isEmpty(stackNum))	throw new EmptyStackException();
		int topIndex = indexOfTop(stackNum);
		values[topIndex] = 0;
		--sizes[stackNum];
		return value;
	}
	public int peek(int stackNum) {
		if (isEmpty(stackNum))	throw new EmptyStackException();
		return values[indexOfTop(stackNum)];
	}
	public boolean isEmpty(int stackNum) {
		return sizes[stackNum] == 0;
	}
	public boolean isFull(int stackNum) {
		return sizes[stackNum] == stackCapacity;
	}
	/* Index of top of stack */
	public int indexOfTop(int stackNum) {
		int offset = stackNum * stackCapacity;
		int size = sizes[stackNum];
		return offset + size - 1;
	}
}