package lab11;

public class Username {
    private String username = "";
    
    
    
    public String toString() {
	StringBuilder sb = new StringBuilder();

	sb.append("User Name: ");
	sb.append(username);
	sb.append("\n");

	return sb.toString();
    }
    
    
    
    
    
    
    

    public String getUsername() {
	return username;
    }

    public void setUsername(String username) {
	this.username = username;
    }
}
