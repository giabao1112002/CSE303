import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

class EIUGIFT1 {
    static StringBuilder sb = new StringBuilder();
    static InputReader reader = new InputReader(System.in);

    public static void main(String[] args) {
        int n = reader.nextInt();
        int m = reader.nextInt();
        int[] gifts = new int[n];
        int[] papers = new int[m];
        for (int i = 0; i < n; i++) {
            gifts[i] = reader.nextInt();
        }
        for (int i = 0; i < m; i++) {
            papers[i] = reader.nextInt();
        }
        Arrays.sort(gifts);
        Arrays.sort(papers);
        int i = 0, j = 0, count = 0;
        while (i < n && j < m) {
            if (papers[j] >= 2 * gifts[i] && papers[j] <= 3 * gifts[i]) {
                count++;
                i++;
                j++;
            } else if (papers[j] < 2 * gifts[i]) {
                j++;
            } else {
                i++;
            }
        }
        System.out.println(count);
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