package LAB8;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class EITHIEF2 {
    static StringBuilder sb = new StringBuilder();
    static InputReader reader = new InputReader(System.in);

    public static void main(String[] args) {
        int N = reader.nextInt();
        int P = reader.nextInt();
        Item[] stItems = new Item[N];
        
        for (int i = 0; i < N; i++) {
            int weight = reader.nextInt();
            int value = reader.nextInt();
            stItems[i] = new Item(weight, value);
        }

        int maxValue = knapsack(stItems, N, P);
        System.out.println(maxValue);
    }

    private static int knapsack(Item[] items, int n, int capacity) {
        int[] dp = new int[capacity + 1];

        for (int i = 0; i < n; i++) {
            for (int w = capacity; w >= items[i].weight; w--) {
                dp[w] = Math.max(dp[w], dp[w - items[i].weight] + items[i].value);
            }
        }

        return dp[capacity];
    }

    static class Item {
        int weight;
        int value;

        public Item(int weight, int value) {
            this.value = value;
            this.weight = weight;
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
