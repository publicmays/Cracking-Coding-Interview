/**
 * 1.6 String Compression
 * Implement a method to perform basic string compression using the counts of repeated characters.
 * Example : aabcccccaaa would beocme a2b1c5a3. If the compressed string would not become smaller 
 * than the original string. Your method should return the original string. You can assume the string
 * has only uppercase and lowercase letters (a - z)
 */

String compress( String str ) {
	StringBuilder compressed = new StringBuilder();
	int count = 0;
	for (int i = 0; i < str.length(); ++i) {
		++count;
		if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i+1)) {`// last case, next char diff than current
			compressed.append(str.charAt(i));
			compressed.append(count);
			count = 0;
		}
	}
	return compressed.length() < str.length() ? compressed.toString() : str);
}