import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class EIUBISEA2 {
    static StringBuilder sb = new StringBuilder();
    static InputReader reader = new InputReader(System.in);

        public static void main(String[] args) {
            int n = reader.nextInt();
            int m = reader.nextInt();
            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = reader.nextInt();
            }
            Arrays.sort(arr);
            for (int i = 0; i < m; i++) {
                int numFind = reader.nextInt();
                int result = Arrays.binarySearch(arr, numFind);
                if (result < 0) {
                    result = -1;
                }
                while (result > 0 && arr[result - 1] == numFind) {
                    result--;
                }
                sb.append(result + " ");
            }
            System.out.println(sb);
        }

    static class InputReader {
        StringTokenizer tokenizer;
        BufferedReader reader;
        String token;
        String temp;

        public InputReader(InputStream stream) {
            tokenizer = null;
            reader = new BufferedReader(new InputStreamReader(stream));
        }

        public InputReader(FileInputStream stream) {
            tokenizer = null;
            reader = new BufferedReader(new InputStreamReader(stream));
        }

        public String nextLine() throws IOException {
            return reader.readLine();
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    if (temp != null) {
                        tokenizer = new StringTokenizer(temp);
                        temp = null;
                    } else {
                        tokenizer = new StringTokenizer(reader.readLine());
                    }
                } catch (IOException e) {
                }
            }
            return tokenizer.nextToken();
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }
}
