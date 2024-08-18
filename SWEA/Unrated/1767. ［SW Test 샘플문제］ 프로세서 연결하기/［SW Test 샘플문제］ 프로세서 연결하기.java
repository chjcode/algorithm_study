import java.util.*;
import java.io.*;

public class Solution {

    static int n, answer;
    static int[][] graph;
    static List<Point> cores, selectedCores;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};

    static class Point{
        int x;
        int y;
        Point (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc < t+1; tc++) {
            n = Integer.parseInt(br.readLine());
            graph = new int[n][n];
            cores = new ArrayList<>();
            selectedCores = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    graph[i][j] = Integer.parseInt(st.nextToken());
                    if (graph[i][j] == 1 && i != 0 && i != n-1 && j != 0 && j != n-1) {
                        cores.add(new Point(i,j));
                    }
                }
            }

            answer = Integer.MAX_VALUE;
            find();
            System.out.println("#" + tc + " " + answer);

        }

    }

    private static void find() {
        // 코어를 최대로 많이 연결 했을 경우 부터 고려
        for (int i = cores.size(); i > 0; i--) {
            combination(0,0,i);
            if (answer != Integer.MAX_VALUE) {
                break;
            }
        }
    }

    private static void combination(int start, int cnt, int depth) {
        if (cnt == depth) {
            connect(0,0);
            return;
        }

        for (int i = start; i < cores.size(); i++) {
            selectedCores.add(cores.get(i));
            combination(i+1, cnt+1, depth);
            selectedCores.remove(selectedCores.size()-1);
        }
    }

    private static void connect(int idx, int wireLength) {
        // 모두 연결에 성공하면
        if (idx == selectedCores.size()){
            answer = Math.min(answer, wireLength);
            return;
        }

        Point point = selectedCores.get(idx);
        // 4 방향 반복
        for (int i = 0; i < 4; i++) {
            int x = point.x;
            int y = point.y;
            int cntLength = 0;
            boolean flag = true;

            // 연결
            while (true){
                x += dx[i];
                y += dy[i];
                // grahp 밖으로 나가면 성공
                if (x < 0 || x > (n - 1) || y < 0 || y > (n - 1)) {
                    break;
                }
                // 다른 코어나 전선이 있으면 실패
                if (graph[x][y] != 0) {
                    flag = false;
                    break;
                }
                graph[x][y] = 2;
                cntLength++;
            }
            // 연결 성공하면
            if (flag){
                connect(idx+1, wireLength+cntLength);
            }

            // 연결 해제
            x = point.x;
            y = point.y;
            while (cntLength > 0) {
                x += dx[i];
                y += dy[i];
                graph[x][y] = 0;
                cntLength--;
            }
        }
    }
}
