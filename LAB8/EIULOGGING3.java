package LAB8;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class EIULOGGING3 {
    static StringBuilder sb = new StringBuilder();
    static InputReader reader = new InputReader(System.in);
    static final int MOD = 1000000007;

    public static void main(String[] args) {
        int n = reader.nextInt();
        long[] trees = new long[n];

        for (int i = 0; i < n; i++) {
            trees[i] = reader.nextLong();
        }

        long[] maxValue = new long[n];
        long[] ways = new long[n];

        maxValue[0] = Math.max(0, trees[0]);
        
        

        if (n > 1) {
            maxValue[1] = Math.max(maxValue[0], Math.max(0, trees[1]));
            ways[1] = 1;
        }

        for (int i = 2; i < n; i++) {
            if (maxValue[i - 1] > maxValue[i - 2] + trees[i]) {
                maxValue[i] = maxValue[i - 1];
                ways[i] = ways[i - 1];
            } else if (maxValue[i - 1] < maxValue[i - 2] + trees[i]) {
                maxValue[i] = maxValue[i - 2] + trees[i];
                ways[i] = ways[i - 2];
            } else {
                maxValue[i] = maxValue[i - 1];
                ways[i] = (ways[i - 1] + ways[i - 2]) % MOD;
            }
        }

        sb.append(maxValue[n - 1]).append(" ").append(ways[n - 1]);
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
