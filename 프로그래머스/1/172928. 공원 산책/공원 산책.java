import java.util.*;

class Solution {

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int n, m, x, y;
    static char[][] graph;
    static Map<Character, Integer> directionMap;

    public int[] solution(String[] park, String[] routes) {
        n = park.length;
        m = park[0].length();
        graph = new char[n][m];

        directionMap = new HashMap<>();
        directionMap.put('E', 0);
        directionMap.put('W', 1);
        directionMap.put('S', 2);
        directionMap.put('N', 3);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                graph[i][j] = park[i].charAt(j);
                if (graph[i][j] == 'S') {
                    x = i;
                    y = j;
                }
            }
        }

        for (String route : routes) {
            String[] parts = route.split(" ");
            char dir = parts[0].charAt(0);
            int cnt = Integer.parseInt(parts[1]);
            int[] newPos = move(dir, cnt);
            x = newPos[0];
            y = newPos[1];
        }

        return new int[]{x, y};
    }

    private static int[] move(char dir, int cnt) {
        int idx = directionMap.get(dir);
        int xx = x;
        int yy = y;

        for (int i = 0; i < cnt; i++) {
            int nx = xx + dx[idx];
            int ny = yy + dy[idx];

            if (nx < 0 || nx >= n || ny < 0 || ny >= m || graph[nx][ny] == 'X') {
                return new int[]{x, y};
            }

            xx = nx;
            yy = ny;
        }

        return new int[]{xx, yy};
    }
}