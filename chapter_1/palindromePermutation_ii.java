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
	int countOdd = 0;
	int[] table = new int[Character.getNumericValue('z') - Character.getNumericaValue('a')];
	for (char c : phrase.toCharArray()) {
		int x = getCharNumber(c);
		if (x != -1) 
			++table[x];
			if (table[x] % 2 == 1)
				++countOdd;
			else
				--countOdd;
		
	}
	return countOdd <= 1;
}

/* Alternative but not most optimal solution 
 * Checking as they go along */