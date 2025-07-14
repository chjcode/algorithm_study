import java.util.*;
import java.io.*;

public class Main {
    static List<Long> lst = new ArrayList<>();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i <= 9; i++) {
            dfs(i, i);
        }

        Collections.sort(lst);

        if (n > lst.size()) {
            System.out.println(-1);
        } else {
            System.out.println(lst.get(n-1));
        }
    }

    static void dfs(long now, int lastDigit) {
        lst.add(now);
        for (int i = 0; i < lastDigit; i++) {
            dfs(now * 10 + i, i);
        }
    }
}
