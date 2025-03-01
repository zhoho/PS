import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int n, k, maxDepth;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            maxDepth = 0;
            map = new int[n][n];

            int maxHeight = 0;
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    maxHeight = Math.max(maxHeight, map[i][j]); // 최고 높이 찾기
                }
            }

            visited = new boolean[n][n];

            // 가장 높은 봉우리에서 등산 시작
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j] == maxHeight) {
                        visited[i][j] = true;
                        dfs(i, j, 1, false); // 초기 등산로 길이 1
                        visited[i][j] = false;
                    }
                }
            }

            System.out.println("#" + t + " " + maxDepth);
        }
    }

    private static void dfs(int x, int y, int depth, boolean canCut) {
        maxDepth = Math.max(maxDepth, depth);

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < n && ny < n && !visited[nx][ny]) {
                if (map[nx][ny] < map[x][y]) { 
                    // 정상적인 하강 가능할 때
                    visited[nx][ny] = true;
                    dfs(nx, ny, depth + 1, canCut);
                    visited[nx][ny] = false;
                } else if (!canCut) { 
                    // 깎을 수 있는 기회가 있을 때
                    for (int cut = 1; cut <= k; cut++) {
                        if (map[nx][ny] - cut < map[x][y]) { // 깎아서 내려갈 수 있으면 진행
                            map[nx][ny] -= cut;
                            visited[nx][ny] = true;
                            dfs(nx, ny, depth + 1, true); // 깎았으므로 canCut = true
                            visited[nx][ny] = false;
                            map[nx][ny] += cut; // 원상 복구
                        }
                    }
                }
            }
        }
    }
}
