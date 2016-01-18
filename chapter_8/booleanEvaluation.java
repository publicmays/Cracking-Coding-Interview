/**
 * 8.14 Boolean Evaluation
 * Given a boolean expression consisting of the symbols 0 - false, 1 - true,
 * AND, OR, XOR (& | ^)
 * and a desired boolean result value result, implement a function to count the
 * number of ways of parenthesizing the expression such that it evaluates to result. 
 * The expression should be fully parenthesized
 * Ex : countEval("1^0|0|1", false) -> 2
 */
int countEval(String s, boolean result, HashMap<String, Integer> memo) {
	if (s.length() == 0)
		return 0;
	if (s.length() == 1)
		return result == stringToBool(s) ? 1 : 0;
	if (memo.contains(result + s))
		return memo.get(result+s);

	for(int i = 1; i < s.length(); i += 2) {
		char c = s.charAt(i);
		left = s.substring(0, i);
		right = s.substring(i+1, s.length());

		int leftTrue = countEval(left, true, memo);
		int leftFalse = countEval(left, false, memo);
		int rightTrue = countEval(right, true, memo);
		int rightFalse = countEval(right, false, memo);

		int total = (leftTrue + leftFalse) * (rightTrue + rightFalse);
		int totalTrue = 0;
		if (c == "^")
			totalTrue = (leftTrue * rightFalse) + (rightTrue * leftFalse);
		else if (c == "&" )
			totalTrue = (leftTrue * rightTrue);
		else if (c == "|") 
			totalTrue = (leftTrue * rightFalse) + (leftTrue * rightTrue) + (leftFalse * rightTrue);

		int subWays = result ? totalTrue : total - totalTrue
		ways += subWays 
	}
	memo.put(result+s, ways);
	return ways;
}
