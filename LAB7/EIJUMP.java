import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class EIJUMP {
    static StringBuilder sb = new StringBuilder();
    static InputReader reader = new InputReader(System.in);

    public static void main(String[] args) {
        int n = reader.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = reader.nextInt();
        }
        
        int[] jumpCount = new int[n];
        Arrays.fill(jumpCount, Integer.MAX_VALUE);
        jumpCount[0] = 0;
        

        for (int i = 0; i < n; i++) {
            if (jumpCount[i] == Integer.MAX_VALUE) continue;
            
            if (i + 1 < n) {
                jumpCount[i + 1] = Math.min(jumpCount[i + 1], jumpCount[i] + 1);
            }
            
            for (int j = i + 1; j < n; j++) {
                if (arr[i] == arr[j]) {
                    jumpCount[j] = Math.min(jumpCount[j], jumpCount[i] + 1);
                    break;
                }
            }
        }
        
        System.out.println(jumpCount[n-1]);
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
