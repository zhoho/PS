import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        for(int i = 0; i < m; i++) {
            // a부터 b까지 c를 채운다
            String input = br.readLine();
            StringTokenizer bs = new StringTokenizer(input);
            int a = Integer.parseInt(bs.nextToken()) - 1;
            int b = Integer.parseInt(bs.nextToken());
            int c = Integer.parseInt(bs.nextToken());
            for(int j = a; j < b; j++) {
                arr[j] = c;
            }
        }
        // System.out.println(Arrays.toString(arr));
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
