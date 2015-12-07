/**
 * 1.1 - Is Unique
 * Implement an algorithm to determine if a string has all unique characters.
 * What if you cannot use additional data structures
 */

boolean isUnique(String str) {
	if(str.length() > 128)	return false;
	boolean[] char_set = new boolean[128];
	for(int i = 0; i < str.length(); ++i) {
		int val = str.charAt(i);
		if(char_set[val])
			return false;
		char_set[val] = true;
	}
	return true;
}

/**
 * Time Complexity O(n)
 * Space Complexity O(1) - for loop will never iterate more than 128 characters
 * O(c) space and O(min(n,c)) time - c is char set
 */