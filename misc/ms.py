Given an array
find the number that appears an odd number of times once


2 3 4 6 2 3 4

2 3 4 6 2 3 4
currentValue = 2
oddCOunt = 4

timesiNArray = 5 % 2 == 1

oddCount = 1
oddNumber = currentValue

0 1 2 3 4 5 
2 2 4 6 2 2

2 2 2 2 4 6 6 

2 

oddVal = 0
oddCount = 0
for i in xrange(1, len(a)):
	if (a[i] == a[i-1]):
		currCount = currCount + 1
	else:
		if currCount % 2 == 1:
			oddCount = oddCount + 1
			oddVal = a[i]
		if oddCount > 1:
			return None
		currCount = 0

if oddCount != 0:
	return oddVal
else return None



