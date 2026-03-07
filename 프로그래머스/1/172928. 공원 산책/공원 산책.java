import java.util.*;

class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        
        Map<Character, Integer> direction = new HashMap<>();
        direction.put('E', 0);
        direction.put('W', 1);
        direction.put('S', 2);
        direction.put('N', 3);
        
        
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};
        
        int x = -1;
        int y = -1;
        int n = park.length;
        int m = park[0].length();
        boolean flag = false;
        for (int i = 0; i < n; i++) {
            String s = park[i];
            for (int j = 0; j < m; j++) {
                char c = s.charAt(j);
                if (c == 'S') {
                    x = i;
                    y = j;
                    flag = true;
                    break;
                }
            }
            
            if (flag) break;
        }
        
        for (String route : routes) {
            String[] r = route.split(" ");
            boolean check = true;
            int tempX = x;
            int tempY = y;
            for (int i = 0; i < Integer.parseInt(r[1]); i++) {
                int nx = tempX + dx[direction.get(r[0].charAt(0))];
                int ny = tempY + dy[direction.get(r[0].charAt(0))];
                if (nx < 0 || nx > (n-1) || ny < 0 || ny > (m-1)) {
                    check = false;
                    break;
                }
                
                if (park[nx].charAt(ny) == 'X') {
                    check = false;
                    break;
                } else {
                    tempX = nx;
                    tempY = ny;
                }
            }
            
            if (check) {
                x = tempX;
                y = tempY;
            }
        }
        
        answer[0] = x;
        answer[1] = y;
        
        return answer;
    }
}