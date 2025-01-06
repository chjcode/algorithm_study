import java.util.*;
import java.lang.*;
import java.io.*;

class Main
{
    static int n,x,y;
    static Point[] graph;
    
    static class Point implements Comparable<Point>{
        int x;
        int y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        @Override
        public int compareTo(Point p) {
            return this.x - p.x;
        }
    }
    
	public static void main (String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
        
        n = Integer.parseInt(br.readLine());
        graph = new Point[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            graph[i] = new Point(x,y);
        }
        
        Arrays.sort(graph);

        int answer = 0;
        int a = graph[0].x;
        int b = graph[0].y;
        int maxIdx = 0;
        for (int i = 1; i < n; i++) {
            if (b <= graph[i].y) {
                answer += (graph[i].x - a) * b;
                a = graph[i].x;
                b = graph[i].y;
                maxIdx = i;
            }
        }
        
        answer += b;
        
        int c = graph[n-1].x;
        int d = graph[n-1].y;
        for (int i = n-2; i > maxIdx-1; i--) {
            if (d <= graph[i].y) {
                answer += (c - graph[i].x) * d;
                c = graph[i].x;
                d = graph[i].y;
            }
        }
        
        System.out.println(answer);
	}
}
