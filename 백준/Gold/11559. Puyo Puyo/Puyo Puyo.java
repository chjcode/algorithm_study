import java.util.*;
import java.io.*;

public class Main {
    
    static class Point{
        int x;
        int y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    static char[][] arr = new char[12][6];
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static boolean[][] visited;
    static boolean[][] result;
    
    static boolean flag;
    static int answer;
    
    
    static void check(int x, int y, char color, List<Point> lst) {
        lst.add(new Point(x,y));
        
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || nx > 11 || ny < 0 || ny > 5) continue;
            
            if (arr[nx][ny] == color && !visited[nx][ny]) {
                visited[nx][ny] = true;
                check(nx, ny, color, lst);
            }
        }
    }
    
    static void boom() {
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 6; j++) {
                if (result[i][j]) {
                    arr[i][j] = '.';
                }
            }
        }
    }
    
    static void gravity() {
        for (int j = 0; j < 6; j++) {
            int idx = 11;
            for (int i = 11; i >= 0; i--) {
                if (arr[i][j] != '.') {
                    if (idx != i) {
                        arr[idx][j] = arr[i][j];
                        arr[i][j] = '.';   
                    }
                    idx--;
                }
            }
        }
    }
    
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        for (int i = 0; i < 12; i++) {
            String s = br.readLine();
            for (int j = 0; j < 6; j++) {
                arr[i][j] = s.charAt(j);
            }
        }
        
        
        while(true) {
            visited = new boolean[12][6];
            result = new boolean[12][6];
            flag = false;
            
            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 6; j++) {
                    if (arr[i][j] != '.' && !visited[i][j]) {
                        visited[i][j] = true;
                        
                        List<Point> lst = new ArrayList<>();
                        check(i,j, arr[i][j], lst);
                        
                        if (lst.size() >= 4) {
                            flag = true;
                            for (Point p : lst) {
                                result[p.x][p.y] = true;
                            }
                        }

                    }
                }
            }
            if (!flag) break;
            boom();
            gravity();
            answer++;
            
            
        }
        
        System.out.println(answer);
    }
}