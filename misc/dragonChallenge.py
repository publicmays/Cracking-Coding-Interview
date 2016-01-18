import sys

class dragonChallenge:
	# Global Variables
	a=[]		# numbers from the file
	path=[]		# minJump path

	# Constants
	FAILURE = "failure\n"
	OUT = "out"

	# initialize, call storeFileInArray
	def __init__(self):
		self.storeSTDINArray()

	# entire solution call
	def solution(self):
		self.findPath()
		self.printResult(self.path)

	# open filePath, store numbers in array a
	def storeSTDINArray(self):
		for line in sys.stdin:
			try:
				self.a.append(int(line))
			except ValueError:
				self.a = []
				break;


	# returns array current index reach per index
	# [5, 3, 0] => [0+5, 1+3, 2+0]
	def currentIndexReach(self, a):
		currIndexReach = [None] * len(a)
		for i in xrange(len(a)):
			currIndexReach[i] = a[i] + i
		return currIndexReach

	# generate algorithm to find path, store in path array
	def findPath(self):
		lastIndexReach = 0					# last index reach stored
		maxIndexReach = 0					# maximum index reach when on i
		myDict = {lastIndexReach:0}			# { lastIndexReach : currIndex }
		i = 0								# index that traverses through a[]

		currIndexReach = self.currentIndexReach(self.a)	

		while i < len(self.a) and i <= maxIndexReach:
			if i > lastIndexReach:							# if i has surpassed lastIndexReach
				self.path.append(myDict[lastIndexReach])	# append corresponding index
				lastIndexReach = maxIndexReach				
			
			if currIndexReach[i] > maxIndexReach:			# if currentIndexReach surpassed maxIndexReach
				myDict[lastIndexReach] = i 							# update currentIndex

			maxIndexReach, i = max(maxIndexReach, currIndexReach[i]), i+1		# update max and current i					

		if lastIndexReach < len(self.a)-1 or len(self.path) == 0:
			self.path = []					# failure
			return


		if i > lastIndexReach and self.path[-1] != myDict[lastIndexReach]:	# broke out of loop before appending currIndex
			self.path.append(myDict[lastIndexReach])




	# append out to path and prints path array
	def printResult(self, path):
		item = ""
		if len(path) == 0:
			print self.FAILURE
		else:
			path.append(self.OUT)							# add 'out' to path array
			result = ', '.join(str(item) for item in path)    # generator expression
			print result

def main():
	myDragon = dragonChallenge()		# store file, create instance of dragonChallenge
	myDragon.solution()

if __name__ == '__main__':
	main()