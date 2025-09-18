import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String line;
        int tc = 1;

        while ((line = br.readLine()) != null) {
            line = line.trim();
            if (line.isEmpty()) continue;
            StringTokenizer st = new StringTokenizer(line);
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());
            if (a == 0 && b == 0) break;

            long mStart = (long)Math.sqrt(a);
            if (mStart * mStart <= a) mStart++;

            long mEnd = (long)Math.sqrt(b);
            if (mEnd * mEnd >= b) mEnd--;

            long count = 0;
            for (long m = mStart; m <= mEnd; m++) {
                long s = m*m - 1;
                long t = 8*s + 1;
                if (check(t)) {
                    count++;
                }
            }
            sb.append("Case ").append(tc++).append(": ").append(count).append('\n');
        }
        System.out.print(sb);
    }
    
    static boolean check(long v) {
        if (v < 0) return false;
        long r = (long)Math.sqrt(v);
        if (r * r == v) return true;
        if ((r+1) * (r+1) == v) return true;
        return false;
    }
}
