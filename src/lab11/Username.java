package lab11;

import lab10.Student;

public class Username {
    private String username = "";
    
    
    
    public String toString() {
	StringBuilder sb = new StringBuilder();

	sb.append("User Name: ");
	sb.append(username);
	sb.append("\n");

	return sb.toString();
    }
    
    public boolean equals(Object other) {
 	if (other == null) {
 	    return false;
 	} // end of if ()
 	else if (this.getClass() != other.getClass()) {
 	    return false;
 	} // end of if ()
 	else {
 	    Username username = (Username) other;
 	    return (this.username.equals(username.username));
 	} // end of else
     }
    
    
    
    
    
    
    

    public String getUsername() {
	return username;
    }

    public void setUsername(String username) {
	this.username = username;
    }
}
