class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        
        String ab = Integer.toString(a) + Integer.toString(b);
        String ba = Integer.toString(b) + Integer.toString(a);
        
        int abNum = Integer.parseInt(ab);
        int baNum = Integer.parseInt(ba);
        
        if (abNum >= baNum){
            answer = abNum;
        } else{
            answer = baNum;
        }
        
        return answer;
    }
}