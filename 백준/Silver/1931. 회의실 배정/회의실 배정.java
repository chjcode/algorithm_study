
import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static Meeting[] meetings;

    static class Meeting implements Comparable<Meeting>{
        int start;
        int end;

        Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Meeting m) {
            if (this.end == m.end) {
                return this.start - m.start;
            }
            return this.end - m.end;
        }

    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        meetings = new Meeting[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            meetings[i] = new Meeting(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(meetings);

        int answer = 1;
        int before = meetings[0].end;
        for (int i = 1; i < n; i++) {
            if (meetings[i].start >= before) {
                answer++;
                before = meetings[i].end;
            }
        }

        System.out.println(answer);

    }
}
