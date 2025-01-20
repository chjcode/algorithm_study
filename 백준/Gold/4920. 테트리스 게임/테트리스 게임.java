import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[][] graph;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int idx = 0;
        while (true) {
            idx++;
            n = Integer.parseInt(br.readLine().trim());
            if (n == 0) break;
            graph = new int[n][n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine().trim());
                for (int j = 0; j < n; j++) {
                    graph[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int answer = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    answer = Math.max(answer, checkFirst(i, j));
                    answer = Math.max(answer, checkFirst90(i, j));
                    answer = Math.max(answer, checkSecond(i, j));
                    answer = Math.max(answer, checkSecond90(i, j));
                    answer = Math.max(answer, checkThird(i, j));
                    answer = Math.max(answer, checkThird90(i, j));
                    answer = Math.max(answer, checkThird180(i, j));
                    answer = Math.max(answer, checkThird270(i, j));
                    answer = Math.max(answer, checkFourth(i, j));
                    answer = Math.max(answer, checkFourth90(i, j));
                    answer = Math.max(answer, checkFourth180(i, j));
                    answer = Math.max(answer, checkFourth270(i, j));
                    answer = Math.max(answer, checkFifth(i, j));
                }
            }

            System.out.println(idx + ". " + answer);
        }



    }

    private static int checkFirst(int x, int y) {
        int result = 0;
        for (int j = y; j < y + 4; j++) {
            if (j > (n-1)) {
                return Integer.MIN_VALUE;
            }
            else {
                result += graph[x][j];
            }
        }
        return result;
    }

    private static int checkFirst90(int x, int y) {
        int result = 0;
        for (int i = x; i < x + 4; i++) {
            if (i > (n - 1)) {
                return Integer.MIN_VALUE;
            } else {
                result += graph[i][y];
            }
        }
        return result;
    }

    private static int checkSecond(int x, int y) {
        int result = 0;
        int[] dx = {0, 0, 1, 1};
        int[] dy = {0, 1, 1, 2};

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || nx > (n - 1) || ny < 0 || ny > (n - 1)) {
                return Integer.MIN_VALUE;
            }
            result += graph[nx][ny];
        }

        return result;
    }

    private static int checkSecond90(int x, int y) {
        int result = 0;
        int[] dx = {0, 1, 1, 2};
        int[] dy = {0, 0, -1, -1};

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || nx > (n - 1) || ny < 0 || ny > (n - 1)) {
                return Integer.MIN_VALUE;
            }
            result += graph[nx][ny];
        }

        return result;
    }

    private static int checkThird(int x, int y) {
        int result = 0;
        int[] dx = {0, 0, 0, 1};
        int[] dy = {0, 1, 2, 2};

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || nx > (n - 1) || ny < 0 || ny > (n - 1)) {
                return Integer.MIN_VALUE;
            }
            result += graph[nx][ny];
        }

        return result;
    }

    private static int checkThird90(int x, int y) {
        int result = 0;
        int[] dx = {0, 1, 2, 2};
        int[] dy = {0, 0, 0, -1};

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || nx > (n - 1) || ny < 0 || ny > (n - 1)) {
                return Integer.MIN_VALUE;
            }
            result += graph[nx][ny];
        }

        return result;
    }

    private static int checkThird180(int x, int y) {
        int result = 0;
        int[] dx = {0, 1, 1, 1};
        int[] dy = {0, 0, 1, 2};

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || nx > (n - 1) || ny < 0 || ny > (n - 1)) {
                return Integer.MIN_VALUE;
            }
            result += graph[nx][ny];
        }

        return result;
    }

    private static int checkThird270(int x, int y) {
        int result = 0;
        int[] dx = {0, 0, 1, 2};
        int[] dy = {0, 1, 0, 0};

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || nx > (n - 1) || ny < 0 || ny > (n - 1)) {
                return Integer.MIN_VALUE;
            }
            result += graph[nx][ny];
        }

        return result;
    }

    private static int checkFourth(int x, int y) {
        int result = 0;
        int[] dx = {0, 0, 0, 1};
        int[] dy = {0, 1, 2, 1};

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || nx > (n - 1) || ny < 0 || ny > (n - 1)) {
                return Integer.MIN_VALUE;
            }
            result += graph[nx][ny];
        }

        return result;
    }
    private static int checkFourth90(int x, int y) {
        int result = 0;
        int[] dx = {0, 1, 2, 1};
        int[] dy = {0, 0, 0, -1};

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || nx > (n - 1) || ny < 0 || ny > (n - 1)) {
                return Integer.MIN_VALUE;
            }
            result += graph[nx][ny];
        }

        return result;
    }

    private static int checkFourth180(int x, int y) {
        int result = 0;
        int[] dx = {0, 1, 1, 1};
        int[] dy = {0, 0, -1, 1};

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || nx > (n - 1) || ny < 0 || ny > (n - 1)) {
                return Integer.MIN_VALUE;
            }
            result += graph[nx][ny];
        }

        return result;
    }

    private static int checkFourth270(int x, int y) {
        int result = 0;
        int[] dx = {0, 1, 1, 2};
        int[] dy = {0, 0, 1, 0};

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || nx > (n - 1) || ny < 0 || ny > (n - 1)) {
                return Integer.MIN_VALUE;
            }
            result += graph[nx][ny];
        }

        return result;
    }

    private static int checkFifth(int x, int y) {
        int result = 0;
        int[] dx = {0, 0, 1, 1};
        int[] dy = {0, 1, 0, 1};

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || nx > (n - 1) || ny < 0 || ny > (n - 1)) {
                return Integer.MIN_VALUE;
            }
            result += graph[nx][ny];
        }

        return result;
    }

}
