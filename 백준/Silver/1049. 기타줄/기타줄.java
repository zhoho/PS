import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] six_package = new int[m];
        int[] single = new int[m];
        for (int i = 0; i < m; i++) {
            StringTokenizer st1 = new StringTokenizer(in.readLine());
            six_package[i] = Integer.parseInt(st1.nextToken());
            single[i] = Integer.parseInt(st1.nextToken());
        }
        Arrays.sort(six_package);
        Arrays.sort(single);

        int min_pack = six_package[0];
        int min_sing = single[0];
        int res = 0;
        while (n >= 1) {
            if (n <= 6) {
                if (n * min_sing < min_pack) {
                    res += n * min_sing;
                } else {
                    res += min_pack;
                }
                break;
            } else {
                if (min_pack < min_sing * 6) {
                    res += min_pack;
                    n -= 6;
                } else {
                    res += min_sing * 6;
                    n -= 6;
                }
            }
        }
        System.out.println(res);
    }
}
