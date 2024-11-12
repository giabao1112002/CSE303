package LAB4;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class EIDIVIDE {
    static StringBuilder sb = new StringBuilder();
    static InputReader reader = new InputReader(System.in);

    public static void main(String[] args) {
        long n = reader.nextLong();
        long L = reader.nextLong();
        long R = reader.nextLong();
        long maxLevel = Long.toBinaryString(n).length() - 1;
        long count = 0;

        while (maxLevel >= 0) {
            if (n % 2 == 1) {
                count += countK(maxLevel, L, R);
            }
            n = n / 2;
            maxLevel--;
        }
        System.out.println(count);
    }

    static long countK(long maxLevel, long L, long R) {
        double left = Math.pow(2, maxLevel);
        double right = Math.pow(2, maxLevel + 1);
        long kLeft = (long) Math.ceil((L - left) / right);
        long kRight = (long) Math.floor((R - left) / right);
        if (kLeft > kRight) {
            return 0;
        }
        return kRight - kLeft + 1;
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
