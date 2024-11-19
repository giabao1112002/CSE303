import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class EIUMEDARRAY4 {
    static StringBuilder sb = new StringBuilder();
    static InputReader reader = new InputReader(System.in);

    public static void main(String[] args) {

        int T = reader.nextInt();

        for (int t = 0; t < T; t++) {
            int N = reader.nextInt();
            long A = reader.nextLong();
            long P = reader.nextLong();
            long K = reader.nextLong();

            long result = SmallestElement(N, A, P, K);
            sb.append(result+"\n");
        }
        System.out.println(sb);

    }

    private static long SmallestElement(int N, long A, long P, long K) {
        long[] array = new long[N];

        array[0] = (A * A) % P;

        for (int i = 1; i < N; i++) {
            array[i] = (array[i - 1] * A) % P;
        }

        java.util.Arrays.sort(array);

        return array[(int) (K - 1)];
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
