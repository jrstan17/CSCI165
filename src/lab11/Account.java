package lab11;

public class Account {
    private Username username;
    private Password password;

    public Account() {
	username = new Username();
	password = new Password();
    }

    public Account(String username, String password) {
	this.username = new Username(username);
	this.password = new Password(password);
    }

    public Account(Account originalObject) {
	if (originalObject == null) {
	    System.out.println("Error: null Account object.");
	    System.exit(0);
	}
	// else
	username = originalObject.username;
	password = originalObject.password;
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
