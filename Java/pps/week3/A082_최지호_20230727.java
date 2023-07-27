package pps.week3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class A082_최지호_20230727 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[][] arr = new String[n][2];
        // 2중 배열 만들어 나이와 이름 입력받기
        for (int i = 0; i < n; i++) {
            arr[i][0] = in.next();
            arr[i][1] = in.next();
        }
        // 나이순으로 정렬
        Arrays.sort(arr, new Comparator<String[]>() {
            public int compare(String[] s1, String[] s2) {
                return Integer.parseInt(s1[0]) - Integer.parseInt(s2[0]);
            }
        });
        // 정답 출력
        for (int i = 0; i < n; i++) {
            System.out.println(arr[i][0] + " " + arr[i][1]);
        }
    }
}
