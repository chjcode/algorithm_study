
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        for (int tc = 1; tc < t+1; tc++) {
            st = new StringTokenizer(br.readLine());

            int hour1 = Integer.parseInt(st.nextToken());
            int minute1 = Integer.parseInt(st.nextToken());
            int hour2 = Integer.parseInt(st.nextToken());
            int minute2 = Integer.parseInt(st.nextToken());

            int hour = hour1 + hour2;
            int minute = minute1 + minute2;

            if (minute >= 60) {
                hour += 1;
                minute %= 60;
            }

            hour %= 12;
            if (hour == 0) {
                hour = 12;
            }

            System.out.println("#" + tc + " " + hour + " " + minute);
        }
    }
}
