package lab7;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Visit {
    private Date date;
    private Doctor doctor;
    private Patient patient;
    private ArrayList<String> symptoms;

    public Visit() {
	super();
	this.date = new Date();
	this.doctor = new Doctor();
	this.patient = new Patient();
	this.symptoms = new ArrayList<String>();
    }

    public Visit(Date date, Doctor doctor, Patient patient,
	    ArrayList<String> symptoms) {
	this.date = new Date(date);
	this.doctor = new Doctor(doctor);
	this.patient = new Patient(patient);
	this.symptoms = symptoms;
    }

    public Visit(Visit visit) {
	if (visit != null) {
	    this.date = visit.date;
	    this.doctor = visit.doctor;
	    this.patient = visit.patient;
	    this.symptoms = visit.symptoms;
	}
    }

    @Override
    public String toString() {
	DecimalFormat df = new DecimalFormat("##.00");
	StringBuilder str = new StringBuilder();

	str.append("Date: ");
	str.append(date + "\n");
	
	str.append("Patient: ");
	str.append(patient.getFirstName() + " " + patient.getLastName() + "\n");
	
	str.append("Doctor: ");
	str.append(doctor.getName() + "\n");
	
	str.append("Office Visit Fee: ");
	str.append("$" + df.format(doctor.getOfficeVisitFee()) + "\n");	
	
	str.append("Symptoms of Patient: ");
	str.append(symptoms + "\n");

	return str.toString();
    }

    public boolean equals(Object otherObject) {
	if (otherObject == null)
	    return false;
	else if (getClass() != otherObject.getClass())
	    return false;
	else {
	    Visit otherVisit = (Visit) otherObject;
	    return ((date == otherVisit.date) && (doctor == otherVisit.doctor)
		    && (patient == otherVisit.patient) && (symptoms == otherVisit.symptoms));
	}
    }

    public Date getDate() {
	return date;
    }

    public void setDate(Date date) {
	this.date = date;
    }

    public Doctor getDoctor() {
	return new Doctor(doctor);
    }

    public void setDoctor(Doctor doctor) {
	this.doctor = doctor;
    }

    public Patient getPatient() {
	return patient;
    }

    public void setPatient(Patient patient) {
	this.patient = patient;
    }

    public ArrayList<String> getSymptoms() {
	return new ArrayList<String>(symptoms);
    }

    public void addSymptom(String str) {
	symptoms.add(str);
    }

}
