package pps.week1.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class c027 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();

        StringTokenizer st = new StringTokenizer(in.readLine());
        int E = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int e = 1;
        int s = 1;
        int m = 1;
        int check = 1;
        while (true) {
            if (e > 15) {
                e = 1;
            }
            if (s > 28) {
                s = 1;
            }
            if (m > 19) {
                m = 1;
            }
            if (e == E && s == S && m == M) {
                break;
            }
            e++;
            s++;
            m++;
            check++;
        }
        System.out.println(check);
    }
}
