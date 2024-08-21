
import java.util.*;
import java.io.*;

public class Solution {

    static int n;
    static String s;
    static int[][] graph;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        for (int tc = 1; tc < t+1; tc++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            s = st.nextToken();

            graph = new int[n][n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    graph[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            if (s.equals("left")) {
                graph = rotateRight(graph);
                move();
                graph = rotateLeft(graph);
            } else if (s.equals("right")) {
                graph = rotateLeft(graph);
                move();
                graph = rotateRight(graph);
            } else{
                move();
            }

            System.out.println("#" + tc);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(graph[i][j] + " ");
                }
                System.out.println();
            }
        }
    }

    private static int[][] rotateRight(int[][] graph) {
        int[][] temp = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++){
                temp[i][j] = graph[n-1-j][i];
            }
        }
        return temp;
    }

    private static int[][] rotateLeft(int[][] graph) {
        int[][] temp = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++){
                temp[i][j] = graph[j][n-1-i];
            }
        }
        return temp;
    }

    private static void move() {
        if (s.equals("up") || s.equals("right") || s.equals("left")) {
            for (int j = 0; j < n; j++) {
                for (int i = 0; i < n-1; i++) {
                    if (graph[i][j] == 0) {
                        continue;
                    }
                    // 0이 아닌 다음 숫자 찾기
                    int idx = i+1;
                    while (idx < n-1 && graph[idx][j] == 0) {
                        idx++;
                    }
                    // 숫자가 같으면 더하기
                    if (graph[i][j] == graph[idx][j]) {
                        graph[i][j] += graph[idx][j];
                        graph[idx][j] = 0;
                    }
                }
                int idx2 = 0;
                for (int i = 0; i < n; i++) {
                    if (graph[i][j] != 0) {
                        graph[idx2][j] = graph[i][j];
                        if (idx2 != i) {
                            graph[i][j] = 0;
                        }
                        idx2++;
                    }
                }
            }
        }

        if (s.equals("down")) {
            for (int j = 0; j < n; j++) {
                for (int i = n - 1; i > 0; i--) {
                    if (graph[i][j] == 0) {
                        continue;
                    }
                    int idx = i-1;
                    while (idx > 0 && graph[idx][j] == 0) {
                        idx--;
                    }
                    if (graph[i][j] == graph[idx][j]) {
                        graph[i][j] += graph[idx][j];
                        graph[idx][j] = 0;
                    }
                }
                int idx2 = n-1;
                for (int i = n - 1; i > -1; i--) {
                    if (graph[i][j] != 0) {
                        graph[idx2][j] = graph[i][j];
                        if (idx2 != i) {
                            graph[i][j] = 0;
                        }
                        idx2--;
                    }
                }
            }
        }
    }
}


//1
//5 up
//4 8 2 4 0
//4 4 2 0 8
//8 0 2 4 4
//2 2 2 2 8
//0 2 2 0 0


//2
//5 up
//4 8 2 4 0
//4 4 2 0 8
//8 0 2 4 4
//2 2 2 2 8
//0 2 2 0 0
//2 down
//16 2
//0 2