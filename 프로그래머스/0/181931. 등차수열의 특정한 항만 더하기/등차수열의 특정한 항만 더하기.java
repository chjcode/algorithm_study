class Solution {
    public int solution(int a, int d, boolean[] included) {
        int answer = 0;
        // 3 -> 7 -> 11 -> 15 -> 19 : 3 + 15 + 19
        for (int i = 0; i < included.length; i++){
            if (included[i]){
                answer += a+(i)*d;
            }
        }
        
        return answer;
    }
}