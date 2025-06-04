import java.util.*;
import java.io.*;

public class Main{
    
    static int n,m,k;
    static int[][] board;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        
        board = new int[n][m];
        
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int[][] sticker = new int[r][c];
            
            for (int x = 0; x < r; x++) {
                st = new StringTokenizer(br.readLine());
                for (int y = 0; y < c; y++) {
                    sticker[x][y] = Integer.parseInt(st.nextToken());
                }
            }
            
            for (int rot = 0; rot < 4; rot++) {
                if (attach(sticker)) {
                    break;
                }
                sticker = rotate(sticker);
            }    
        }
        
        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 1) {
                    answer++;
                }
            }
        }
        System.out.println(answer);
        
    }
    
    private static int[][] rotate(int[][] sticker) {
        int r = sticker.length;
        int c = sticker[0].length;
        int[][] temp = new int[c][r];
        
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                temp[j][r-1-i] = sticker[i][j];
            }
        }
        
        return temp;
    }
    
    private static boolean attach(int[][] sticker) {
        for (int i = 0; i < n-sticker.length + 1; i++) {
            for (int j = 0; j < m-sticker[0].length + 1; j++) {
                boolean attachable = true;
                
                for (int r = 0; r < sticker.length; r++) {
                    for (int c = 0; c < sticker[0].length; c++) {
                        if (board[i+r][j+c] == 1 && sticker[r][c] == 1) {
                            attachable = false;
                            break;
                        }
                    }
                    
                    if (!attachable) {
                        break;
                    }
                }
                
                if (attachable) {
                    for (int a = 0; a < sticker.length; a++) {
                        for (int b = 0; b < sticker[0].length; b++) {
                            if (sticker[a][b] == 1) {
                                board[a+i][b+j] = 1;
                            }
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }
    
}