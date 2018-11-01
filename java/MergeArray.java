import java.util.Arrays;

public class MergeArray {
    public static void merge (int[] arrA, int[] arrB) {
        Arrays.sort (arrA);
        Arrays.sort (arrB);

        int m = arrA.length, n = arrB.length;
        int i = 0, j = 0, k = 0;
        int[] arrC = new int [m + n];

        while (i < m && j < n) {
            if (arrA [i] == arrB [j]) {
                arrC [k] = arrA [i];
                i++;
                j++;
            } else if (arrA [i] < arrB [j]) {
                arrC [k] = arrA [i];
                i++;
            } else {
                arrC [k] = arrB [j];
                j++;
            }

			k++;
        }

        if (i < m) {
            for (int p = i; p < m; p++) {
                arrC [k] = arrA [p];
                k++;
            }
        } else {
            for (int p = j; p < n; p++) {
                arrC [k] = arrB [p];
                k++;
            }
        }

        System.out.println ("Merged Array: " + Arrays.toString (arrC));
    }

    public static void main (String[] args) {
        int[] arrA = {22, -1, 0, 100, 2};
        int[] arrB = {8, 3, 2, 3, 7, 5};

        merge (arrA, arrB);
    }
}