// 투포인터 문제
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();

        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(in.readLine());
        int[] arr = new int[n + 1];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int start = 0;
        int end = 0;
        int sum = 0;
        int len = 0;
        int ans = Integer.MAX_VALUE;

        while (end <= n) {
            if (sum >= s) {
                sum -= arr[start++];
                len = end - start + 1;
                if (ans > len) {
                    ans = len;
                }
            } else if (sum < s) {
                sum += arr[end++];
            }
        }
        if (ans == Integer.MAX_VALUE)
            System.out.println("0");
        else
            System.out.println(ans);
    }
}
