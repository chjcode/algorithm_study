// 2,2 2,3 2,4
// 3,2     3,4
// 4,2     4,4
// 5,2 5,3 5,4
// 회전 범위 -> x : (5-2) = 3 (가로,리스트에서는 세로)
//          -> y : (4-2) = 2 (세로,리스트에서는 가로)

class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];

        int[][] graph = new int[rows][columns];
        int cnt = 1;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                graph[i][j] = cnt++;
            }
        }

        for (int q = 0; q < queries.length; q++) {
            int x1 = queries[q][0] - 1;
            int y1 = queries[q][1] - 1;
            int x2 = queries[q][2] - 1;
            int y2 = queries[q][3] - 1;

            int x = x2 - x1;
            int y = y2 - y1;

            int temp = graph[x1][y1];
            int mn = 10001;

            for (int i = 0; i < 4; i++) {
                if (i % 4 == 0) {
                    for (int j = 0; j < x; j++) {
                        mn = Math.min(graph[x1][y1], mn);
                        graph[x1][y1] = graph[x1 + 1][y1];
                        x1++;
                    }
                } else if (i % 4 == 1) {
                    for (int j = 0; j < y; j++) {
                        mn = Math.min(graph[x1][y1], mn);
                        graph[x1][y1] = graph[x1][y1 + 1];
                        y1++;
                    }
                } else if (i % 4 == 2) {
                    for (int j = 0; j < x; j++) {
                        mn = Math.min(graph[x1][y1], mn);
                        graph[x1][y1] = graph[x1 - 1][y1];
                        x1--;
                    }
                } else {
                    for (int j = 0; j < y - 1; j++) {
                        mn = Math.min(graph[x1][y1], mn);
                        graph[x1][y1] = graph[x1][y1 - 1];
                        y1--;
                    }
                    mn = Math.min(graph[x1][y1], mn);
                    graph[x1][y1] = temp;
                }
            }

            answer[q] = mn;
        }

        return answer;
    }
}