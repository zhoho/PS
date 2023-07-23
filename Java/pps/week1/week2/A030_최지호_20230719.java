package pps.week1.week2;

import java.util.*;
import java.io.*;

public class a030 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();

        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        double feel = Integer.parseInt(st.nextToken());
        double[] arr = Arrays.stream(in.readLine().split(" ")).mapToDouble(Double::parseDouble).toArray();

        feel = (1 - feel) * 1000;
        // System.out.println(M);

        for (int i = 0; i < n; i++) {
            feel = feel * arr[0] + (1000 - feel) * arr[2];
        }

        System.out.println(String.format("%.0f", feel));
        System.out.println(String.format("%.0f", 1000 - feel));
    }
}