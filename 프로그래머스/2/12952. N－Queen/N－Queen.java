class Solution {
    int answer = 0;
    int n;
    int[] board;

    public int solution(int n) {
        this.n = n;
        board = new int[n];

        dfs(0);

        return answer;
    }

    void dfs(int row) {
        if (row == n) {
            answer++;
            return;
        }

        for (int col = 0; col < n; col++) {
            board[row] = col;

            if (check(row)) {
                dfs(row + 1);
            }
        }
    }

    boolean check(int row) {
        for (int i = 0; i < row; i++) {
            if (board[i] == board[row]) {
                return false;
            }

            if (Math.abs(row - i) == Math.abs(board[row] - board[i])) {
                return false;
            }
        }

        return true;
    }
}