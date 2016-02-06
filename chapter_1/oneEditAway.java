/**
 * 1.5 - There are 3 types of edits that can be performed on strings: insert, remove, replace a char.
 * Given 2 strings, write a function to check if they are one edit (or zero edits) away
 */

boolean oneEditAway(String first, String second) {
	if (first.length() == second.length())
		return replace(first, second);
	else if (first.length() + 1 == second.length())
		return insert(first, second);
	else if (firstLength == second.length() + 1)
		return insert(second, first);
}

boolean replace(String s1, s2) {
	boolean oneEdit = false;
	for (int i = 0; i < s1.length; ++i) {
		if (s1.charAt(i) != s2.charAt(i)) {
			if (oneEdit)
				return false;
			oneEdit = true;
		}
	}
	return true;
}

/* Check if you can insert a character into s1 to make s2 */
boolean insert(String s1, String s2) {
	int index1 = 0, index2 = 0;
	while (index2 < s2.length() && index1 < s1.length()) {
		if (s1.charAt(index1) != s2.charAt(index2)) {
			if (index1 != index2)
				return false;
			++index2;
		}
		else 
			++index1; ++index2;
	}
	return true;
}

/* O(N) time */

/**
 *  Can combine insert and replace into one different method
 */
