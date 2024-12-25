import java.io.*;
import java.util.*;

public class Main {
    static int n,k,w;
    static int[] buildTime, degree;
    static List<List<Integer>> graph;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < t; tc++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            buildTime = new int[n+1];   // 빌딩 짓는데 걸리는 시간
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i < n + 1; i++) {
                buildTime[i] = Integer.parseInt(st.nextToken());
            }

            //진입 차수 배열 만들기
            graph = new ArrayList<>();
            for (int i = 0; i < n + 1; i++) {
                graph.add(new ArrayList<>());
            }

            degree = new int[n+1];
            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                graph.get(x).add(y);
                degree[y]++;
            }

            w = Integer.parseInt(br.readLine());    //목표 건물

            Deque<Integer> deq = new ArrayDeque<>();    // 진입 차수가 0인 건물들 집어넣을 위상 정렬 순서 저장할 큐
            int[] dp = new int[n+1];    // dp (각 건물까지의 최대 누적 시간을 저장할 배열)

            for (int i = 0; i < n + 1; i++) {
                dp[i] = buildTime[i];   // 각 건물별로 짓는데 필요한 시간을 dp에 넣음
                if (degree[i] == 0) {   // 진입차수가 0이면 가장 먼저 지어져야할 건물이므로 큐에 넣음
                    deq.addLast(i);
                }
            }

            // 위상 정렬 시작 (진입차수가 0인 애들을 계속해서 뽑아내며 순서 정하기)
            while (!deq.isEmpty()) {
                int now = deq.pollFirst();

                // 현재 노드에서 연결된 다음 노드들 찾기
                for (int next : graph.get(now)) {
                    dp[next] = Math.max(dp[next], dp[now] + buildTime[next]);   //현재까지 걸린 최대 시간 저장
                    degree[next]--; // next 건물을 짓기 위해서 먼저 지어야 할 건물을 지었으므로 진입차수 하나 빼기

                    // 진입 차수가 0이 되면 먼저 지어야 할 건물을 모두 지었다는 뜻이므로
                    // 자신과 연결된 다음 노드를 찾기 위해 큐에 넣기
                    if (degree[next] == 0) {
                        deq.addLast(next);
                    }
                }
            }

            System.out.println(dp[w]);
        }
    }
}
