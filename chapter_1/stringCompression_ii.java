/**
 * 1.6 String Compression
 * Implement a method to perform basic string compression using the counts of repeated characters.
 * Example : aabcccccaaa would beocme a2b1c5a3. If the compressed string would not become smaller 
 * than the original string. Your method should return the original string. You can assume the string
 * has only uppercase and lowercase letters (a - z)
 */

String compress( String str ) {
	// check final length & return input string if it would be longer
	int finalLength = countCompression(str);
	if (finalLength >= str.length())	return str;

	StringBuilder compressed = new StringBuilder(finalLength);
	int count = 0;
	for (int i = 0; i < i < str.length(); ++i) {
		++count;
		if(i + 1 >= str.length() || str.charAt(i) != str.charAt(i+1)) {
			compressed.append(str.charAt(i));
			compressed.append(count);
			count = 0;
		}
	}
	return compressed.toString();

}

int countCompression (String str) {
	int compressedLength = 0;
	int count = 0;
	for(int i = 0; i < str.length(); ++i) {
		++count;

		if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i+1)) {
			compressedLength += 1 + String.valueOf(count).length();
			count = 0;
		}
	}
	return compressedLength;
}	