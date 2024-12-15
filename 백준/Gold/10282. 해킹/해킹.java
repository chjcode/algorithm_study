import java.util.*;
import java.io.*;

public class Main {
    static int n,d,c, a,b,s,cnt,time;
    static int[] visited;
    static List<List<Node>> computer;

    static class Node implements Comparable<Node>{
        int idx;
        int time;
        Node(int idx, int time) {
            this.idx = idx;
            this.time = time;
        }

        @Override
        public int compareTo(Node n) {
            return this.time - n.time;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < t; tc++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());   // 컴퓨터 개수
            d = Integer.parseInt(st.nextToken());   // 의존성 개수
            c = Integer.parseInt(st.nextToken());   // 해킹당한 컴퓨터의 번호

            computer = new ArrayList<>();
            for (int i = 0; i < n+1; i++) {
                computer.add(new ArrayList<>());
            }

            for (int i = 0; i < d; i++) {
                st = new StringTokenizer(br.readLine());
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());
                s = Integer.parseInt(st.nextToken());

                computer.get(b).add(new Node(a, s));

            }

            visited = new int[n+1];
            Arrays.fill(visited, Integer.MAX_VALUE);

            PriorityQueue<Node> pq = new PriorityQueue<>();
            pq.add(new Node(c,0));
            visited[c] = 0;

            cnt = 0;
            time = 0;

            while(!pq.isEmpty()) {
                Node now = pq.poll();
                if (visited[now.idx] < now.time) continue;

                cnt++;
                time = Math.max(time, now.time);

                for (Node next : computer.get(now.idx)) {
                    int timeSum = now.time + next.time;
                    if (timeSum < visited[next.idx]) {
                        visited[next.idx] = timeSum;
                        pq.add(new Node(next.idx, timeSum));
                    }
                }
            }

            System.out.println(cnt + " " + time);
        }
    }


}
