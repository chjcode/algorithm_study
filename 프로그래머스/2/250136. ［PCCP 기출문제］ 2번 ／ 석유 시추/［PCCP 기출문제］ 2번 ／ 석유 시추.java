import java.util.*;

class Solution {
    public int solution(int[][] land) {
        int rows = land.length;
        int cols = land[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int[] columnOil = new int[cols]; // 열별 석유량 저장

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 상하좌우 이동

        // BFS 탐색
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (land[r][c] == 1 && !visited[r][c]) {
                    bfs(land, visited, columnOil, r, c, directions);
                }
            }
        }

        // 각 열에서 최대 석유 크기 반환
        return Arrays.stream(columnOil).max().orElse(0);
    }

    private void bfs(int[][] land, boolean[][] visited, int[] columnOil, int startR, int startC, int[][] directions) {
        int rows = land.length;
        int cols = land[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startR, startC});
        visited[startR][startC] = true;

        Set<Integer> columns = new HashSet<>(); // 포함된 열 저장
        int oilSize = 0; // 석유 덩어리 크기

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int r = cur[0], c = cur[1];

            oilSize++;
            columns.add(c); // 현재 열 기록

            // 네 방향 탐색
            for (int[] dir : directions) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && land[nr][nc] == 1 && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    queue.add(new int[]{nr, nc});
                }
            }
        }

        // 석유 덩어리가 포함된 모든 열에 크기 추가
        for (int col : columns) {
            columnOil[col] += oilSize;
        }
    }
}