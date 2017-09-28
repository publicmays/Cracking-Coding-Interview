class Node:
	Node left
	Node right
	int data

class IterationData:
	int returnVal
	int iterationCount

def findNth(self, node, data, n):
	if node.left is not null:
		data = findNth(node, data, n)

	if data.iterationCount < n:
		++data.iterationCount

		if data.iterationCount == n:
			data.returnVal = node.data
			return data
		elif node.right is not null:
			return findNth(node.right, data, n)
		else:
			return data
