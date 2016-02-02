/**
 * 17.22 Word Transformer 
 * Input : DAMP, LIKE
 * Output : DAMP -> LAMP -> LIMP -> LIME -> LIKE
 */

LinkedList<String> transform (String start, String stop, String[] words) {
	HashSet<String> dict = setupDictionary(words);
	HashSet<String> visited = new HashSet<String>();
	return transform (visited, start, stop, dict);
}

HashSet<String> setupDictionary(String[] words) {
	HashSet<String> hash = new HashSet<String>();
	for (String word : words) 
		hash.add(word.toLowerCase());
	return hash;
}

LinkedList<String> transform(HashSet<String> visited, String startWord, String stopWord, Set<String> dictionary) {
	if (startWord.equals(stopWord)) {
		LinkedList<String> path = new LinkedList<String>();
		path.add(startWord);
		return path;
	}
	else if (visited.contains(startWord) || !dictionary.contains(startWord))
		return null;
	
	visited.add(startWord);
	ArrayList<String> words = wordsOneAway(startWord);
	for (String word : words) {
		LinkedList<String> path = transform(visited, word, stopWord, dictionary);
		if (path) {
			path.addFirst(startWord);
			return path;
		}
	}
	return null;
}

ArrayList<String> wordsOneAway(String word) {
	ArrayList<String> words = new ArrayList<String>();
	for (int i = 0; i < word.length(); ++i) {
		for (char c = 'a'; c <= 'z'; c++) {
			String w = word.substring(0, i) + c + word.substring(i+1);
			words.add(w);
		}
	}
	return words;
}
