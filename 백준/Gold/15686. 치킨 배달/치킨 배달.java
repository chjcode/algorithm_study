
import java.util.*;
import java.io.*;
public class Main {

    static int n,m,answer;
    static List<Point> house, chicken,choose;

    static class Point{
        int x;
        int y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        house = new ArrayList<>();
        chicken = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int temp = Integer.parseInt(st.nextToken());
                if (temp == 1) {
                    house.add(new Point(i+1,j+1));
                } else if (temp == 2) {
                    chicken.add(new Point(i+1,j+1));
                }
            }
        }

        // 치킨집을 모두 리스트에 넣고 이 중 m개를 고르는 combination
        // m개 중에 치킨거리가 가장 작은 것을 고르는 것
        choose = new ArrayList<>();
        answer = Integer.MAX_VALUE;
        combination(0,0);
        System.out.println(answer);
    }

    private static void combination(int start, int cnt) {
        if (cnt == m) {
            int totalLen = 0;
            for (Point h : house) {
                int chickLen = Integer.MAX_VALUE;
                for (Point c: choose) {
                    chickLen = Math.min(chickLen, Math.abs(c.x-h.x) + Math.abs(c.y-h.y));
                }
                totalLen += chickLen;
            }
            answer = Math.min(answer, totalLen);
            return;
        }

        for (int i = start; i < chicken.size(); i++) {
            choose.add(chicken.get(i));
            combination(i+1, cnt+1);
            choose.remove(choose.size()-1);
        }
        return;
    }
}
