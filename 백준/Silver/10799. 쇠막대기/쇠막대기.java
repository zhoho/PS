import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String pipe = br.readLine();

        Stack<Character> stack = new Stack<>();
        int result = 0;

        for(int i = 0; i < pipe.length(); i++) {
            char c = pipe.charAt(i);
            if (c == '(') { 
                stack.push(c);
            } 
            else {
                stack.pop();
                if (pipe.charAt(i - 1) == '(') {
                    result += stack.size();
                } 
                else {
                    result++;
                }
            }
        }
        System.out.println(result);
    }
}
