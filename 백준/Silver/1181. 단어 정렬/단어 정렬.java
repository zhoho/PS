import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] slst = new String[n];

        for(int i = 0; i < n; i++) {
            slst[i] = br.readLine();
        }

        Arrays.sort(slst, new Comparator<String>() {
            public int compare(String s1, String s2) {
                if(s1.length() == s2.length()) {
                    return s1.compareTo(s2);
                }
                else {
                    return s1.length() - s2.length();
                }
            }
        });

        StringBuilder sb = new StringBuilder();
		sb.append(slst[0]).append("\n");

        for(int i = 1; i < n; i++) {
            if(!slst[i].equals(slst[i-1])) {
                sb.append(slst[i]).append("\n");
            }
        }
        System.out.println(sb);
    }
}