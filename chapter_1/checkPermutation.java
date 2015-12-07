/**
 * 1.2 - Check Permutation
 * Given 2 strings, write a method to decide if one is a permutation of the other
 */

String sort(String s) {
	char[] content = s.toCharArray();
	java.util.Arrays.sort(content);
	return new String(content);
}

boolean permutation(String s, String t) {
	if(s.length() != t.length()) 
		return false;
	return sort(s).equals(sort(t));
}

