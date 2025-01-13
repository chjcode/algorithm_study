import java.util.*;
import java.io.*;


public class Main {

    static int n,m;
    static int[] graph, dist;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());   //사다리 수
        m = Integer.parseInt(st.nextToken());   // 뱀의 수

        graph = new int[101];
        for (int i = 0; i < 101; i++) {
            graph[i] = i;
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x] = y;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u] = v;
        }

        dist = new int[101];
        Arrays.fill(dist,-1);
        System.out.println(bfs());
    }

    private static int bfs() {
        Deque<Integer> deq = new ArrayDeque<>();
        dist[1] = 0;
        deq.addLast(1);

        while (!deq.isEmpty()) {
            int now = deq.pollFirst();

            if (now == 100) {
                return dist[now];
            }

            for (int dice = 1; dice < 7; dice++) {
                int next = now + dice;
                if (next > 100) continue;

                next = graph[next];

                if (dist[next] == -1) {
                    dist[next] = dist[now] + 1;
                    deq.addLast(next);
                }
            }
        }
        return -1;
    }
}
