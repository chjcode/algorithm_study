import java.util.*;
import java.io.*;

public class Main {
    static char[][] graph;
    static int[] dx = {1,0,1,1};
    static int[] dy = {0,1,1,-1};

    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        // 1. x 개수가 o 개수보다 1개 더 많거나 같아야 함.
        // 2. x가 연결되어 있으면, x가 o보다 1개 더 많아야함
        // 3. o가 연결되어 있으면, x와 o의 개수가 같아야 함.

        
        while (true) {
            String s = br.readLine();
            if (s.equals("end")) break;
            
            int cntX = 0;
            int cntO = 0;
            
            graph = new char[3][3];
            for (int i = 0; i < 9; i++) {
                char temp = s.charAt(i);
                if (temp == 'X') cntX++;
                else if (temp == 'O') cntO++;
                graph[i/3][i%3] = temp;
            }
            
            boolean Owin = false;
            boolean Xwin = false;
            
            for (int i = 0; i < 3; i++) {
        		for (int j = 0; j < 3; j++) {
        			if (graph[i][j] == 'O') {
        				if (check(i,j,'O') == 3) Owin = true;
        			}
        		}
        	}
            
            for (int i = 0; i < 3; i++) {
        		for (int j = 0; j < 3; j++) {
        			if (graph[i][j] == 'X') {
        				if (check(i,j,'X') == 3) Xwin = true;
        			}
        		}
        	}
            
            
            Boolean answer = false;
            if (Xwin && !Owin && cntX == cntO + 1) {
            	answer = true;
            } else if (Owin && !Xwin && cntX == cntO) {
            	answer = true;
            } else if (!Xwin && !Owin && cntX + cntO == 9 && cntX > cntO) {
            	answer = true;
            }
            
            if (answer) {
            	System.out.println("valid");
            } else {
            	System.out.println("invalid");
            }
        }  
  }
  
  private static int check(int x, int y, char find) {
	  int maxCnt = 0;
	  for (int i = 0; i < 4; i++) {
		  int cnt = 1;
		  int tempX = x;
		  int tempY = y;
		  while (true) {
			  int nx = tempX + dx[i];
			  int ny = tempY + dy[i];
			  if (nx < 0 || nx > 2 || ny < 0 || ny > 2) break;
			  if (graph[nx][ny] == find) {
				  tempX = nx;
				  tempY = ny;
				  cnt++;
			  } else {
				  break;
			  }
		  }
		  
		  maxCnt = Math.max(maxCnt, cnt);
		  if (maxCnt == 3) return maxCnt;
	  }
      return maxCnt;
  }

  
}