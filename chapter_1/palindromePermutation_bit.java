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

/**
 * Use a single integer (as a bit vector) - when we see a letter, we map it to an
 * integer between 0 and 25 (assuming an English alphabet). Then we toggle the
 * bit at that value. At the end of the iteration, we check that at most one bit
 * in the ingeger is set to 
*/

boolean isPermutationOfPalindrome(String phrase) {
	int bitVector = createBitVector(phrase);
	return bitVector == 0 || checkExactlyOneBitSet(bitVector);
}

/* Create a bit vector for the string. For each letter with value i, toggle the ith bit. */
int createBitVector(String phrase) {
	int bitVector = 0;
	for (char c : phrase.toCharArray()) {
		int x = getCharNumber(c);
		bitVector = toggle(bitVector, x);
	}
	return bitVector;
}

int toggle(int bitVector, int index) {
	if (index < 0)	return bitVector;
	int mask = 1 << index;
	if((bitVector & mask) == 0)
		bitVector |= mask;
	else
		bitVector &= ~mask;
	return bitVector;
}

/* Check that exactly one bit is set by subtracting one from the integer and ANDing it with the original integer */
boolean checkExactlyOneBitSet(int bitVector) {
	return (bitVector & (bitVector-1)) == 0;
}

/* O(N) */