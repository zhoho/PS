import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }

        for(int i = 0; i < m; i++) {
            String input = br.readLine();
            StringTokenizer ba = new StringTokenizer(input);

            int a = Integer.parseInt(ba.nextToken()) - 1;
            int b = Integer.parseInt(ba.nextToken()) - 1;
        
            while (a < b) {
                int tmp = arr[a];
                arr[a] = arr[b];
                arr[b] = tmp;
                a++;
                b--;
            }
        }
        // System.out.println(Arrays.toString(arr));
        for(int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}