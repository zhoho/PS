package 백준;

import java.util.Scanner;

public class b4344 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int C = in.nextInt();
        for (int i = 0; i < C; i++) {
            int N = in.nextInt();
            int[] arr = new int[N];
            double sum = 0;
            for (int j = 0; j < N; j++) {
                int score = in.nextInt();
                arr[j] = score;
                sum += score;
            }

            double mean = sum / N;
            double overmean = 0;

            for (int j = 0; j < N; j++) {
                if (arr[j] > mean)
                    overmean++;
            }

            System.out.printf("%.3f%%\n", (overmean / N) * 100);
        }
        in.close();
    }
}
