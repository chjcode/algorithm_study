import java.util.*;
import java.io.*;

public class Solution {

    static int n,k,answer;
    static int[][] graph;
    static boolean[][] visited;
    static List<Point> highest;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    
    static class Point{
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int t = Integer.parseInt(br.readLine());
        
        for (int tc = 1; tc < t+1; tc++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            
            graph = new int[n][n];
            int maxHeight = 0;
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    graph[i][j] = Integer.parseInt(st.nextToken());
                    maxHeight = Math.max(maxHeight, graph[i][j]);
                }
            }
            
            highest = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (graph[i][j] == maxHeight) {
                        highest.add(new Point(i,j));
                    }
                }
            }
            
            answer = 0;
            visited = new boolean[n][n];
            for (int i = 0; i < highest.size();i++) {
                visited[highest.get(i).x][highest.get(i).y] = true;
                dfs(1,0,graph[highest.get(i).x][highest.get(i).y],highest.get(i));
                visited[highest.get(i).x][highest.get(i).y] = false;
            }
            
            System.out.println("#" + tc + " " + answer);
        }
    }
    
    private static void dfs(int cnt, int dig, int height, Point point) {
        // 땅파기 사용하고 더이상 진행 불가면 종료
        for (int i = 0; i < 4; i++) {
            int nx = point.x + dx[i];
            int ny = point.y + dy[i];
            
            if (nx < 0 || nx > (n-1) || ny < 0 || ny > (n-1)) continue;
            
            // 현재 위치보다 다음 위치가 더 낮은 지형이면 계속해서 탐색
            if (height > graph[nx][ny] && !visited[nx][ny]) {
                
                visited[nx][ny] = true;
                dfs(cnt+1,dig,graph[nx][ny],new Point(nx,ny));
                visited[nx][ny] = false;
            }
            // 현재 위치보다 다음 위치가 더 낮지 않고, 땅파기가 사용 가능하면
            else if (dig == 0 && !visited[nx][ny]) { 
                for (int j = 1; j <= k; j++) {
                	if(graph[nx][ny] - j >= graph[point.x][point.y]) continue;
                    visited[nx][ny] = true;
                    dfs(cnt+1,dig+1,graph[nx][ny]-j,new Point(nx,ny));
                    visited[nx][ny] = false;    
                }
            }
            
        }
        answer = Math.max(answer, cnt);
    }

}