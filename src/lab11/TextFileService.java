package lab11;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class TextFileService {
    private static final String FILE_PATH = "src\\lab11\\accounts.txt";
    private FileInputStream fis;
    private Scanner scr;

    public boolean isExistingAccount(Username username) {

	try {
	    fis = new FileInputStream(FILE_PATH);
	} catch (FileNotFoundException e) {
	    e.printStackTrace();
	}
	scr = new Scanner(fis);

	while (scr.hasNextLine()) {
	    String temp = "";

	    temp = scr.next();
	    if (temp.equals(username.getUsername())) {
		scr.close();
		return true;
	    }

	    temp = scr.nextLine();
	}
	scr.close();
	return false;
    }

    public boolean isCorrect(Account account) {
	try {
	    fis = new FileInputStream(FILE_PATH);
	} catch (FileNotFoundException e) {
	    e.printStackTrace();
	}
	scr = new Scanner(fis);

	while (scr.hasNextLine()) {
	    String temp = "";
	    String username = account.getUsername().getUsername();

	    temp = scr.next();
	    if (temp.equals(username)) {

		int shift = scr.nextInt();
		String cipheredPassword = scr.next();

		Password password = new Password();
		password.setShift(shift);
		password.setCipheredText(cipheredPassword);
		password.decrypt();

		if (account.getPassword().getText().equals(password.getText())) {
		    return true;
		} else {
		    return false;
		}
	    }

	    temp = scr.nextLine();
	}
	scr.close();
	return false;
    }

    public void write(Account toAdd) {
	try {
	    File file = new File(FILE_PATH);
	    FileOutputStream fos = new FileOutputStream(file, true);

	    final String LINE_SEPARATOR = System.getProperty("line.separator");
	    String userName = toAdd.getUsername().getUsername();
	    String shift = Integer.toString(toAdd.getPassword().getShift());
	    String cipheredPassword = toAdd.getPassword().getCipheredText();
	    String strLine = LINE_SEPARATOR + userName + " " + shift + " "
		    + cipheredPassword;

	    fos.write(strLine.getBytes());
	    fos.close();

	} catch (FileNotFoundException e) {
	    e.printStackTrace();
	} catch (IOException e) {
	    e.printStackTrace();
	}

    }
}
