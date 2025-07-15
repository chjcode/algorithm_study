import java.util.*;
import java.io.*;


public class Main {
    static int A, B, C;
    static boolean[][] visited = new boolean[201][201];
    static boolean[] possibleC  = new boolean[201];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        dfs(0, 0);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= 200; i++)
            if (possibleC[i]) sb.append(i).append(' ');
        System.out.println(sb);
    }

    static void dfs(int a, int b) {
        if (visited[a][b]) return;
        visited[a][b] = true;
        int c = C - a - b;
        if (a == 0) possibleC[c] = true;

        move(a, b, c, Math.min(a, B - b), -1, +1);  // A → B
        move(a, b, c, Math.min(a, C - c), -1,  0);  // A → C
        move(a, b, c, Math.min(b, A - a), +1, -1);  // B → A
        move(a, b, c, Math.min(b, C - c),  0, -1);  // B → C
        move(a, b, c, Math.min(c, A - a), +1,  0);  // C → A
        move(a, b, c, Math.min(c, B - b),  0, +1);  // C → B
    }

    static void move(int a, int b, int c, int pour, int diffA, int diffB) {
        if (pour == 0) return;
        int na = a + diffA * pour;
        int nb = b + diffB * pour;
        dfs(na, nb);
    }
}
