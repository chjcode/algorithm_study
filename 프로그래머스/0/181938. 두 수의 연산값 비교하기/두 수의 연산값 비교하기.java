class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        
        String aPb = Integer.toString(a) + Integer.toString(b);
        
        int aMb = 2*a*b;
        
        return Math.max(Integer.parseInt(aPb),aMb);
    }
}