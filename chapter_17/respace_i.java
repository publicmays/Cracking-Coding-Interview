/**
 * 17.13 - Re Space
 * input: jesslookedjustliketimherbrother
 * output: jess looked just like tim her brother
 */

String bestSplit(HashSet<String> dictionary, String sentence) {
	ParseResult r = split(dictionary, sentence, 0);
	return r == null ? null : r.parsed;
}

ParseResult split(HashSet<String> dictionary, String sentence, int start) {
	if (start >= sentence.length())		return new ParseResult(0, "");

	int bestInvalid = Integer.MAX_VALUE;		// const value (2^31)-1
	String bestParsing = null;
	String partial = "";
	int index = start;	// 0
	while (index < sentence.length()) {
		char c = sentence.charAt(index);
		partial += c;
		int invalid = dictionary.contains(partial) ? 0 : partial.length();
		if (invalid < bestInvalid) {
			ParseResult result = split(dictionary, sentence, index+1);
			if (invalid + result.invalid < bestInvalid) {
				bestInvalid = invalid + result.invalid;
				bestParsing = partial = " " + result.parsed;
				if (bestInvalid == 0)	break;
			}
		}
		++index;
	}
	return new ParseResult(bestIndex, bestParsing);

}

public class ParseResult {
	public int invalid = Integer.MAX_VALUE;
	public String parsed = " ";
	public ParseResult(int inv, String p) {
		invalid = inv;
		parsed = p;
	}
}

/**
 * O(2^n) time, n characters making 2 choices at each character
 * 
 */