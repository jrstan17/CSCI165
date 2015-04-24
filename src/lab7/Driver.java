package lab7;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Driver {

    public static void main(String[] args) throws FileNotFoundException {
	Doctor doctor = new Doctor();
	doctor.setName("Jason Stanley");
	doctor.setHireDate(new Date(12, 30, 2001));
	doctor.setOfficeVisitFee(160);
	doctor.setSpeciality("Idiocy");
	doctor.setSalary(250000);

	ArrayList<Visit> visits = new ArrayList<Visit>();

	FileInputStream fis = new FileInputStream("visits.txt");
	Scanner scr = new Scanner(fis);

	while (scr.hasNextLine()) {
	    Visit temp = new Visit();

	    String fName = scr.next();
	    String lName = scr.next();

	    temp.getPatient().setName(fName, lName);

	    String dateStr = scr.next();
	    setPatientDOB(temp, dateStr);

	    String symptomToken = scr.nextLine();
	    symptomToken = scr.nextLine();
	    addSymptoms(temp, symptomToken);

	    temp.setDoctor(doctor);

	    GregorianCalendar gc = new GregorianCalendar();
	    Date date = new Date(gc.get(Calendar.MONTH) + 1,
		    gc.get(Calendar.DATE), gc.get(Calendar.YEAR));
	    temp.setDate(date);

	    visits.add(temp);
	}

	printVisits(visits);
	scr.close();
    }

    private static void printVisits(ArrayList<Visit> visits) {
	for (Visit v : visits) {
	    System.out.println(v);
	}
    }

    private static void setPatientDOB(Visit temp, String dateStr) {

	ArrayList<Integer> intArray = new ArrayList<Integer>();
	String str = "";

	for (int i = 0; i < dateStr.length(); i++) {

	    if (dateStr.charAt(i) != '/') {
		str += dateStr.charAt(i);
	    } else {
		intArray.add(Integer.parseInt(str));
		str = "";
	    }
	}

	intArray.add(Integer.parseInt(str));

	Date newDate = new Date(intArray.get(0), intArray.get(1),
		intArray.get(2));

	temp.getPatient().setDOB(newDate);
    }

    private static void addSymptoms(Visit temp, String symptomToken) {
	String str = "";
	for (int i = 0; i < symptomToken.length(); i++) {
	    if (!Character.isSpaceChar(symptomToken.charAt(i))) {
		str += symptomToken.charAt(i);
	    } else {
		temp.addSymptom(str);
		str = "";
	    }
	}
	
	if (!str.isEmpty()) {
	    temp.addSymptom(str);
	}
    }
}
