import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] inputs = new int[8];
        for (int i = 0; i < inputs.length; i++) {
            inputs[i] = in.nextInt();
        }
        in.close();
        String aToString = Arrays.toString(inputs).replace(",", "");
        String ans;

        if (aToString.equals("[1 2 3 4 5 6 7 8]"))
            ans = "ascending";
        else if (aToString.equals("[8 7 6 5 4 3 2 1]"))
            ans = "descending";
        else
            ans = "mixed";
        System.out.println(ans);
    }
}
