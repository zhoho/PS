import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] list = new int[5][5];

        //빙고판 채우기
        for(int i = 0 ; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 5; j++) {
                list[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int count = 0;
        int bingo = 0;
        out:
        for(int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 5; j++) {
                count ++;
                int n = Integer.parseInt(st.nextToken());

                //사회자가 부른 숫자가 list에서 0이 되도록
                for (int r = 0; r < 5; r++) {
                    for (int c = 0; c < 5; c++) {
                        if (list[r][c] == n) {
                            list[r][c] = 0;
                        }
                    }
                }
                bingo = checkBingo(list);

                if(bingo >= 3) {
                    System.out.println(count);
                    break out;
                }
            }
        }
    }

    private static int checkBingo(int[][] list) {
        int bingo = 0;

        //가로
        for(int i = 0; i < 5; i++) {
            int sum = 0;
            for(int j = 0; j < 5; j++) {
                sum += list[i][j];
            }
            if(sum == 0) {
                bingo ++;
            }
        }

        //세로
        for(int i = 0; i < 5; i++) {
            int sum = 0;
            for(int j = 0; j < 5; j++) {
                sum += list[j][i];
            }
            if(sum == 0) {
                bingo ++;
            }
        }

        //대각선 왼->오 
        int sum = 0;
        for(int i = 0; i < 5; i++) {
            sum += list[i][i];
        }
        if(sum == 0) {
            bingo ++;
        }

        //대각선 오>왼
        sum = 0;
        for(int i = 0; i < 5; i++) {
            sum += list[i][4-i];
        }
        if(sum == 0) {
            bingo ++;
        }

        return bingo;
    }
}