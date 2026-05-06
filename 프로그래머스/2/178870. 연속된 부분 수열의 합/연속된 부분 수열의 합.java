class Solution {
    public int[] solution(int[] sequence, int k) {
        int n = sequence.length;

        int left = 0;
        int right = 0;
        int sum = sequence[0];

        int[] answer = {0, n - 1};
        int minLength = n;

        while (left < n && right < n) {
            if (sum == k) {
                int length = right - left;

                if (length < minLength) {
                    minLength = length;
                    answer[0] = left;
                    answer[1] = right;
                }
            }

            if (sum >= k) {
                sum -= sequence[left];
                left++;

                if (left > right && left < n) {
                    right = left;
                    sum = sequence[left];
                }
            } else {
                right++;

                if (right < n) {
                    sum += sequence[right];
                }
            }
        }

        return answer;
    }
}