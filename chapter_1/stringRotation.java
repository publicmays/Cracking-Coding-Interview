/**
 * 1.9 String Rotation
 * Assume you have a method isSubstring which checks if one word is a substring of another. 
 * Given 2 strings, s1 and s2, write code to check if s2 is a rotation of s1 using
 * only one call to isSubstring (ex. "waterbottle" is a rotation of "erbottlewat")
 */

boolean stringRotation (String s1, String s2) {
	if (s1.length() == s2.length() && s1.length() > 0) {
		StringBuilder rotation = new StringBuilder();
		rotation = s1+s1;
		return s2.isSubstring(s1);
	}
	return false;
}

/**
 * A - length S1
 * B - length S2
 * isSubString - O(A+B) time
 * stringRotation - O(N) time
 */