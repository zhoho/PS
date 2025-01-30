import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        if (n == 0) {
            System.out.println(0);
            return;
        }
        int[] ratings = new int[n];

        for (int i = 0; i < n; i++) {
            ratings[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(ratings);

        int cut = (int) Math.round(n * 0.15);
        int sum = 0;
        for (int i = cut; i < n - cut; i++) {
            sum += ratings[i];
        }

        int result = (int) Math.round((double) sum / (n - 2 * cut));
        System.out.println(result);
    }
}