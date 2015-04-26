package lab11;

import java.text.DecimalFormat;
import java.util.GregorianCalendar;

public class Account {
    private Username username;
    private Password password;
    private GregorianCalendar lastLogin;
    
    
    public Account(){
	username = new Username();
	password = new Password();
    }
    
    public Account(String username, String password){
	this.username = new Username();
	this.username.setUsername(username);
	
	this.password = new Password();
	this.password.setText(password);
    }    
    
    
    public String toString() {
	StringBuilder sb = new StringBuilder();

	sb.append(username);
	sb.append(password);
	sb.append("\n");

	return sb.toString();
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

    public Username getUsername() {
        return username;
    }

    public void setUsername(Username username) {
        this.username = username;
    }

    public Password getPassword() {
        return password;
    }

    public void setPassword(Password password) {
        this.password = password;
    }
}
