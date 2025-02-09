import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] paper = new int[100][100];
        int count = 0;

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            for(int j = a; j < a + 10; j++) {
                for(int k = b; k < b + 10; k++) {
                    if(paper[j][k] != 1) {
                        paper[j][k] += 1;
                        count++;
                    }
                }
            }
        }
        System.out.println(count);
    }
}