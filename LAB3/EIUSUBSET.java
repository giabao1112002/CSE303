package LAB3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.TreeSet;
import java.util.StringTokenizer;

class EIUSUBSET {
    static StringBuilder sb = new StringBuilder();
    static InputReader reader = new InputReader(System.in);

    public static void main(String[] args) {
        String line = reader.next();
        TreeSet<String> mySet = new TreeSet<String>();
        mySet.add("");

        for (int i = 0; i < line.length(); i++) {
            TreeSet<String> set = new TreeSet<String>();
            for (String string : mySet) {
                for (int j = 0; j <= string.length(); j++) {
                    String newLine = string.substring(0, j) + line.charAt(i) + string.substring(j);
                    set.add(newLine);
                }
            }
            mySet = set;
        }

        sb.append(mySet.size() + "\n");
        for (String output : mySet) {
            sb.append(output + "\n");
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
