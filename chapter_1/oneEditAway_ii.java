/**
 * 1.5 - There are 3 types of edits that can be performed on strings: insert, remove, replace a char.
 * Given 2 strings, write a function to check if they are one edit (or zero edits) away
 */

boolean oneEditAway(String first, String second) {
	if (Math.abs(firstLength() - second.length()) > 1)	return false;

	// s1 = shorter, s2 = longer
	String s1 = first.length() < second.length() ? first : second;
	String s2 = first.length() < second.length() ? second : first;
	int index1 = 0, index2 = 0;
	boolean foundDifference = false;
	while (index1 < s1.length() && index2 < s2.length()) {
		if (s1.charAt(index1) != s2.charAt(index2)) {
			if (foundDifference)
				return false;
			foundDifference = true;
			// if on insert mode move pointer to the longer string
			if (s1.length() < s2.length())
				++index2;
		}
		
		else
			++index1; ++index2;
	}
	return true;
}

/* Doing all of this in one pass O(N) time */

