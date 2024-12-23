import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class EIUDP2 {
    static StringBuilder sb = new StringBuilder();
    static InputReader reader = new InputReader(System.in);

    public static void main(String[] args) {
        try {
            int T = reader.nextInt();
            while (T-- > 0) {
                solve();
            }
            System.out.println(sb);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    static void solve() {
        int n = reader.nextInt();
        int k = reader.nextInt();
        
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = reader.nextLong();
        }

        // dp[i] represents maximum earnings up to index i
        long[] dp = new long[n + 1];
        
        // For each position, try all possible work periods ending at this position
        for (int i = 1; i <= n; i++) {
            // Don't work at this position
            dp[i] = dp[i - 1];
            
            // Try all possible work periods of length 1 to k ending at position i
            long sum = 0;
            for (int j = 0; j < k && i - j > 0; j++) {
                sum += arr[i - j - 1];
                // If we can work (have enough rest before this period)
                if (i - j - k - 1 >= 0) {
                    dp[i] = Math.max(dp[i], dp[i - j - k - 1] + sum);
                } else if (i - j - 1 == 0) {
                    // If this is the first work period
                    dp[i] = Math.max(dp[i], sum);
                }
            }
        }

        sb.append(dp[n]).append("\n");
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
