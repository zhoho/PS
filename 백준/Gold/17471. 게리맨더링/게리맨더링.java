import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] population;
    static int[] nums;
    static ArrayList<Integer>[] adj;
    static int ans = Integer.MAX_VALUE;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        population = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            population[i] = Integer.parseInt(st.nextToken());
        }
        
        adj = new ArrayList[n];
        for(int i = 0; i < n; i ++) {
            adj[i] = new ArrayList<>();
        }

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            for(int j = 0; j < k; j++) {
                adj[i].add(Integer.parseInt(st.nextToken()) - 1);
            }
        }

        nums = new int[n];
        for(int i = 0; i < n; i++) {
            nums[i] = i;
        }

        for(int pick = 1; pick <= n - 1; pick++) {
            Stack<Integer> groupA = new Stack<>();
            makeCombination(groupA, 0, pick);
        }

        if(ans == Integer.MAX_VALUE) {
            ans = -1;
        }
        System.out.println(ans);

    }
    private static void makeCombination(Stack<Integer> groupA, int start, int pick) {
        if(groupA.size() == pick) {
            checkDiff(groupA);
            return;
        }

        for(int i = start; i < nums.length; i++) {
            groupA.push(nums[i]);
            makeCombination(groupA, i + 1, pick);
            groupA.pop();
        }

    }
    private static void checkDiff(Stack<Integer> groupA) {
        Stack<Integer> groupB = new Stack<>();
        for(int i = 0; i < n; i++) {
            if(!groupA.contains(i)) {
                groupB.push(i);
            }
        }

        if(!isConnected(groupA)) {
            return;
        }

        if(!isConnected(groupB)) {
            return;
        }

        int sumA = 0;
        int sumB = 0;

        for(int a : groupA) {
            sumA += population[a];
        }

        for(int b : groupB) {
            sumB += population[b];
        }

        ans = Math.min(ans, Math.abs(sumA-sumB));
    }

    private static boolean isConnected(Stack<Integer> group) {
        if(group.isEmpty()) {
            return false;
        }

        //bfs
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();

        //그룹의 첫 구역
        int start = group.get(0);
        visited[start] = true;
        q.offer(start);

        int count = 1;
        while(!q.isEmpty()) {
            int cur = q.poll();

            for(int next : adj[cur]) {
                if(!visited[next] && group.contains(next)) {
                    visited[next] = true;
                    q.offer(next);
                    count++;
                }
            }
        }
        return (count == group.size());
    }
}