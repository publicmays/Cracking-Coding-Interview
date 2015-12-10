/**
 * 1.4 Palindrome Permutation
 * Given a string, write a function to check if it is a permutation 
 * of a palindrome. A palindrome is a word or phrase that is the same
 * forwards and backwards. A permutation is a rearrangement of letters.
 * The palindrome does not need to be limited to just dictioniary words
 * Example :
 * Input : Tact Coa
 * Output : True (permutations: "taco cat", "atco cta", etc.)
 */
boolean isPermutationOfPalindrome(String phrase) {
	int[] table = buildCharFrequencyTable(phrase);
	return checkMaxOneOdd(table);
}
/* Check that no more than 1 character has an odd count */
boolean checkMaxOneOdd(int[] table) {
	boolean foundOdd = false;
	for(int count : table) 
		if (count % 2 == 1)
			if(foundOdd)
				return false;
			foundOdd = true;
	return true;
}
/* Map each character to a number. a -> 0, b -> 1, c -> 2 
 * This is not case sensitive. Non-letter characters map to -1 */
int getCharNumber(Character c) {
	int a = Character.getNumericValue('a');
	int z = Character.getNumericValue('z');
	int A = Character.getNumericValue('A');
	int Z = Character.getNumericValue('Z');

	int val = Character.getNumericValue(c);
	if( a <= val && val <= z)
		return val - a;
	else if (A <= val && val <= Z)
		return val - A;
	return -1;
}

int[] buildCharFrequencyTable(String phrase) {
	int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a')];
	for (char c : phrase.toCharArray()) {
		int x = getCharNumber(c);
		if (x != -1)
			++table[x]
	}
	return table;
}

/** 
 * O(N) time, N - length of string
 */
