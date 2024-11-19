import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class EIAPPLEBOX {
    static StringBuilder sb = new StringBuilder();
    static InputReader reader = new InputReader(System.in);

    public static void main(String[] args) {

        int T = reader.nextInt();

        long[] results = new long[T];

        for (int t = 0; t < T; t++) {
            int N = reader.nextInt();
            int A = reader.nextInt();
            int P = reader.nextInt();

            results[t] = countInversions(N, A, P);
        }

        for (long result : results) {
            sb.append(result+"\n");
        }
        System.out.println(sb);

    }

    private static long countInversions(int N, int A, int P) {
        long[] array = new long[N];

        array[0] = (long) (A * A) % P;
        for (int i = 1; i < N; i++) {
            array[i] = (array[i - 1] * A) % P;
        }

        long count = 0;
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (array[i] > array[j]) {
                    count++;
                }
            }
        }

        return count;
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
