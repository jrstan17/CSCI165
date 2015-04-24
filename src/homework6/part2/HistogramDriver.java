package homework6.part2;

public class HistogramDriver {

    public static void main(String[] args) {
	Histogram histogram = new Histogram();
	int[][] test = histogram.getHistorgramArray();

	System.out.println("    N   Count");
	System.out.println("");

	for (int i = histogram.getRowCount() - 1; i >= 0; i--) {
	    for (int j = 0; j < histogram.getColumnCount(); j++) {
		System.out.printf("%5d", test[i][j]);
	    }
	    System.out.println("");
	}
    }
}
