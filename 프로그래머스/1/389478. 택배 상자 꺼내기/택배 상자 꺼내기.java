class Solution {
    public int solution(int n, int w, int num) {
        int row = (num - 1) / w;
        int posInRow = (num - 1) % w;
        int col;
        if (row % 2 == 0) {
            col = posInRow;
        } else {
            col = (w - 1) - posInRow;
        }

        int totalRows = (n + w - 1) / w;
        
        int count = 1;
        
        for (int r = row + 1; r < totalRows; r++) {
            if (r != totalRows - 1) {
                count++;
            } else {
                int lastRowBoxes = n % w == 0 ? w : n % w;
                if (r % 2 == 0) {
                    if (col < lastRowBoxes) {
                        count++;
                    }
                } else {
                    if (col >= w - lastRowBoxes) {
                        count++;
                    }
                }
            }
        }
        
        return count;
    }
}