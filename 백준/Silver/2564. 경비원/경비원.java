import java.io.*;
import java.util.*;

public class Main {
    private static List<int[]> list = new ArrayList<>();
    private static int width, height;
    private static int[] lineLeft;
    private static int[] lineRight;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        width = Integer.parseInt(st.nextToken());
        height = Integer.parseInt(st.nextToken());
        
        //먼저 위치 찍기
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n + 1; i++) {
            StringTokenizer input = new StringTokenizer(br.readLine());
            int ewsn = Integer.parseInt(input.nextToken());
            int val = Integer.parseInt(input.nextToken());
            findPlace(ewsn, val);
        }

        int answer = 0;
        lineLeft = new int[n+1];
        lineRight = new int[n+1];

        for(int i = 0; i < n + 1; i++) {
            int x = list.get(i)[0];
            int y = list.get(i)[1];
            line1(x,y,i);
            line2(x,y,i);
        }
        int donguenLeft = lineLeft[n];
        int donguenRight = lineRight[n];
 

        
        for (int i = 0; i < n ; i++) {
            int path1 = Math.abs(lineLeft[i] - donguenLeft);
            int path2 = Math.abs(lineRight[i] - donguenRight);
            answer += Math.min(path1, path2);
        }
        
//        int path1 = Math.abs(lineLeft[0] - donguenLeft);
//        int path2 = Math.abs(lineRight[-1] - donguenRight);
//        answer += Math.min(path1, path2);
  
        System.out.println(answer);
    }

    //위치 찾는 메서드
    private static void findPlace(int ewsn, int val) {
        if(ewsn == 1) {
            list.add(new int[]{val, height});
        }
        //남
        else if(ewsn == 2) {
            list.add(new int[]{val, 0});
        }
        //서
        else if(ewsn == 3) {
            list.add(new int[]{0, height-val});
        }
        //동
        else if(ewsn == 4) {
            list.add(new int[]{width, height-val});
        }
    }

    //동 북 서 남  순서로 펼쳐서 찍기 
    private static void line1(int x, int y, int i) {
        if (x == width) {
            lineLeft[i] = height - y; 
        }
        else if (y == height) {
            lineLeft[i] = height + (width - x);
        } 
        else if (x == 0) {
            lineLeft[i] = height + width + (height - y);
        } 
        else if (y == 0) {
            lineLeft[i] =  height + width + height + x;
        }
    }
    
    //남 동 북 서 순서로 펼쳐서 찍기
    private static void line2(int x, int y, int i) {
        if(y == 0) {
            lineRight[i] = x; 
        }
        else if(x == width) {
            lineRight[i] = width + y;
        }
        else if(y == height) {
            lineRight[i] = height + width + (width - x);
        }
        else if(x == 0) {
            lineRight[i] = width + height + width + (height - y);
        }
    }
}