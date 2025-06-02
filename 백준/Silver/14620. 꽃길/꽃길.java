import java.util.*;
import java.io.*;

public class Main{
    
    static class Point{
        int x;
        int y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    static class Flower {
        int cost;
        Point[] points;
        
        Flower(int cost, Point[] points) {
            this.cost = cost;
            this.points = points;
        }
    }
    
   
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        int[][] graph = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int[] dx = {0,0,0,1,-1};
        int[] dy = {0,1,-1,0,0};
        List<Flower> flowers = new ArrayList<>();
        for (int x = 1; x < n-1; x++) {
            for (int y = 1; y < n-1; y++) {
                int cost = 0;
                Point[] point = new Point[5];
                
                for (int i = 0; i < 5; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    cost += graph[nx][ny];
                    point[i] = new Point(nx,ny);
                }
                flowers.add(new Flower(cost, point));
            }
        }
        
        int answer = Integer.MAX_VALUE;
        int size = flowers.size();
        for (int i = 0; i < size - 2; i++) {
            Flower f1 = flowers.get(i);
            for (int j = i+1; j < size - 1; j++) {
                Flower f2 = flowers.get(j);
                
                if (check(f1, f2)) continue;
                
                for (int k = j+1; k < size; k++) {
                    Flower f3 = flowers.get(k);
                    
                    if (check(f1, f3) || check(f2, f3)) continue;
                    
                    answer = Math.min(answer, f1.cost + f2.cost + f3.cost);
                }
            }
        }
        
        System.out.println(answer);
        
    }
    
    private static boolean check(Flower f1, Flower f2) {
        for (Point p1 : f1.points) {
            for (Point p2 : f2.points) {
                if (p1.x == p2.x && p1.y == p2.y) {
                    return true;
                }
            }
        }
        return false;
    }
}