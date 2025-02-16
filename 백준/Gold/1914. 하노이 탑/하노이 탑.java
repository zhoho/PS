import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        BigInteger count = BigInteger.valueOf(2).pow(n).subtract(BigInteger.valueOf(1));
        System.out.println(count);

        if (n <= 20) {
            sb = new StringBuilder();
            hanoi(n, 1, 3, 2);
            System.out.println(sb);
        }
    }

    private static void hanoi(int n, int from, int to, int tmp) {
        if(n == 1) {
            sb.append(from + " " + to).append("\n");;
            return;
        }

        hanoi(n - 1, from, tmp, to);
        sb.append(from + " " + to).append("\n");

        hanoi(n - 1, tmp, to, from);
    }
}