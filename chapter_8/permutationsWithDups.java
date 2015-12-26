/**
 * 8.8 Permutations with Duplicates
 * Write a method to compute all permutations of a string whose characters are not
 * necessarily unique. The list of permutations should not have duplicates
 */

ArrayList<String> printPerms(String s) {
	ArrayList<String> result = new ArrayList<String>();
	HashMap<Character, Integer> map = buildFreqTable(s);
	printPerms(map, "", s.length(), result);
	return result;
}

void printPerms(HashMap<Character, Integer> map, String prefix, int remaining, ArrayList<String> result) {
	if (remaining == 0) {
		result.add(prefix);
		return;
	}
	for (Character c : map.keySet()) {
		int count = map.get(c);
		if (count > 0) {	// this may be count >= 0 ?
			map.put(c, count-1);
			printPerms(map, prefix+c, remaining-1, result);
			map.put(c, count);		// put back
		}
	}
}
HashMap<Character, Integer> buildFreqTable(String s) {
	for (char c : s.toCharArray()) {
		if (!map.containsKey(c))
			map.put(c, 0)
		else 
			map.put(c, map.get(c)+1)
	}
	return map;
}

/* aab
O(n!)
map = [a : 2, b : 1]
printPerms(map, "", 3, result)
	remainin = 3
	for c = "a0"
		count = 2
		map = [a:1, b:1]
		printPerms(map, "a0", 2, result)
		---------
		for c = "a1"
		count = 1
		map = [a:0, b:1]
		printPerms(map, "a0 a1", 1, result)
			---------
			for c = "b0"
			count = 1
			map = [a:0, b:0]
			printPerms(map, "a0 a1 b0", 0, result)
			---------
				result = ["a0a1b0"]
			map = [a:0, b:1]
		map = [a:1, b:1]
	map = [a:2, b:1]

	for c = "a1"
		count = 2
		map = [a:1, b:1]
		printPerms(map, "a1", 2, result)
		---------
		for c = "a0"
			count = 1
			map = [a:0, b:1]
			printPerms(map, "a1 a0", 1, result)
			---------
				for c = "b0"
					count = 1
					map = [a:0, b:0]
					printPerms(map, "a1 a0 b0", 0, result)
				---------
				result = ["a1a0b0"]

*/
*/