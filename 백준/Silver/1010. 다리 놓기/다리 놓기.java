import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t; i++) {
            String input = br.readLine();
            StringTokenizer st = new StringTokenizer(input);
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            //nNm 구하기 조합구하기
            int tmp = m - n;
            BigInteger sum_up = BigInteger.ONE;
            BigInteger sum_down = BigInteger.ONE;
            for (int j = tmp + 1; j <= m; j++) {
                sum_up = sum_up.multiply(BigInteger.valueOf(j));
            }
            for (int k = 1; k <= n; k++) {
                sum_down = sum_down.multiply(BigInteger.valueOf(k));
            }
            System.out.println(sum_up.divide(sum_down));
        }
    }
}
