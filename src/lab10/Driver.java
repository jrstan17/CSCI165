package lab10;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;

public class Driver {

    private static Student[] studentArray = new Student[100];
    private static final Random RANDOM = new Random();

    public static void main(String[] args) {
	try {
	    run();
	} catch (FileNotFoundException e) {
	    e.printStackTrace();
	}
    }

    public static void run() throws FileNotFoundException {

	FileInputStream fis = new FileInputStream("src\\lab10\\MOCK_DATA.txt");
	Scanner scr = new Scanner(fis);

	int count = 0;

	while (scr.hasNextLine()) {
	    studentArray[count] = new Student();

	    studentArray[count].setFName(scr.next());
	    studentArray[count].setLName(scr.next());
	    studentArray[count].setEmail(scr.next());
	    studentArray[count].setGPA(getRandomGPA());
	    studentArray[count].setGrade(getRandomGrade());

	    studentArray[count].getAddress().setStreet(getRandomStreet());
	    studentArray[count].getAddress().setCity("Lansing");
	    studentArray[count].getAddress().setState("NY");
	    studentArray[count].getAddress().setZip(getRandomZip());

	    count++;
	}

	scr.close();

	System.out.println("Student Array Unsorted:");
	printArray();

	System.out.println("Student Array Sorted by GPA:");
	Arrays.sort(studentArray);
	printArray();

	makeFirstTwoEntriesHaveEqualValues();
	System.out
		.println("All values of studentArray[0] are now the same as studentArray[1].");
	System.out.println("studentArray[0].equals(studentArray[1]) => "
		+ studentArray[0].equals(studentArray[1]));
	System.out.println("studentArray[0] = studentArray[1]) => "
		+ equalsByReference());

    }

    private static boolean equalsByReference() {
	if (studentArray[0] == (studentArray[1])) {
	    return true;
	} else
	    return false;
    }

    private static void makeFirstTwoEntriesHaveEqualValues() {
	studentArray[1].setFName(studentArray[0].getFName());
	studentArray[1].setLName(studentArray[0].getLName());
	studentArray[1].setEmail(studentArray[0].getEmail());
	studentArray[1].setGPA(studentArray[0].getGPA());
	studentArray[1].setGrade(studentArray[0].getGrade());

	studentArray[1].getAddress().setStreet(
		studentArray[0].getAddress().getStreet());
	studentArray[1].getAddress().setCity(
		studentArray[0].getAddress().getCity());
	studentArray[1].getAddress().setState(
		studentArray[0].getAddress().getState());
	studentArray[1].getAddress().setZip(
		studentArray[0].getAddress().getZip());
    }

    private static void printArray() {
	for (int i = 0; i < studentArray.length; i++) {
	    System.out.println(studentArray[i]);
	}
    }

    private static double getRandomGPA() {

	double value = 0;

	do {
	    value = RANDOM.nextDouble();
	} while (value > 0.4);

	return value * 10;
    }

    private static Student.Grade getRandomGrade() {
	int value = RANDOM.nextInt(4) + 1;
	Student.Grade tempGrade = null;

	switch (value) {
	case 1:
	    tempGrade = Student.Grade.FR;
	    break;
	case 2:
	    tempGrade = Student.Grade.SO;
	    break;
	case 3:
	    tempGrade = Student.Grade.JR;
	    break;
	case 4:
	    tempGrade = Student.Grade.SR;
	    break;
	}

	return tempGrade;
    }

    private static String getRandomStreet() {
	int value = RANDOM.nextInt(9999) + 1;

	return value + " Main Street";
    }

    private static String getRandomZip() {
	int value = RANDOM.nextInt(99999) + 1000;

	return String.format("%05d", value);
    }

}
