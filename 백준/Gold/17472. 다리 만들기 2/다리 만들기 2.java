import java.util.*;
import java.io.*;

public class Main {
    static int n,m, islandCnt;
    static int[][] graph;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static PriorityQueue<Node> pq;
    static int[] parent;

    static class Point{
        int x;
        int y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Node implements Comparable<Node> {
        int x;
        int y;
        int dist;
        Node(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node n) {
            return Integer.compare(this.dist, n.dist);
        }
    }

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                System.out.print(graph[i][j] + " ");
//            }
//            System.out.println();
//        }

        // bfs 써서 개수 섬 개수 구하기 -> 개수만큼 graph 만들기

        // 모든 거리를 구해서 조건에 맞는 최소 거리 저장
        islandCnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j] == 1) {
                    islandCnt++;
                    bfs(i,j);
                }
            }
        }

//        System.out.println();
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                System.out.print(graph[i][j] + " ");
//            }
//            System.out.println();
//        }
//        System.out.println();


        parent = new int[islandCnt+1];
        for (int i = 1; i < islandCnt+1; i++) {
            parent[i] = i;
        }

        pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j] < 0) {
                    check(i,j);
                }
            }
        }

        int totalCost = 0;
        int edgeCount = 0;

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            if (union(node.x, node.y)) {
                totalCost += node.dist;
                edgeCount++;
            }
        }

        if (edgeCount == islandCnt - 1) {
            System.out.println(totalCost);
        } else {
            System.out.println(-1);
        }


    }

    private static int find(int x) {
        if (parent[x] == x) return x;

        return parent[x] = find(parent[x]);
    }

    private static boolean union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX == rootY) return false;

        parent[rootY] = rootX;
        return true;
    }

    private static void check(int x, int y) {

        for (int i = 0; i < 4; i++) {
            int nx = x;
            int ny = y;
            int dist = 0;

            while (true) {
                nx += dx[i];
                ny += dy[i];
                if (nx < 0 || nx > (n-1) || ny < 0 || ny > (m-1)) break;
                if (graph[nx][ny] < 0 && dist > 1) {
                    pq.add(new Node(-graph[x][y], -graph[nx][ny], dist));
                    break;
                }

                if (graph[nx][ny] == 0) dist++;
                else break;
            }
        }
    }

    private static void bfs(int x, int y) {
        Deque<Point> deq = new ArrayDeque<>();
        deq.addLast(new Point(x,y));
        graph[x][y] = -islandCnt;

        while(!deq.isEmpty()) {
            Point point = deq.pollFirst();

            for (int i = 0; i < 4; i++) {
                int nx = point.x + dx[i];
                int ny = point.y + dy[i];
                if (nx < 0 || nx > (n-1) || ny < 0 || ny > (m-1)) continue;

                if (graph[nx][ny] == 1) {
                    graph[nx][ny] = -islandCnt;
                    deq.addLast(new Point(nx,ny));
                }
            }
        }
    }
}