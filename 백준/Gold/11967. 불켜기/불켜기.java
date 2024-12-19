import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static int[] dx = {0,0,1,-1}, dy = {1,-1,0,0};
    static ArrayList<int[]>[][] graph;
    static boolean[][] room;
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());

        graph = new ArrayList[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                graph[i][j] = new ArrayList<>();
            }
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int x=Integer.parseInt(st.nextToken())-1;
            int y=Integer.parseInt(st.nextToken())-1;
            int a=Integer.parseInt(st.nextToken())-1;
            int b=Integer.parseInt(st.nextToken())-1;
            graph[x][y].add(new int[]{a,b});
        }

        room = new boolean[n][n];
        visited = new boolean[n][n];
        room[0][0] = true;
        visited[0][0] = true;

        int cnt = 1;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,0});

        while(!q.isEmpty()){
            int[] cur = q.poll();

            // 현재 방에서 켤 수 있는 다른 방들의 불을 켜기
            for(int[] nxt : graph[cur[0]][cur[1]]){
                if(!room[nxt[0]][nxt[1]]) {
                    room[nxt[0]][nxt[1]] = true;
                    cnt++;
                    // 불 켠 방이 인접한 visited 방이 있다면 바로 큐에 삽입
                    for(int i=0; i<4; i++){
                        int nx=nxt[0]+dx[i];
                        int ny=nxt[1]+dy[i];
                        if(nx<0||nx>=n||ny<0||ny>=n) continue;
                        if(visited[nx][ny]){
                            visited[nxt[0]][nxt[1]]=true;
                            q.offer(new int[]{nxt[0],nxt[1]});
                            break;
                        }
                    }
                }
            }

            // 현재 방문한 방에서 4방향 탐색하여 갈 수 있는 방을 큐에 삽입
            for(int i=0; i<4; i++){
                int nx=cur[0]+dx[i];
                int ny=cur[1]+dy[i];
                if(nx<0||nx>=n||ny<0||ny>=n) continue;
                if(room[nx][ny] && !visited[nx][ny]){
                    visited[nx][ny]=true;
                    q.offer(new int[]{nx,ny});
                }
            }
        }

        System.out.println(cnt);
    }
}
//import java.util.*;
//import java.io.*;
//
//public class Main {
//    static int n, m;
//    static int[] dx = {0,0,1,-1};
//    static int[] dy = {1,-1,0,0};
//    static List<Node>[][] graph;
//    static boolean[][] room;
//    static boolean[][] visited;
//
//    static class Node{
//        int x;
//        int y;
//        Node(int x, int y) {
//            this.x = x;
//            this.y = y;
//        }
//    }
//
//    public static void main(String[] args) throws Exception {
//        //x,y 에서 a,b방의 불을 켜고 끌 수 있다
//        //
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st;
//
//        st = new StringTokenizer(br.readLine());
//        n = Integer.parseInt(st.nextToken());
//        m = Integer.parseInt(st.nextToken());
//
//        graph = new List[n][n];
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                graph[i][j] = new ArrayList<>();
//            }
//        }
//
//        for (int i = 0; i < m; i++) {
//            st = new StringTokenizer(br.readLine());
//            int x = Integer.parseInt(st.nextToken())-1;
//            int y = Integer.parseInt(st.nextToken())-1;
//            int a = Integer.parseInt(st.nextToken())-1;
//            int b = Integer.parseInt(st.nextToken())-1;
//
//            graph[x][y].add(new Node(a,b));
//        }
//
//        room = new boolean[n][n];
//        visited = new boolean[n][n];
//
//        room[0][0] = true;
//        visited[0][0] = true;
//
//        int cnt = 1;
//        Deque<Node> deq = new ArrayDeque<>();
//        deq.addLast(new Node(0,0));
//
//        while (!deq.isEmpty()) {
//            Node node = deq.pollFirst();
//
//            // 주변 불 켜고
//            for (Node next : graph[node.x][node.y]) {
//                if (!room[next.x][next.y]) {
//                    room[next.x][next.y] = true;
//                    cnt++;
//                }
//
//                for (int i = 0; i < 4; i++) {
//                    int nx = next.x + dx[i];
//                    int ny = next.y + dy[i];
//                    if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
//                    if (visited[nx][ny]) {
//                        visited[next.x][next.y] = true;
//                        deq.addLast(new Node(next.x, next.y));
//                        break;
//                    }
//                }
//            }
//
//            // 4방향 탐색하면서 불켜기
//            for (int i = 0; i < 4; i++) {
//                int nx = node.x + dx[i];
//                int ny = node.y + dy[i];
//                if (nx < 0 || nx > (n-1) || ny < 0 || ny > (n-1)) continue;
//                if (room[nx][ny] && !visited[nx][ny]) {
//                    visited[nx][ny] = true;
//                    deq.addLast(new Node(nx, ny));
//                }
//            }
//        }
//
////        for (int i = 0; i < n; i++) {
////            for (int j = 0; j < n; j++) {
////                System.out.print(room[i][j] + " ");
////            }
////            System.out.println();
////        }
//        System.out.println(cnt);
//    }
//}
