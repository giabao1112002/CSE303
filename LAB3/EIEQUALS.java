package LAB3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class EIEQUALS {
    static StringBuilder sb = new StringBuilder();
    static InputReader reader = new InputReader(System.in);

    public static void main(String[] args) {
        int n = reader.nextInt();
        int k = reader.nextInt();
        int totalA = 0;
        int totalB = 0;
        int count = 0;
        int[] arrA = new int[n];
        int[] arrB = new int[n];

        for (int i = 0; i < n; i++) {
            int temp = reader.nextInt();
            arrA[i] = temp;
            totalA += temp;
        }

        for (int i = 0; i < n; i++) {
            int temp = reader.nextInt();
            arrB[i] = temp;
            totalB += temp;
        }
        Arrays.sort(arrA);
        Arrays.sort(arrB);

        if (Math.abs(totalA - totalB) > k) {
            System.out.println("NO");
        } else {
            int i = 0, j = 0;
            while (i < n && j < n) {
                if (arrA[i] == arrB[j]) {
                    i++;
                    j++;
                } else if (arrA[i] < arrB[j]) {
                    i++;
                    count++;
                } else {
                    j++;

                }
            }
            if (count > 1) {
                System.out.println("NO");
            } else {
                System.out.println("YES");

            }

        }

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
