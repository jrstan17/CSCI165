package lab10;

import java.text.DecimalFormat;

public class Student implements Comparable<Student>, Cloneable {
    public enum Grade {
	FR, SO, JR, SR
    };

    private String fName = "";
    private String lName = "";
    private double gpa = 0;
    private String email = "";
    private Grade grade = Grade.FR;
    private Address address;

    public Student() {
	fName = "fName";
	lName = "lName";
	gpa = 0;
	email = "email@email.com";
	address = new Address();
    }

    public Student(Student originalObject) {
	if (originalObject == null) {
	    System.out.println("Error: null Student object.");
	    System.exit(0);
	}
	// else
	fName = originalObject.fName;
	lName = originalObject.lName;
	gpa = originalObject.gpa;
	email = originalObject.email;
	
	try {
	    address = (Address) address.clone();
	} catch (CloneNotSupportedException e) {
	    e.printStackTrace();
	}
    }

    public Object clone() throws CloneNotSupportedException {
	return super.clone();
    }
    
    public boolean equals(Object other) {
	if (other == null) {
	    return false;
	} // end of if ()
	else if (this.getClass() != other.getClass()) {
	    return false;
	} // end of if ()
	else {
	    Student student = (Student) other;
	    return ((this.fName.equals(student.fName))
		    && (this.lName.equals(student.lName))
		    && (this.gpa == student.gpa)
		    && (this.email.equals(student.email))
		    && (this.address.equals(student.address)));
	} // end of else
    }

    public String toString() {
	DecimalFormat df = new DecimalFormat("0.00");
	StringBuilder sb = new StringBuilder();

	sb.append("Name: ");
	sb.append(fName + " " + lName);
	sb.append(" / GPA: ");
	sb.append(df.format(gpa));
	sb.append(" / Class: ");
	sb.append(grade);
	sb.append(" / Email: ");
	sb.append(email);
	sb.append("\n");
	sb.append(address);

	return sb.toString();
    }

    @Override
    public int compareTo(Student o) {
	if ( this.gpa < o.gpa ) {
	    return -1;
	} else if ( this.gpa > o.gpa ) {
	    return 1;
	} else
	    return 0;
    }
    
    /*@Override
    public int compareTo(Student o) {
	if ( this.grade.ordinal() < o.grade.ordinal() ) {
	    return -1;
	} else if ( this.grade.ordinal() > o.grade.ordinal() ) {
	    return 1;
	} else
	    return 0;
    }*/
    
    /*@Override
    public int compareTo(Student o) {
	return this.lName.compareTo(o.lName);
    }*/

    public String getFName() {
	return fName;
    }

    public void setFName(String fName) {
	this.fName = fName;
    }

    public String getLName() {
	return lName;
    }

    public void setLName(String lName) {
	this.lName = lName;
    }

    public double getGPA() {
	return gpa;
    }

    public void setGPA(double gpa) {
	this.gpa = gpa;
    }

    public String getEmail() {
	return email;
    }

    public void setEmail(String email) {
	this.email = email;
    }

    public Address getAddress() {
	return address;
    }

    public void setAddress(Address address) {
	this.address = new Address(address);
    }

    public Grade getGrade() {
	return grade;
    }

    public void setGrade(Grade grade) {
	this.grade = grade;
    }

}
