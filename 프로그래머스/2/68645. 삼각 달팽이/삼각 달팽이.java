class Solution {
    public int[] solution(int n) {
        int[][] arr = new int[n][n];

        int total = n * (n+1) / 2;

        int[] dx = {1, 0, -1};
        int[] dy = {0, 1, -1};

        int x = 0;
        int y = 0;
        int dir = 0;

        for (int num = 1; num <= total; num++) {
            arr[x][y] = num;

            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (nx < 0 || nx >= n || ny < 0 || ny >= n || arr[nx][ny] != 0) {
                dir = (dir + 1) % 3;

                nx = x + dx[dir];
                ny = y + dy[dir];
            }

            x = nx;
            y = ny;
        }

        int[] answer = new int[total];
        int idx = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                answer[idx++] = arr[i][j];
            }
        }

        return answer;
    }

}