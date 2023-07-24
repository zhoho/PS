package pps.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class C033_최지호_20230724 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        float rice = Integer.parseInt(st.nextToken());
        float price = Integer.parseInt(st.nextToken());
        float min = rice / price;
        int n = Integer.parseInt(in.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st1 = new StringTokenizer(in.readLine());
            float rice1 = Integer.parseInt(st1.nextToken());
            float price1 = Integer.parseInt(st1.nextToken());
            float tmp = rice1 / price1;
            if (min > tmp)
                min = tmp;
        }
        System.out.println(min);
        System.out.println(String.format("%.2f", min * 1000));
    }
}
