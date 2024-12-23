package LAB3;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class EIUSUBSET {
    public static void main(String[] args) {
        Reader reader = new Reader(System.in);
        StringBuilder stringBuilder = new StringBuilder();
        
        int n = reader.nextInt();
        List<String> set = new ArrayList<>();

        for (int i = 0; i <n; i++) {
            set.add(reader.next());
        
        }
        
        List<String> rs = new ArrayList<>(); 
        rs.add(""); 
        Collections.reverse(set); 

        for (String m : set) { 
            List<String> temp = new ArrayList<>(); 
            for (String num : rs) {
                if (num.length() == 0)
                    temp.add(m + num);
                else
                    temp.add(m + " " + num);
            }
            rs.addAll(temp); 
        }
        rs.remove(0); 
        stringBuilder.append(rs.size()).append('\n'); 
       

        for (String string : rs) {
            stringBuilder.append(string).append('\n'); 
        }

        System.out.print(stringBuilder);
    }
}

class Reader {
    StringTokenizer tokenizer;
    BufferedReader reader;
    String token;
    String temp;

    public Reader(InputStream stream) {
        tokenizer = null;
        reader = new BufferedReader(new InputStreamReader(stream));
    }

    public Reader(FileInputStream stream) {
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
