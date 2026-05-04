class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        
        int block = brown + yellow;
        
        for (int m = 2; m <= (int)Math.sqrt(block); m++) {
            int n = block / m;
            if (n * m == block) {
                int tempBrown = 2 * n + 2 * m - 4;
                if (tempBrown == brown) {
                    answer = new int[]{n,m};
                    break;
                }
            }
            
        }
        return answer;
    }
}