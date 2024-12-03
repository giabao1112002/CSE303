import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class EIULOGGING2 {
    static StringBuilder sb = new StringBuilder();
    static InputReader reader = new InputReader(System.in);

    public static void main(String[] args) {
        int n = reader.nextInt();
        long[] trees = new long[n];
        
        // Read tree values
        for (int i = 0; i < n; i++) {
            trees[i] = reader.nextLong();
        }
        
        // dp[i] represents the maximum money that can be earned up to index i
        long[] dp = new long[n];
        
        // Base cases
        if (n >= 1) dp[0] = Math.max(0, trees[0]);
        if (n >= 2) dp[1] = Math.max(dp[0], Math.max(0, trees[1]));
        if (n >= 3) dp[2] = Math.max(dp[1], Math.max(0, trees[2]));
        
        // Fill dp array
        for (int i = 3; i < n; i++) {
            // Don't cut current tree
            dp[i] = dp[i-1];
            
            // Cut current tree if profitable
            if (trees[i] > 0) {
                dp[i] = Math.max(dp[i], dp[i-3] + trees[i]);
            }
        }
        
        System.out.println(dp[n-1]);
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
