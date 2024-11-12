package LAB4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class PowerMod {
    static InputReader reader = new InputReader(System.in);

    public static void main(String[] args) {
        long x = reader.nextLong();
        long n = reader.nextLong();
        long k = reader.nextLong();

        long result = modPower(x, n, k);

        System.out.println(result);

    }

    public static long modPower(long x, long n, long k) {
        long result = 1;
        x = x % k;

        while (n > 0) {
            if ((n & 1) == 1) {
                result = (result * x) % k;
            }
            n = n >> 1;
            x = (x * x) % k;
        }
        return result;
    }

}

class InputReader {
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
