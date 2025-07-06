import java.util.*;
import java.io.*;

public class Main {
    static class Point {
        int x, y;
        public Point(int x, int y) {
            this.x = x; this.y = y;
        }
    }

    static class Node {
        int x, y, time;
        char color;

        Node(int x, int y, int time, char color) {
            this.x = x;
            this.y = y;
            this.time = time;
            this.color = color;
        }
    }

    static int n, m, g, r, answer = 0;
    static int[][] map;
    static List<Point> fertile = new ArrayList<>();
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        g = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    fertile.add(new Point(i, j));
                }
            }
        }

        dfs(0, 0, new ArrayList<>(), new ArrayList<>());
        System.out.println(answer);
    }

    static void dfs(int idx, int selected, List<Integer> green, List<Integer> red) {
        if (green.size() > g || red.size() > r) return;
        if (selected == g + r) {
            bfs(green, red);
            return;
        }
        if (idx == fertile.size()) return;

        dfs(idx + 1, selected, green, red); // 아무것도 선택 안 함

        green.add(idx);
        dfs(idx + 1, selected + 1, green, red);
        green.remove(green.size() - 1);

        red.add(idx);
        dfs(idx + 1, selected + 1, green, red);
        red.remove(red.size() - 1);
    }

    static void bfs(List<Integer> greenIdx, List<Integer> redIdx) {
        int[][] time = new int[n][m];
        char[][] color = new char[n][m];
        boolean[][] flower = new boolean[n][m];

        Deque<Node> deq = new ArrayDeque<>();

        for (int i : greenIdx) {
            Point p = fertile.get(i);
            deq.offerLast(new Node(p.x, p.y, 0, 'G'));
            time[p.x][p.y] = 0;
            color[p.x][p.y] = 'G';
        }

        for (int i : redIdx) {
            Point p = fertile.get(i);
            deq.offerLast(new Node(p.x, p.y, 0, 'R'));
            time[p.x][p.y] = 0;
            color[p.x][p.y] = 'R';
        }

        int flowerCount = 0;

        while (!deq.isEmpty()) {
            int size = deq.size();

            for (int s = 0; s < size; s++) {
                Node cur = deq.pollFirst();

                if (flower[cur.x][cur.y]) continue;

                for (int d = 0; d < 4; d++) {
                    int nx = cur.x + dx[d];
                    int ny = cur.y + dy[d];

                    if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                    if (map[nx][ny] == 0 || flower[nx][ny]) continue;

                    if (color[nx][ny] == 0) {
                        color[nx][ny] = cur.color;
                        time[nx][ny] = cur.time + 1;
                        deq.offerLast(new Node(nx, ny, cur.time + 1, cur.color));
                    } else if (color[nx][ny] != cur.color && time[nx][ny] == cur.time + 1) {
                        flower[nx][ny] = true;
                        flowerCount++;
                    }
                }
            }
        }

        answer = Math.max(answer, flowerCount);
    }
}
