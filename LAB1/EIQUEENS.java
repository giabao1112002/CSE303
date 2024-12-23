import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

class EIQUEEN {
    static StringBuilder sb = new StringBuilder();
    static InputReader reader = new InputReader(System.in);

    public static void main(String[] args) throws IOException {
        char[][] board = new char[8][8];

        for (int i = 0; i < 8; i++) {
            board[i] = reader.nextLine().toCharArray();
        }

        Set<Integer> columns = new HashSet<>();
        Set<Integer> majorDiagonals = new HashSet<>();
        Set<Integer> minorDiagonals = new HashSet<>();

        for (int row = 0; row < 8; row++) {
            int queensInRow = 0; //
            for (int col = 0; col < 8; col++) {
                if (board[row][col] == '*') {
                    queensInRow++;

                    if (columns.contains(col)) {
                        System.out.println("invalid");
                        return;
                    }

                    int majorDiag = row - col;
                    int minorDiag = row + col;
                    if (majorDiagonals.contains(majorDiag) || minorDiagonals.contains(minorDiag)) {
                        System.out.println("invalid");
                        return;
                    }

                    columns.add(col);
                    majorDiagonals.add(majorDiag);
                    minorDiagonals.add(minorDiag);
                }
            }
            if (queensInRow != 1) {
                System.out.println("invalid");
                return;
            }
        }

        System.out.println("valid");
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