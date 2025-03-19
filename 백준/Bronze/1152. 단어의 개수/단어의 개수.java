import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
				
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String str = br.readLine();
        int ans = 1;
        
        for(int i = 0; i < str.length(); i++) {
        	if(str.charAt(i) == ' ') {
        		ans += 1;
        	}
        }
        if(str.charAt(0) == ' ') ans -= 1;
        if(str.charAt(str.length() - 1) == ' ') ans -= 1;
        System.out.println(ans);
	}
}