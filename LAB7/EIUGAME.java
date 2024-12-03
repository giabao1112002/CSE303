import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class EIUGAME {
    static StringBuilder sb = new StringBuilder();
    static InputReader reader = new InputReader(System.in);

    public static void main(String[] args) {
        int n = reader.nextInt();
        int m = reader.nextInt();
        
        // Read the matrix
        long[][] matrix = new long[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = reader.nextLong();
            }
        }
        
        // DP array to store maximum sum paths
        long[][] dp = new long[n][m];
        
        // Initialize first cell
        dp[0][0] = matrix[0][0];
        
        // Fill first row
        for (int j = 1; j < m; j++) {
            dp[0][j] = dp[0][j-1] + matrix[0][j];
        }
        
        // Fill first column
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i-1][0] + matrix[i][0];
        }
        
        // Fill rest of the dp array
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]) + matrix[i][j];
            }
        }
        
        // Print the result
        System.out.println(dp[n-1][m-1]);
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
