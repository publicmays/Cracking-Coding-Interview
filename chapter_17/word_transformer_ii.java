/**
 * 17.22 Word Transformer 
 * Input : DAMP, LIKE
 * Output : DAMP -> LAMP -> LIMP -> LIME -> LIKE
 */

LinkedList<String> transform (String start, String stop, String[] words) {
	HashMapList<String, String> wildcardToWordList = createWildCardToWordMap(words);
	HashSet<String> visited = new HashSet<String>();
	return transform (visited, start, stop, wildcardToWordList);
}

// do DFS from startWord to stopWord, traveling through each word that is one edit away
LinkedList<String> transform(HashSet<String> visited, String start, String stop, HashMapList<String, String> wildCardToWordList) {
	if (start.equals(stop)) {
		LinkedList<String> path = new LinkedList<String>();
		path.add(start);
		return path;
	}
	else if ( visited.contains(start) )	return null;

	visited.add(start);
	ArrayList<String> words = getValidLinkedWords(start, wildcardToWordList);

	for (String word : words) {
		LinkedList<String> path = transform(visited, word, stop, wildCardToWordList);
		if (path) {
			path.addFirst(start);
			return path;
		}
	}
	return null;
}

// insert words in dictioary into mapping from wildcard form -> word
HashMapList<String, String> createWildcardToWordMap(String[] words) {
	HashMapList<String, String> wildcardToWords = new HashMapList<Stirng, String>();
	for (String word : words) {
		ArrayList<String> linked = getWildcardRoots(word);
		for (String linkedWord : linked) 
			wildCardToWords.put(linkedWord, word); // (root, word)
	
	return wildCardToWords;
}

ArrayList<String> getWildCardRoots(String w) {
	ArrayList<String> words = new ArrayList<String>();
	for (int i = 0; i < w.length(); ++i) {
		String word = w.substring(0, i) + "_" + w.substring(i+1);
		words.add(word);
	}
	return words;
}

/* Return words that are one edit away */
ArrayList<String> getValidLinkedWords(String word, HashMapList<String, String> wildcardToWords) {
	ArrayList<String> wildcards = getWildcardRoots(word);
	ArrayList<String> linkedWords = new ArrayList<String>();
	for (String wildcard : wildcards) {
		ArrayList<String> words = wildcardToWords.get(wildcard);
		for (String linkedWord : words) {
			if (!linkedWord.equal(word))
				linkedWords.add(linkedWord);
		}
	}
	return linkedWords;

}