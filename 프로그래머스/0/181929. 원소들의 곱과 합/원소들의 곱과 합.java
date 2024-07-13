class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        
        int m = 1;
        int p = 0;
        
        for (int i = 0; i < num_list.length;i++){
            m *= num_list[i];
            p += num_list[i];
        }
        
        if (m < p*p){
            answer = 1;
        }
        
        return answer;
    }
}