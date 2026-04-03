class Solution {
    
    static char[] alpha = {'A', 'E', 'I', 'O', 'U'};
    static char[] arr = new char[5];
    static char[] target;
    
    static int count;
    static int answer;
    static boolean found;
    
    public int solution(String word) {
        target = word.toCharArray();
        count = 0;
        answer = 0;
        found = false;
        
        dfs(0);
        
        return answer;
    }
    
    private static void dfs(int depth) {
        if (found) return;
        
        if (depth > 0) {
            count++;
            
            if (depth == target.length) {
                boolean same = true;
                
                for (int i = 0; i < depth; i++) {
                    if (arr[i] != target[i]) {
                        same = false;
                        break;
                    }
                }
                
                if (same) {
                    answer = count;
                    found = true;
                    return;
                }
            }
        }
        
        if (depth == 5) return;
        
        for (int i = 0; i < 5; i++) {
            arr[depth] = alpha[i];
            dfs(depth + 1);
        }
    }
}