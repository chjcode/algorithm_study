
import java.util.*;
import java.io.*;

public class Solution {

    static int t, n, nx, ny, nowX, nowY, cnt;
    static int[][] graph;
    static int[] dx = { 0, 0, -1, 1 };
    static int[] dy = { -1, 1, 0, 0 };
    static Map<Integer,List<int[]>> wormHole;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        t = Integer.parseInt(br.readLine().trim());

        for (int tc = 1; tc < t + 1; tc++) {
            n = Integer.parseInt(br.readLine().trim());
            graph = new int[n][n];
            wormHole = new HashMap<>();
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine().trim());
                for (int j = 0; j < n; j++) {
                    int value = Integer.parseInt(st.nextToken());
                    graph[i][j] = value;
                    if (value >= 6 && value <= 10) {
                        if (!wormHole.containsKey(value)) {
                            wormHole.put(value, new ArrayList<>());
                        }
                        wormHole.get(value).add(new int[]{i, j});
                    }
                }
            }

            cnt = 0;
            int temp = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    //블랙홀, 방해물 조건 추가
                    if (graph[i][j] == 0) {
                        cnt = Math.max(cnt, gameStart(i, j));
                        temp++;
                    }
                }
            }
            System.out.println("#" + tc + " " + cnt);
        }

    }

    private static int gameStart(int startX, int startY) {
        int result = 0;
        for (int k = 0; k < 4; k++) {
            int count = 0;

            nx = dx[k];
            ny = dy[k];
            nowX = startX;
            nowY = startY;

            while (true) {
                nowX += nx;
                nowY += ny;
                if (nowX < 0 || nowX > (n-1) || nowY < 0 || nowY > (n-1)) {
                    nx = -nx;
                    ny = -ny;
                    count += 1;
                    continue;
                }

                if ((nowX == startX && nowY == startY) || graph[nowX][nowY] == -1) {
                    break;
                }

                if (graph[nowX][nowY] == 0) {
                    continue;
                }else if (graph[nowX][nowY] == 1) {
                    if (nx == 0 && ny == 1) {
                        nx = 0;
                        ny = -1;
                    } else if(nx == -1 && ny == 0) {
                        nx = 1;
                        ny = 0;
                    } else if (nx == 1 && ny == 0) {
                        nx = 0;
                        ny = 1;
                    } else {
                        nx = -1;
                        ny = 0;
                    }
                    count += 1;
                }else if (graph[nowX][nowY] == 2) {
                    if (nx == 0 && ny == 1) {
                        nx = 0;
                        ny = -1;
                    } else if(nx == -1 && ny == 0) {
                        nx = 0;
                        ny = 1;
                    } else if (nx == 0 && ny == -1) {
                        nx = 1;
                        ny = 0;
                    } else {
                        nx = -1;
                        ny = 0;
                    }
                    count += 1;
                } else if (graph[nowX][nowY] == 3) {
                    if (nx == 0 && ny == 1) {
                        nx = 1;
                        ny = 0;
                    } else if(nx == -1 && ny == 0) {
                        nx = 0;
                        ny = -1;
                    } else if (nx == 0 && ny == -1) {
                        nx = 0;
                        ny = 1;
                    } else {
                        nx = -1;
                        ny = 0;
                    }
                    count += 1;
                } else if (graph[nowX][nowY] == 4) {
                    if (nx == 0 && ny == 1) {
                        nx = -1;
                        ny = 0;
                    } else if(nx == -1 && ny == 0) {
                        nx = 1;
                        ny = 0;
                    } else if (nx == 0 && ny == -1) {
                        nx = 0;
                        ny = 1;
                    } else {
                        nx = 0;
                        ny = -1;
                    }
                    count += 1;
                } else if (graph[nowX][nowY] == 5) {
                    nx = -nx;
                    ny = -ny;
                    count += 1;
                } else if (graph[nowX][nowY] < 11) {
                    List<int[]> nowLoc = wormHole.get(graph[nowX][nowY]);
                    for (int[] xy : nowLoc) {
                        if (xy[0] != nowX || xy[1] != nowY) {
                            nowX = xy[0];
                            nowY = xy[1];
                            break;
                        }
                    }
                }
            }
            result = Math.max(result,count);
        }
        return result;
    }

}
