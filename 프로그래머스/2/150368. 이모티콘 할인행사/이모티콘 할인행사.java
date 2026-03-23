class Solution {
    
    int[] answer = new int[2];
    int n;
    int[] discounts;
    
    public int[] solution(int[][] users, int[] emoticons) {
        
        n = emoticons.length;
        discounts = new int[n];
        
        dfs(0, 0, 0, users, emoticons);
        
        return answer;
    }
    
    private void dfs(int depth, int plus, int price, int[][] users, int[] emoticons) {
        if (depth == n) {
            plus = 0;
            price = 0;
            
            for (int[] user : users) {
                int sum = 0;
                
                for (int i = 0; i < n; i++) {
                    if (discounts[i] >= user[0]) {
                        sum += emoticons[i] * (100 - discounts[i]) / 100;
                    }
                }
                
                if (sum >= user[1]) plus++;
                else price += sum;
            }
            
            if (plus > answer[0]) {
                answer[0] = plus;
                answer[1] = price;
            } else if (plus == answer[0] && price > answer[1]) {
                answer[1] = price;
            }
            return;
        }
        
        int[] rates = {10, 20, 30, 40};
        for (int rate : rates) {
            discounts[depth] = rate;
            dfs(depth + 1, plus, price, users, emoticons);
        }
    }
}