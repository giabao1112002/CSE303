import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class EIPAGES {
    static InputReader reader;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        reader = new InputReader(System.in);
        int N = reader.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = reader.nextInt();
        }
        Arrays.sort(arr);
        int pageOri = arr[0];
        int pageNext = arr[0];
        for (int i = 1; i < N; i++) {
            if (arr[i] == pageNext + 1) {
                pageNext = arr[i];
            } else {
                if (pageOri == pageNext) {
                    sb.append(pageOri).append(" ");
                } else if (pageNext - pageOri == 1) {
                    sb.append(pageOri + " " + pageNext + " ");
                } else {
                    sb.append(pageOri + "-" + pageNext + " ");
                }
                pageOri = arr[i];
                pageNext = arr[i];
            }

        }
        if (pageOri == pageNext) {
            sb.append(pageOri).append(" ");
        } else if (pageNext - pageOri == 1) {
            sb.append(pageOri).append(" ").append(pageNext).append(" ");
        } else {
            sb.append(pageOri).append("-").append(pageNext).append(" ");
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
