/**
 * 8.7 Permutations without Dups - Write a method to compute all permutations of a string
 * of unique characters
 */

ArrayList<String> getPerms(String remainder) {
	int len = remainder.length();
	ArrayList<String> result = new ArrayList<String>();
	if (len == 0) {
		result.add("");
		return result;
	}
	for (int i = 0; i < len; ++i) {
		// remove char i and find permutations of remaining chars
		String before = remainder.substring(0,i);
		String after = remainder.substring(i+1, len);
		ArrayList<String> partials = getPerms(before + after);

		// prepend char i to each permutation
		for (String s : partials)
			result.add(remainder.charAt(i) + s);
	}
	return result;
}

/* Needs Work 
abc
len = 3
for i = 0
	before = ""
	after = "bc"
	partials = getPerms("" + "bc") = ["", "c", "b", "bc"]

	for s = "", c, b, bc
		result = ["", "c", "b", "bc", "a", "ac", "ab", "abc"]
for i = 1
	for s = "", c, b, bc
		result = ["", "c", "b", "bc", "a", "ac", "ab", "abc", 
				  					  "b", "bc", "bb", "bbc"]
for i = 2
	for s = "", c, b, bc
		result = ["", "c", "b", "bc", "a", "ac", "ab", "abc", 
				  					  "b", "bc", "bb", "bbc",
				  					  "c", "cc", "cb", "cbc", ""]

--------
		len = 2
		for i = 0
			before = ""
			after = "c"
			partials = getPerms("" + "c") = ["", c"]

			for s = ""
				result = ["", "c", "b"]
				s = "c"
				result = ["", "c", "b", "bc"]
		for i = 1
			for s = "c"
				result = ["", "c", "b", "bc", "c", "cc"]
		--------
				len = 1
				for i = 0
					before = ""
					after = ""
					partials = getPerms("" + "") = ""
					
					for s = ""
						result = ["c"]
				result = ["c"]
				--------
					len = 0
					result = [""];

*/
