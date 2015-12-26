/**
 * 8.7 Permutations without Dups - Write a method to compute all permutations of a string
 * of unique characters
 */

ArrayList<String> getPerms(String str) {
	ArrayList<String> result = new ArrayList<String>();
	getPerms("", str, result);
	return result;
}

void getPerms(String prefix, String remainder, ArrayList<String> result) {
	if (remainder.length() == 0)
		result.add(prefix);
	int len = remainder.length();
	for (int i = 0; i < remainder.length(); ++i) {
		String before = remainder.substring(0, i);
		String after = remainder.substring(i+1, len);
		char c = remainder.charAt(i);
		getPerms(prefix + c, before + after, result);
	}
}

/* O(N!) time 

getPerms("", ab, result)
	prefix = ""
	len = 2
	for i = 0
		before = ""
		after = "b"
		c = "a"
		-------
		getPerms("a", "b", result)
			prefix = "a"
			len = 1
			for i = 0
				before = ""
				after = ""
				c = "b"
				--------
				getPerms("ab", "", result)
					length = 0
					result.add("ab")
	for i = 1
		before = "a"
		after = ""
		c = "b"
		-------
		getPerms("b", "a", result)
			prefix = "b"
			len = 1
			for i = 0
				before = ""
				after = ""
				c = "a"
				--------
				getPerms("ba", "", result)
					length = 0
					result.add("ba")

*/