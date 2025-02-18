import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] room;
    static int r;
    static int c;
    static int d;

    // 북(0), 동(1), 남(2), 서(3)
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        room = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int clean = 0;

        while (true) {
            // 1. 현재 칸 청소
            if (room[r][c] == 0) {
                room[r][c] = 2;
                clean++;
            }

            // 2. 주변 4칸 빈칸 확인
            if (!checkWith(r, c)) {
                int backR = r - dr[d];
                int backC = c - dc[d];

                if (room[backR][backC] == 1) {
                    break;
                }

                // 후진 가능하면 후진 후 1번으로
                r = backR;
                c = backC;
                continue;
            }

            // 3. 주변 4칸 중 청소되지 않은 빈 칸이 있는 경우
            for (int i = 0; i < 4; i++) {
                d = (d + 3) % 4;
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (room[nr][nc] == 0) {
                    r = nr;
                    c = nc;
                    break;
                }
            }
        }
        System.out.println(clean);
    }

    //빈칸 확인
    private static boolean checkWith(int r, int c) {
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (room[nr][nc] == 0) {
                return true;
            }
        }
        return false;
    }
}