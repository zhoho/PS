package 백준;

import java.util.Arrays;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class b10989 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int num = Integer.parseInt(br.readLine());
        int[] intArray = new int[num];

        for (int i = 0; i < num; i++) {
            intArray[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(intArray);

        for (int i = 0; i < num; i++) {
            sb.append(intArray[i]).append('\n');
        }
        System.out.println(sb);
    }
}
