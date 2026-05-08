class Solution {
    public int solution(String[] board) {
        int o = 0, x = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                char c = board[i].charAt(j);

                if (c == 'O') o++;
                if (c == 'X') x++;
            }
        }

        if (x > o || o - x > 1) return 0;

        boolean ow = win(board, 'O');
        boolean xw = win(board, 'X');

        if (ow && xw) return 0;
        if (ow && o != x + 1) return 0;
        if (xw && o != x) return 0;

        return 1;
    }

    boolean win(String[] b, char c) {
        for (int i = 0; i < 3; i++) {
            if (b[i].charAt(0) == c && b[i].charAt(1) == c && b[i].charAt(2) == c) return true;
            if (b[0].charAt(i) == c && b[1].charAt(i) == c && b[2].charAt(i) == c) return true;
        }

        if (b[0].charAt(0) == c && b[1].charAt(1) == c && b[2].charAt(2) == c) return true;
        if (b[0].charAt(2) == c && b[1].charAt(1) == c && b[2].charAt(0) == c) return true;

        return false;
    }
}