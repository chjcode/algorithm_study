class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        
        boolean[] arr = new boolean[10];
        for (int num : numbers) {
            if (!arr[num]) {
                arr[num] = true;
                answer += num;
            }
        }
        
        return 45 - answer;
    }
}