import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer> output;
    static int n,m;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visited = new boolean[m];
        output = new ArrayList<>();

        back(1);
    }

    private static void back(int start) {
        if (output.size() == m) {
            StringBuilder sb = new StringBuilder();
            for (int num : output) {
                sb.append(num).append(" ");
            }
            System.out.println(sb.toString().trim());
            return;
        }

        for(int i = start; i <= n; i++) {
                output.add(i);
                back(i + 1);
                output.remove(output.size()-1);
        }
    }
}