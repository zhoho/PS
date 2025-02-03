import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[][] list = new char[5][15];
		for(int i = 0; i < 5; i++) {
			String line = br.readLine();
			for(int j = 0; j < line.length(); j++) {
				list[i][j] = line.charAt(j);
			}
		}
		for(int i = 0; i < 15; i++) {
			for(int j = 0; j < 5; j++) {
				if(list[j][i] != '\0') {
					System.out.print(list[j][i]);
				}
			}
		}
	}
}