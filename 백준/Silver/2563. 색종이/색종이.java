import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		boolean[][] paper = new boolean[100][100];
		int area = 0;
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			for(int dx = x; dx < x + 10; dx++) {
				for(int dy = y; dy < y + 10; dy++) {
					if(!paper[dx][dy]) {
						paper[dx][dy] = true;
						area ++;
					}
				}
			}
		}
		System.out.println(area);
	}
}