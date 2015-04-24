package homework6.part2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Histogram {

    private int[] integerArray;
    private int[][] historgramArray;
    private int numberOfLines = 0;
    private int uniqueIntegers = 1;
    private Scanner scr;

    private final int NUM_COL_HISTOGRAM_ARRAY = 2;

    public Histogram() {
	createSortedArray();
	createHistogramArray();
    }

    private Scanner fillScanner() {
	File file = new File("integers.txt");
	FileInputStream fis;
	try {
	    fis = new FileInputStream(file);
	    scr = new Scanner(fis);
	} catch (FileNotFoundException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	return scr;
    }

    private void createHistogramArray() {
	int count = 1;
	int histogramArrayRow = 0;

	// find number of unique integers
	for (int i = 0; i < integerArray.length - 1; i++) {
	    if (integerArray[i] != integerArray[i + 1]) {
		uniqueIntegers++;
	    }
	}

	// create histogram based on the number of unique integers
	historgramArray = new int[uniqueIntegers][NUM_COL_HISTOGRAM_ARRAY];

	// fill first element of histogram
	historgramArray[0][0] = integerArray[0];

	// * traverse integer array
	// * if the next element and current element are the same, increase the
	// count
	// * if they aren't, begin next unique integer and reset count
	for (int i = 0; i < integerArray.length; i++) {
	    if (i != integerArray.length - 1) {
		if (integerArray[i] == integerArray[i + 1]) {
		    count++;
		} else {
		    historgramArray[histogramArrayRow][1] = count;

		    histogramArrayRow++;

		    historgramArray[histogramArrayRow][0] = integerArray[i + 1];

		    count = 1;
		}
	    } else {
		historgramArray[histogramArrayRow][1] = count;
	    }
	}
    }

    private void createSortedArray() {
	scr = this.fillScanner();

	while (scr.hasNextLine()) {
	    numberOfLines++;
	    
	    @SuppressWarnings("unused")
	    String str = scr.nextLine();
	}

	integerArray = new int[numberOfLines];
	fillArray();
	SelectionSort.sort(integerArray, numberOfLines);
    }

    private void fillArray() {
	scr = this.fillScanner();

	for (int i = 0; i < numberOfLines; i++) {
	    integerArray[i] = scr.nextInt();
	}
    }

    public int[][] getHistorgramArray() {
	return historgramArray;
    }

    public void setHistorgramArray(int[][] historgramArray) {
	this.historgramArray = historgramArray;
    }

    public int getRowCount() {
	return uniqueIntegers;
    }

    public int getColumnCount() {
	return NUM_COL_HISTOGRAM_ARRAY;
    }

}
