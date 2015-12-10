/**
 * 1.3 - URLify
 * Write a method to replace all spaces in a string w/ '%20'
 * You may assume that the string has sufficient space at the end
 * to hold the additional characters, and that you are given the 
 * "true" length of the string. 
 * Example
 * Input : 'Mr. John Smith', 13
 * Ouput : 'Mr%20John%20Smith'
 */

void replaceSpaces(char[] str, int length) {
	int spaceCount = 0, newLength, i;
	for(i = 0; i < length; ++i)
		if(str[i] == ' ')
			++spaceCount;
	newLength = length + spaceCount * 2;
	str[newLength] = '\0';		// null terminator
	for(i = length-1; i >= 0; --i) {
		if(str[i] == ' ') {
			str[newLength - 1] = '0';
			str[newLength - 2] = '2';
			str[newLength - 3] = '%';
			newLength = newLength-3;
		}
		else {
			str[newLength - 1] = str[i];
			--newLength;
		}
	}
}