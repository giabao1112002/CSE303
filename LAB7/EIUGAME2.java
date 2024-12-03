import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class EIUGAME2 {
    static StringBuilder sb = new StringBuilder();
    static InputReader reader = new InputReader(System.in);

    public static void main(String[] args) {
        int n = reader.nextInt();
        int m = reader.nextInt();
        
        long[][] matrix = new long[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = reader.nextLong();
            }
        }
        
        long[][] temp = new long[n][m];
        
        temp[0][0] = matrix[0][0];
        
        for (int j = 1; j < m; j++) {
            temp[0][j] = temp[0][j-1] + matrix[0][j];
        }
        
        for (int i = 1; i < n; i++) {
            temp[i][0] = temp[i-1][0] + matrix[i][0];
        }
        
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                temp[i][j] = Math.max(temp[i-1][j], temp[i][j-1]) + matrix[i][j];
            }
        }
        
        System.out.println(temp[n-1][m-1]);
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
