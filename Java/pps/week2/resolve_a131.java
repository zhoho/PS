// package pps.week1.week2;

// import java.io.BufferedReader;
// import java.io.IOException;
// import java.io.InputStreamReader;
// import java.util.Arrays;

// public class a131 {
// public static void main(String[] args) throws NumberFormatException,
// IOException {
// BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
// StringBuilder out = new StringBuilder();
// int n = Integer.parseInt(in.readLine());
// int[] arr = new int[n];
// int sum = 0;
// for (int i = 0; i < n; i++) {
// arr[i] = Integer.parseInt(in.readLine());
// sum += arr[i];
// }
// int aver = (int) Math.round((double) sum / n);
// Arrays.sort(arr);
// int mid = arr[n / 2];
// int range = arr[n - 1] - arr[0];
// System.out.println("aver : " + aver + " mid : " + mid + " range : " + range);
// }
// }
