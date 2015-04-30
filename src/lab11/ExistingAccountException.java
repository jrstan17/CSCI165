package lab11;

@SuppressWarnings("serial")
public class ExistingAccountException extends Exception {
    private Account account;

    public ExistingAccountException(Account account) {
	super("ExistingAccountException");
	this.setAccount(account);
    }

    public ExistingAccountException() {
	super("ExistingAccountException");
    }

    public ExistingAccountException(String message) {
	super(message);
    }

    public Account getAccount() {
	return new Account(account);
    }

    public void setAccount(Account account) {
	this.account = account;
    }


}
