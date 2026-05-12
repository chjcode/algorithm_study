class Solution {
    public int solution(int n) {
        int targetCount = Integer.bitCount(n);

        int next = n + 1;

        while (true) {
            if (Integer.bitCount(next) == targetCount) {
                return next;
            }
            next++;
        }
    }
}