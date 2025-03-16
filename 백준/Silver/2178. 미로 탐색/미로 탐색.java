import java.io.*;
import java.util.*;

public class Main {
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	static boolean[][] visited;
	static int[][] map;
	static int n;
	static int m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];
        for(int j = 0; j < n; j++) {
        	String line = br.readLine();
        	for(int k = 0; k < m; k++) {
        		map[j][k] = line.charAt(k) - '0';
        	}
        }
        bfs(0,0);
        System.out.println(map[n-1][m-1]);
        }
        
 
    private static void bfs(int i, int j) {
    	Queue<int[]> q = new LinkedList<>();
    	q.offer(new int[] {i,j});
    	while(!q.isEmpty()) {
    		int now[] = q.poll();
    		visited[i][j] = true;
    		//상하좌우 탐색
    		for(int k = 0; k < 4; k++) {
    			int x = now[0] + dx[k];
    			int y = now[1] + dy[k];
    			if(x >= 0 && y >= 0 && x < n && y < m) {
    				if(map[x][y]!= 0 && !visited[x][y]) {
    					visited[x][y] = true;
    					map[x][y] = map[now[0]][now[1]] + 1;
    					q.add(new int[] {x,y});
    				}
    			}
    		}
    	}
    }
}