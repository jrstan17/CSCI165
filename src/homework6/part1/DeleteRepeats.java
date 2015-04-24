package homework6.part1;

public class DeleteRepeats {

    private final static int LENGTH = 12;

    public static void main(String[] args) {
	char[] a = new char[LENGTH];
	int size = 0;

	a[0] = 'a';
	a[1] = 'a';
	a[2] = 'b';
	a[3] = 'c';
	a[4] = 'b';
	a[5] = 'b';
	a[6] = 'd';
	a[7] = 'c';
	a[8] = 'b';
	size = 9;

	fillNullValues(a, size);

	System.out.println("Original Array:");
	printArray(a);
	System.out.println("  Size: " + size);
	System.out.println("");

	size = deleteRepeats(a, size);

	System.out.println("Repeats Removed:");
	printArray(a);
	System.out.println("  Size: " + size);
	System.out.println("");
    }

    private static void fillNullValues(char[] a, int i) {
	for (; i < a.length; i++) {
	    a[i] = ' ';
	}
    }

    public static int deleteRepeats(char[] a, int size) {
	for (int i = 0; i < size; i++) {
	    for (int j = i + 1; j < size; j++) {
		if (a[i] == a[j]) {
		    moveElementsOver(a, size, j);
		    j--;
		    size--;
		}
	    }
	}
	return size;
    }

    private static void moveElementsOver(char[] a, int size, int location) {
	for (; location < size; location++) {
	    a[location] = a[location + 1];
	}
    }

    private static void printArray(char[] a) {
	System.out.print("[ ");

	for (int i = 0; i < a.length; i++) {
	    System.out.print(a[i]);
	    
	    if (i == a.length - 1) {
		System.out.print(" ]");
	    } else {
		System.out.print(", ");
	    }
	}
    }

}
