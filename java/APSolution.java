import java.io.*;

public class APSolution {
    public static void main(String args[] ) throws Exception {
        try (BufferedReader br = new BufferedReader (new InputStreamReader (System.in))) {
            final int totalNumbersInSeries = Integer.parseInt (br.readLine ());
            String[] numArr = br.readLine ().split (" ");
            int[] numbers = new int[totalNumbersInSeries];

            for (int i = 0; i < numArr.length; i++)
            	numbers[i] = Integer.parseInt (numArr [i]);

			int rangeDiff = 0, prevDiff = 0;

            for (int i = 0, j = 1; i < totalNumbersInSeries && j < totalNumbersInSeries; i++, j++) {
					if (i == j) {
						break;
					}

					rangeDiff = numbers[j] - numbers[i];
					System.out.println ("Diff: " + rangeDiff);

					if (rangeDiff > prevDiff && prevDiff != 0) {
						System.out.println ("Missing Number: " + (numbers[i] + prevDiff));
					}
				//System.out.println ("Series: " + numbers[i]);
					prevDiff = rangeDiff;
            }
        } catch (IOException ioe) {
            ioe.printStackTrace ();
        }
    }
}