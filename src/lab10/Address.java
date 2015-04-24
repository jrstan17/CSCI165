package lab10;

public class Address implements Cloneable {
    private String street = "";
    private String city = "";
    private String state = "";
    private String zip = "";

    public Address() {
	street = "street";
	city = "city";
	state = "state";
	zip = "zip";
    }

    public Address(Address originalObject) {
	if (originalObject == null) {
	    System.out.println("Error: null Address object.");
	    System.exit(0);
	}
	// else
	street = originalObject.street;
	city = originalObject.city;
	state = originalObject.state;
	zip = originalObject.zip;
    }

    public boolean equals(Object other) {
	if (other == null) {
	    return false;
	} // end of if ()
	else if (this.getClass() != other.getClass()) {
	    return false;
	} // end of if ()
	else {
	    Address address = (Address) other;
	    return (this.street.equals(address.street)
		    && this.city.equals(address.city)
		    && this.state.equals(address.state) && this.zip
			.equals(address.zip));
	} // end of else
    }

    public Object clone() throws CloneNotSupportedException{
	return super.clone();
    }

    public String toString() {
	StringBuilder sb = new StringBuilder();

	sb.append("Address: ");
	sb.append(street);
	sb.append(", ");
	sb.append(city);
	sb.append(", ");
	sb.append(state);
	sb.append(" ");
	sb.append(zip);
	sb.append("\n");

	return sb.toString();
    }

    public String getStreet() {
	return street;
    }

    public void setStreet(String street) {
	this.street = street;
    }

    public String getCity() {
	return city;
    }

    public void setCity(String city) {
	this.city = city;
    }

    public String getState() {
	return state;
    }

    public void setState(String state) {
	this.state = state;
    }

    public String getZip() {
	return zip;
    }

    public void setZip(String zip) {
	this.zip = zip;
    }

}
