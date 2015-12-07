/**
 * 1.1 - Is Unique
 * Implement an algorithm to determine if a string has all unique characters.
 * What if you cannot use additional data structures
 */

boolean isUnique(String str) {
	int checker = 0;
	for(int i = 0; i < str.length(); ++i) {
		int val = str.charAt(i) - 'a';
		if((checker & (1 << val)) > 0)
			return false;
		checker |= (1 << val);
	}
	return true;
}

/**
 * Time Complexity O(n^2)
 * Space Complexity O(1)
 * 
 */