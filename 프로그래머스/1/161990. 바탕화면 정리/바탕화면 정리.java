class Solution {
    public int[] solution(String[] wallpaper) {

        int minRow = Integer.MAX_VALUE;
        int minCol = Integer.MAX_VALUE;
        int maxRow = 0;
        int maxCol = 0;

        for (int i = 0; i < wallpaper.length; i++) {
            for (int j = 0; j < wallpaper[i].length(); j++) {
                if (wallpaper[i].charAt(j) == '#') {
                    minRow = Math.min(minRow, i);
                    minCol = Math.min(minCol, j);
                    maxRow = Math.max(maxRow, i);
                    maxCol = Math.max(maxCol, j);
                }
            }
        }

        int[] answer = new int[4];
        answer[0] = minRow;
        answer[1] = minCol;
        answer[2] = maxRow + 1;
        answer[3] = maxCol + 1;

        return answer;
    }
}