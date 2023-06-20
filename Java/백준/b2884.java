package 백준;

import java.util.Scanner;

public class b2884 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int hour = in.nextInt();
        int min = in.nextInt();
        if (min < 45) {
            min += 15;
            hour--;
            if (hour < 0) {
                hour = 23;
            }
        } else {
            min -= 45;
        }
        System.out.println(hour + " " + min);
    }
}
