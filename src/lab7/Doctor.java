package lab7;

import java.util.ArrayList;

public class Doctor extends SalariedEmployee {
    private String speciality;
    private double officeVisitFee;
    private ArrayList<String> specialSkills;

    public Doctor() {
	super();
    }

    public Doctor(SalariedEmployee doctor, String speciality,
	    double officeVisitFee, ArrayList<String> specialSkills) {
	super(doctor);
	this.speciality = speciality;
	this.officeVisitFee = officeVisitFee;
	this.specialSkills = specialSkills;
    }

    public Doctor(Doctor doctor) {
	super(doctor);

	if (doctor != null) {
	    this.speciality = doctor.speciality;
	    this.officeVisitFee = doctor.officeVisitFee;
	    this.specialSkills = new ArrayList<String>(specialSkills);
	}
    }

    @Override
    public String toString() {
	StringBuilder str = new StringBuilder();

	str.append(super.toString() + "/n");
	str.append("Speciality: ");
	str.append(speciality + "/n");
	str.append("Office Visit Fee: ");
	str.append("$" + officeVisitFee + "/n");
	str.append("Special Skills: ");
	str.append(specialSkills + "/n");

	return str.toString();
    }

    public boolean equals(Object otherObject) {
	if (otherObject == null)
	    return false;
	else if (getClass() != otherObject.getClass())
	    return false;
	else {
	    Doctor otherDoctor = (Doctor) otherObject;
	    return (super.equals(otherDoctor)
		    && (speciality == otherDoctor.speciality)
		    && (officeVisitFee == otherDoctor.officeVisitFee) && (specialSkills == otherDoctor.specialSkills));
	}
    }

    public String getSpeciality() {
	return speciality;
    }

    public void setSpeciality(String speciality) {
	this.speciality = speciality;
    }

    public double getOfficeVisitFee() {
	return officeVisitFee;
    }

    public void setOfficeVisitFee(double officeVisitFee) {
	this.officeVisitFee = officeVisitFee;
    }

    public ArrayList<String> getSpecialSkills() {
	return new ArrayList<String>(specialSkills);
    }

    public void setSpecialSkills(ArrayList<String> specialSkills) {
	this.specialSkills = new ArrayList<String>(specialSkills);
    }
}
