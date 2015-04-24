package lab7;

import java.util.ArrayList;

public class Patient extends Person {
    private Doctor primaryPhysician;
    private ArrayList<String> medicalConditions;

    public Patient() {
	super();
    }

    public Patient(String fName, String lName, Date dob,
	    Doctor primaryPhysician, ArrayList<String> medicalConditions) {
	super.setName(fName, lName);
	super.setDOB(dob);
	this.primaryPhysician = primaryPhysician;
	this.medicalConditions = medicalConditions;
    }

    public Patient(Person person, Doctor primaryPhysician,
	    ArrayList<String> medicalConditions) {
	super.setName(person.getFirstName(), person.getLastName());
	super.setDOB(person.getDOB());
	this.primaryPhysician = primaryPhysician;
	this.medicalConditions = medicalConditions;
    }

    public Patient(Patient patient) {
	super(patient);

	if (patient != null) {
	    this.primaryPhysician = new Doctor(patient.primaryPhysician);
	    this.medicalConditions = new ArrayList<String>(
		    patient.medicalConditions);
	}
    }

    @Override
    public String toString() {
	StringBuilder str = new StringBuilder();

	str.append(super.toString() + "/n");
	str.append("Primary Care Physician: ");
	str.append(primaryPhysician + "/n");
	str.append("Medical Conditions: ");
	str.append(medicalConditions);

	return str.toString();
    }

    @Override
    public boolean equals(Object otherObject) {
	if (otherObject == null)
	    return false;
	else if (getClass() != otherObject.getClass())
	    return false;
	else {
	    Patient otherPatient = (Patient) otherObject;
	    return (super.equals(otherPatient)
		    && (primaryPhysician == otherPatient.primaryPhysician) && (medicalConditions == otherPatient.medicalConditions));
	}
    }

    public Doctor getPrimaryPhysician() {
	return new Doctor(primaryPhysician);
    }

    public void setPrimaryPhysician(Doctor primaryPhysician) {
	this.primaryPhysician = new Doctor(primaryPhysician);
    }

    public ArrayList<String> getMedicalConditions() {
	return medicalConditions;
    }

    public void setMedicalConditions(ArrayList<String> medicalConditions) {
	this.medicalConditions = medicalConditions;
    }

}
