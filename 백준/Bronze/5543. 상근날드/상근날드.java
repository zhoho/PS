import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        int min_bug = 2000;
        int min_bav = 2000;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 0; i < 3; i++) {
            int tmp = Integer.parseInt(br.readLine());
            if(tmp < min_bug) {
                min_bug = tmp;
            }
        }
        for(int j = 0; j < 2; j++) {
            int tmp = Integer.parseInt(br.readLine());
            if(tmp < min_bav) {
                min_bav = tmp;
            }
        }
        int chpeast_set = min_bug + min_bav - 50;

        System.out.println(chpeast_set);
    }
}
