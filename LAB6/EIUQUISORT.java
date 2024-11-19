import java.util.*;

class EIUQUISORT {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int testCase = myScanner.nextInt();
        int[] arr = new int[testCase];
        for (int i = 0; i < testCase; i++) {
            arr[i] = myScanner.nextInt();
        }
        myScanner.close();
        Quicksort(arr, 0, testCase - 1);
        for (int number : arr) {
            sb.append(number).append("\n");
        }
        System.out.print(sb);

    }

    static void Quicksort(int[] arr, int start, int end) {
        if (start < end) {
            int MiddleIndex = Partition(arr, start, end);
            Quicksort(arr, start, MiddleIndex - 1);
            Quicksort(arr, MiddleIndex + 1, end);
        }

    }

    static int Partition(int[] arr, int start, int end) {
        int pivot = arr[start];
        int i = start + 1;
        int j = start + 1;
        while (j <= end) {
            if (arr[j] <= pivot) {
                swap(arr, i, j);
                i++;
            }
            j++;
        }
        swap(arr, start, i - 1);
        return i - 1;
    }

    private static void swap(int[] arr, int i, int j) { 
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
