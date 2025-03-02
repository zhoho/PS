import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] population;
	static int n;
	static boolean[] visited;
	static ArrayList<Integer>[] arr; 
	static int ans = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        n = Integer.parseInt(br.readLine());
        population = new int[n];
        arr = new ArrayList[n];
        visited = new boolean[n];
        
        st = new StringTokenizer(br.readLine());        
        for(int i = 0; i < n; i++) {
        	population[i] = Integer.parseInt(st.nextToken());
        	arr[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < n; i++) {
        	st = new StringTokenizer(br.readLine());
        	int num = Integer.parseInt(st.nextToken());
        	for(int j = 0; j < num; j++) {
        		arr[i].add(Integer.parseInt(st.nextToken()) -1);
        	}
        }  
        dfs(0);
        
        if(ans == Integer.MAX_VALUE) {
        	System.out.println(-1);
        }
        else {
        	System.out.println(ans);
        }
	}
	private static void dfs(int idx) {
		if(idx == n - 1) {
			check();
			return;
		}
		
		visited[idx] = true;
		dfs(idx + 1);
		
		visited[idx] = false;
		dfs(idx + 1);
	}
	
	private static void check() {
		ArrayList<Integer> groupA = new ArrayList<>();
		ArrayList<Integer> groupB = new ArrayList<>();
		
		for(int i = 0; i < n; i++) {
			if(visited[i]) {
				groupA.add(i);
			}
			else {
				groupB.add(i);
			}
		}
		if(groupA.isEmpty() || groupB.isEmpty()) {
			return;
		}
		
		if(isConnected(groupA) && isConnected(groupB)) {
			int sumA = 0;
			int sumB = 0;
			for(int i : groupA) {
				sumA += population[i];
			}
			for(int i : groupB) {
				sumB += population[i];
			}
			ans = Math.min(ans, Math.abs(sumA-sumB));
		}
	}
	
	private static boolean isConnected(ArrayList<Integer> group) {
		boolean[] visit = new boolean[n];
		Queue<Integer> q = new LinkedList<>();
		q.add(group.get(0));
		visit[group.get(0)] = true;
		
		int count = 1;
		while(!q.isEmpty()) {
			int now = q.poll();
			for(int i : arr[now]) {
				if(group.contains(i) && !visit[i]) {
					visit[i] = true;
					q.add(i);
					count++;
				}
			}
		}
		return count == group.size();
	}
}