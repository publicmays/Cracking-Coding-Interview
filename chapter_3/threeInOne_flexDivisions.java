/** 
 * 3.1 - Three in One
 * Describe how you could use a single array to implement 3 stacks 
 */
public class MultiStack {
	private class StackInfo {
		public int start, size, capacity;
		public StackInfo(int start, int capacity) {
			this.start = start;
			this.capacity = capcity;
		}
		public boolean isWithinStackCapacity(int index) {
			if (index < 0 || index >= values.length)	return false;
			// if index wraps around, adjust it
			int contiguousIndex = index < start ? index + values.length : index;
			int end = start + capacity;
			return start <= contiguousIndex && contiguousIndex < end;
		}
		public int lastCapacityIndex() {
			return adjustIndex(start + capacity - 1);
		}
		public int lastElementIndex() {
			return adjustIndex(start + size - 1);
		}
		public boolean isFull() {	return size == capacity;	}
		public boolean isEmpty() {	return size == 0;	}

	}
	public MultiStack(int numberOfStacks, int defaultSize) {
		// create meta data for all stacks
		info = new StackInfo[numberOfStacks];
		for (int i = 0; i < numberOfStacks; ++i) 
			info[i] = new StackInfo(defaultSize * i, defaultSize);
		values = new int[num berOfStacks * defaultSize];
	}
	public void push(int stackNum, int value) throws FullStackException {
		if (allStacksAreFull())	throw new FullStackException();
		// if stack is full expand it
		StackInfo stack = info[stackNum];
		if (stack.isFull())	expand(stackNum);

		++stack.size;
		values[stack.lastElementIndex()] = value;
	}
	public int pop(int stackNum)	throws Exception {
		StackInfo stack = info[stackNum];
		if (stack.isEmpty())	throw new EmptyStackException();
		int value = values[stack.lastElementIndex()];
		values[stack.lastElementIndex()] = 0;
		--stack.size;
		return value;
	}
	public int peek(int stackNum) {
		StackInfo stack = info[stackNum];
		return values[stack.lastElementIndex()];
	}
	private void shift(int stackNum) {
		StackInfo stack = info[stackNum];
		if (stack.size >= stack.capacity) {
			int nextStack = (stackNum + 1) % info.length;
			shift(nextStack);
			++stack.capacity;
		}
		// shift all elements in stack over by one
		int index = stack.lastCapacityIndex;
		while (stack.isWithinStackCapacity(index)) {
			values[index] = values[previousIndex(index)];
			index = previousIndex(index);
		}
		// adjust stack data
		values[stack.start] = 0;
		stack.start = nextIndex(stack.start);
		--stack.capacity;
	}
	private void expand(int stackNum) {
		shift((stack+1) % info.length);
		++info[stackNum].capacity;
	}
	public int numberOfElements() {
		int size = 0;
		for (StackInfo sd : info) 
			size += sd.size;
		return size;
	}
	public boolean allStacksAreFull() {
		return numberOfElements() == values.length;
	}
	/* adjust index to be within range of 0 -> length - 1 */
	private int adjustIndex(int index) {
		int max = values.length;
		return ((index % max) + max) % max;
	}
	private int nextIndex(int index) {
		return adjustIndex(index + 1);
	}
	private int previousIndex(int index) {
		return adjustIndex(index-1);
	}
}