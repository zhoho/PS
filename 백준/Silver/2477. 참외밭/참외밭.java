import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws NumberFormatException, IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
        int longestWid = 0;
        int idxW = 0;
        int longestHei = 0;
        int idxH = 0;

        ArrayList<Integer> list = new ArrayList<>();


        for(int i = 0; i < 6; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int direction = Integer.parseInt(st.nextToken());
            int line = Integer.parseInt(st.nextToken());
            
            list.add(line);
            if(direction == 1 || direction == 2) {
                if(line >= longestWid) {
                    longestWid = line;
                    idxW = i;
                }
            }
            else if(direction == 3 || direction == 4) {
                if(line >= longestHei) {
                    longestHei = line;
                    idxH = i;
                }
            }
        }

        int shortestWid = list.get((idxW + 3) % 6);
        int shortestHei = list.get((idxH + 3) % 6);

        int miniSquare = shortestHei * shortestWid;
        int square = longestWid * longestHei;
        
        System.out.println(n*(square - miniSquare));


    }
}
