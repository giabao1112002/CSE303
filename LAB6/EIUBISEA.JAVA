import java.util.Arrays;
import java.util.Scanner;

class EIUBISEA {
    static Scanner myScanner = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int n = myScanner.nextInt();
        int m = myScanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = myScanner.nextInt();
        }

        Arrays.sort(arr);

        for (int i = 0; i < m; i++) {
            int numFind = myScanner.nextInt();
            int result = BinarySearch(arr, numFind);
            sb.append(result + " ");
        }
        System.out.println(sb);

    }

    static int BinarySearch(int[] arr, int numFind) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int middle = start + (end - start) / 2;
            if (arr[middle] == numFind) {
                while (middle > 0 && arr[middle - 1] == numFind) {
                    middle--;
                }
                return middle;
            }

            if (arr[middle] < numFind) {
                start = middle + 1;
            } else {
                end = middle - 1;
            }
        }
        return -1;
    }
}
