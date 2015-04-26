package lab11;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class TextFileService {
    private ArrayList<Account> accounts = new ArrayList<Account>();
    private FileInputStream fis;
    private Scanner scr;
    
    public TextFileService() throws FileNotFoundException{
	fis = new FileInputStream("src\\lab11\\accounts.txt");
	scr = new Scanner(fis);
    }
    
    public void populateAccountsFromFile(){
	while (scr.hasNextLine()) {
	    Account temp = new Account();
	    
	    temp.getUsername().setUsername(scr.next());
	    temp.getPassword().setShift(scr.nextInt());
	    temp.getPassword().setCipheredText(scr.next());
	    
	    temp.getPassword().decrypt();
	    
	    accounts.add(temp);
	}

	scr.close();
	
    }
    
    public static void main(String[] args){
	try {
	    TextFileService asdf = new TextFileService();
	    asdf.populateAccountsFromFile();
	    
	    System.out.println(asdf.getAccounts());
	} catch (FileNotFoundException e) {
	    e.printStackTrace();
	}
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }
}
