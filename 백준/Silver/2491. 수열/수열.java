
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] list = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }

        int upMax = 1, downMax = 1;
        int upCount = 1, downCount = 1;

        for(int i = 1; i < n; i++) {
            if (list[i] >= list[i - 1]) {
                upCount++;
            } else {
                upMax = Math.max(upMax, upCount);
                upCount = 1;
            }

            if (list[i] <= list[i - 1]) {
                downCount++;
            } else {
                downMax = Math.max(downMax, downCount);
                downCount = 1;
            }
        }

        upMax = Math.max(upMax, upCount);
        downMax = Math.max(downMax, downCount);

        System.out.println(Math.max(upMax, downMax));
    }
}