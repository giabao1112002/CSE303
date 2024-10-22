package LAB2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class EIPAIR {
    static StringBuilder sb = new StringBuilder();
    static InputReader reader = new InputReader(System.in);

    public static void main(String[] args) {
        reader = new InputReader(System.in);
        int testcase = reader.nextInt();
        for (int i = 0; i < testcase; i++) {
            Map<Integer, Integer> map = new HashMap<>();
            int numGifts = reader.nextInt();

            for (int j = 0; j < numGifts; j++) {
                int price = reader.nextInt();
                map.put(price, map.getOrDefault(price, 0) + 1);
            }
            long count = 0;
            for (long count1 : map.values()) {
                count += (count1 * (count1 - 1)) / 2;
            }
            sb.append(count).append("\n");
        }
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
