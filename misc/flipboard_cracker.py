# Design a flipboard.
# Assume messages are left aligned, only has alphabets, only goes forward, has 1 row size, the sentence fits in the size of the board


flipboard(messages, standardBoard):
	# convert char to int
	intMessages = none
	for i in range(0, len(messages)):
		message = messages[i]
		sb = none
		for j in range(0, len(message)):
			character = message[j]
			sb.append(characterToInt(character))
		intMessages.append(sb)

	for k in range(0, len(intMessages)):
		messageIndex = 0
		currentMessage = intMessages[k]
		for l in range(0, len(currentMessage)):
			numCharacter = currentMessage[l]
			timesToFlip = calculate(numCharacter, standardBoard[messageIndex])
			standardBoard[messageIndex].Flip(timesToFlip);
			++messageIndex