import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static List<List<Integer>> tree;
    static int[] subTree;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        tree = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            tree.add(new ArrayList<>());
        }

        subTree = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            subTree[i] = 1;
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            tree.get(start).add(end);
            tree.get(end).add(start);
        }

        visited = new boolean[n+1];
        visited[1] = true;
        dfs(1);

        // 다양한 경로 조합 계산
        long variety = 0;
        for (int i = 2; i <= n; i++) { // 루트(1)를 제외한 모든 노드 순회
            int restNodeCnt = n - subTree[i]; // 간선을 제외한 나머지 노드 수
            variety += nC2(n) - nC2(restNodeCnt); // 포함 조합 계산
        }

        System.out.println(variety);
    }
    private static long nC2(int num) {
        return (long) num * (num - 1) / 2; // 조합 공식 nC2
    }

    private static int dfs(int current) {
        for (int next : tree.get(current)) { // 현재 노드의 자식 노드 순회
            if (!visited[next]) { // 방문하지 않은 노드만 탐색
                visited[next] = true;
                subTree[current] += dfs(next); // 서브트리 크기 갱신
            }
        }
        return subTree[current];
    }

}
