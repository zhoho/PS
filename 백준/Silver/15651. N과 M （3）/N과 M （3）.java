import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] arr;
    static int n, m;
    static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        

		st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		arr = new int[m];
		back(0);
        System.out.println(sb);
	}

	public static void back(int count) {
		if(count == m) {
			for (int i = 0; i < m; i++) {
				sb.append(arr[i]).append(' ');
			}
			sb.append('\n');
			return;
		}

		for(int i = 1; i <= n; i++) {
			arr[count] = i;
			back(count+1);
		}
	}
}