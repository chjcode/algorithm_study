import java.util.*;

class Solution {
    public int solution(int n, int w, int num) {
        
        int h = (n+w-1)/w;
        int[][] arr = new int[h][w];
        
        boolean flag = false;
        int cnt = 1;
        for (int i = h-1; i >= 0; i--) {
            if (!flag) {
                // 좌 -> 우
                for (int j = 0; j < w; j++) {
                    arr[i][j] = cnt;
                    cnt++;
                    flag = true;
                    if (cnt > n) {
                        break;
                    }
                }
            } else {
                // 우 -> 좌
                for (int j = w-1; j >= 0; j--) {
                    arr[i][j] = cnt;
                    cnt++;
                    flag = false;
                    if (cnt > n) {
                        break;
                    }
                }
            }
            if (cnt > n) {
                break;
            }
        }
        
        int findX = -1;
        int findY = -1;
        boolean find = false;

        for (int i = 0; i < h && !find; i++) {
            for (int j = 0; j < w; j++) {

                if (arr[i][j] == num) {
                    findX = i;
                    findY = j;
                    find = true;
                    break;
                }
            }
        }
        
        System.out.println(findX + " " + findY);
        
        int answer = 0;
        for (int i = 0; i <= findX; i++) {
            if (arr[i][findY] != 0) {
                answer++;
            }
        }
        
        return answer;
    }
}