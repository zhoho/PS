import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int sum = Integer.MAX_VALUE;
        StringTokenizer st = new StringTokenizer(in.readLine(), "-");

        while (st.hasMoreTokens()) {
            int tmp = 0;
            StringTokenizer addst = new StringTokenizer(st.nextToken(), "+");

            while (addst.hasMoreTokens()) {
                tmp += Integer.parseInt(addst.nextToken());
            }
            if (sum == Integer.MAX_VALUE) {
                sum = tmp;
            } else {
                sum -= tmp;
            }
        }
        System.out.println(sum);
    }
}
