package 백준;

import java.util.*;
import java.io.*;
import java.lang.StringBuffer;

public class b9093 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        for (int i = 0; i < num; i++) {
            String str = br.readLine();
            String[] splitstr = str.split("\\s");
            for (int j = 0; j < splitstr.length; j++) {
                StringBuilder sb = new StringBuilder(splitstr[j]);
                String reverse = sb.reverse().toString();
                System.out.print(reverse + " ");
            }
        }
    }
}
