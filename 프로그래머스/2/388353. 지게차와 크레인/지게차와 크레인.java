import java.util.*;

class Solution {
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};

    public int solution(String[] storage, String[] requests) {
        int n = storage.length;
        int m = storage[0].length();

        boolean[][] removed = new boolean[n][m];

        for (String request : requests) {
            char target = request.charAt(0);

            if (request.length() == 2) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        if (!removed[i][j] && storage[i].charAt(j) == target) {
                            removed[i][j] = true;
                        }
                    }
                }
            } else {
                boolean[][] outside = new boolean[n][m];
                Deque<int[]> deq = new ArrayDeque<>();

                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        if (i == 0 || i == n - 1 || j == 0 || j == m - 1) {
                            if (removed[i][j] && !outside[i][j]) {
                                outside[i][j] = true;
                                deq.add(new int[]{i, j});
                            }
                        }
                    }
                }

                while (!deq.isEmpty()) {
                    int[] cur = deq.poll();
                    int x = cur[0];
                    int y = cur[1];

                    for (int d = 0; d < 4; d++) {
                        int nx = x + dx[d];
                        int ny = y + dy[d];

                        if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                        if (outside[nx][ny]) continue;
                        if (!removed[nx][ny]) continue;

                        outside[nx][ny] = true;
                        deq.add(new int[]{nx, ny});
                    }
                }

                List<int[]> list = new ArrayList<>();

                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        if (removed[i][j]) continue;
                        if (storage[i].charAt(j) != target) continue;

                        if (i == 0 || i == n - 1 || j == 0 || j == m - 1) {
                            list.add(new int[]{i, j});
                            continue;
                        }

                        for (int d = 0; d < 4; d++) {
                            int nx = i + dx[d];
                            int ny = j + dy[d];

                            if (outside[nx][ny]) {
                                list.add(new int[]{i, j});
                                break;
                            }
                        }
                    }
                }

                for (int[] pos : list) {
                    removed[pos[0]][pos[1]] = true;
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!removed[i][j]) answer++;
            }
        }

        return answer;
    }
}