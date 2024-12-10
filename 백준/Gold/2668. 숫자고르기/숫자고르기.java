import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[] graph;
    static boolean[] visited;
    static List<Integer> answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        graph = new int[n+1];
        for (int i = 1; i < n+1; i++) {
            graph[i] = Integer.parseInt(br.readLine());
        }

        answer = new ArrayList<>();
        visited = new boolean[n+1];
        for (int i = 1; i < n+1; i++) {
            visited[i] = true;
            dfs(i,i);
            visited[i] = false;
        }

        Collections.sort(answer);
        System.out.println(answer.size());
        for (int i = 0; i < answer.size(); i++) {
            System.out.println(answer.get(i));
        }

    }

    private static void dfs(int idx, int target) {
        if (!visited[graph[idx]]) {
            visited[graph[idx]] = true;
            dfs(graph[idx], target);
            visited[graph[idx]] = false;
        }

        if (graph[idx] == target) {
            answer.add(target);
        }
    }
}
