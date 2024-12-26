import java.io.*;
import java.util.*;

public class Main {
    static int n, m, a, b, c;
    static Node[] graph;
    static long[] dist;

    static class Node{
        int start;
        int end;
        int time;

        Node(int start, int end, int time) {
            this.start = start;
            this.end = end;
            this.time = time;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new Node[m];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            graph[i] = new Node(a, b, c);
        }

        dist = new long[n+1];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[1] = 0;

        boolean isCycle = bellmanFord(n, m);

        if (isCycle) {
            System.out.println(-1);
        } else {
            for (int i = 2; i <= n; i++) {
                if (dist[i] == Long.MAX_VALUE) {
                    System.out.println("-1");
                } else {
                    System.out.println(dist[i]);
                }
            }
        }
    }

    private static boolean bellmanFord(int n, int m) {
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < m; j++) {
                Node node = graph[j];
                // 갱신 가능한 노드인지 확인, 다음 노드까지의 걸리는 시간이 최솟값이면 갱신
                if (dist[node.start] != Long.MAX_VALUE && dist[node.start] + node.time < dist[node.end]) {
                    dist[node.end] = dist[node.start] + node.time;
                }
            }
        }

        for (int j = 0; j < m; j++) {
            Node node = graph[j];
            if (dist[node.start] != Long.MAX_VALUE && dist[node.start] + node.time < dist[node.end]) {
                return true;
            }
        }

        return false;
    }
}
