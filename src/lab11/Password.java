package lab11;

import java.text.DecimalFormat;
import java.util.Random;

public class Password {
    private String text = "";
    private String cipheredText = "";
    private int shift = 0;

    public final static int SHIFT_MIN = 1;
    public final static int SHIFT_MAX = 25;
    public final static int CHAR_LOWER_BOUND = 33;
    public final static int CHAR_UPPER_BOUND = 126;

    private enum Crypt {
	ENCRYPT, DECRYPT
    };

    public Password() {
	setRandomShift();
    }

    public Password(String password) {
	setRandomShift();
	text = password;
	this.encrypt();
    }
    
    
    
    
    
    
    
    
    
    
    public String toString() {
	StringBuilder sb = new StringBuilder();

	sb.append("Decrypted Password: ");
	sb.append(text);
	sb.append(" / Encrypted Password: ");
	sb.append(cipheredText);
	sb.append(" / Shift: ");
	sb.append(shift);
	sb.append("\n");

	return sb.toString();
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    

    public String getText() {
	return text;
    }

    public void setText(String text) {
	this.text = text;
    }

    public String getCipheredText() {
	return cipheredText;
    }

    public void setCipheredText(String cipheredText) {
	this.cipheredText = cipheredText;
    }

    public void encrypt() {
	if (text != null && !text.isEmpty() && cipheredText.isEmpty()) {
	    for (int i = 0; i < text.length(); i++) {
		cipheredText += shiftChar(text.charAt(i), Crypt.ENCRYPT);
	    }
	}
    }

    public void decrypt() {
	if (cipheredText != null && !cipheredText.isEmpty() && text.isEmpty()) {
	    for (int i = 0; i < cipheredText.length(); i++) {
		text += shiftChar(cipheredText.charAt(i), Crypt.DECRYPT);
	    }
	}
    }

    private char shiftChar(char c, Crypt crypt) {
	int cToInt = (int) c;
	char charToReturn = ' ';

	if (crypt == Crypt.DECRYPT) {
	    if (cToInt - shift >= CHAR_LOWER_BOUND) {
		charToReturn = (char) (c - shift);
	    } else {
		int distanceToLowerBound = cToInt - CHAR_LOWER_BOUND;
		int removedDistanceToLowerBound = shift - distanceToLowerBound;
		int decryptedCharToInt = CHAR_UPPER_BOUND
			- removedDistanceToLowerBound;
		decryptedCharToInt++; // make CHAR_LOWER_BOUND character
				      // inclusive

		charToReturn = (char) decryptedCharToInt;
	    }
	}

	if (crypt == Crypt.ENCRYPT) {
	    if (cToInt + shift <= CHAR_UPPER_BOUND) {
		charToReturn = (char) (c + shift);
	    } else {
		int distanceToUpperBound = CHAR_UPPER_BOUND - cToInt;
		int removedDistanceToUpperBound = shift - distanceToUpperBound;
		int encryptedCharToInt = CHAR_LOWER_BOUND
			+ removedDistanceToUpperBound;
		encryptedCharToInt--; // make CHAR_LOWER_BOUND character
				      // inclusive

		charToReturn = (char) encryptedCharToInt;
	    }
	}
	return charToReturn;
    }

    public int getShift() {
	return shift;
    }

    private void setRandomShift() {
	final Random rnd = new Random();
	shift = rnd.nextInt(SHIFT_MAX) + SHIFT_MIN;
    }

    public void setShift(int shift) {
	this.shift = shift;
    }
}
