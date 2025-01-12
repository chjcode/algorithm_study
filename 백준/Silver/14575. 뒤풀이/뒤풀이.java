import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static long t;
    static Person[] people;

    static class Person {
        int l, r;
        Person(int l, int r) {
            this.l = l;
            this.r = r;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        t = Long.parseLong(st.nextToken());

        people = new Person[n];
        long sumOfL = 0;
        long sumOfR = 0;
        int maxR = 0;  // (왼쪽 범위는 나중에 설명)

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            people[i] = new Person(l, r);
            sumOfL += l;
            sumOfR += r;
            maxR = Math.max(maxR, r);
        }

        // 사전 체크: 절대 불가능한 경우
        if (sumOfL > t || sumOfR < t) {
            System.out.println(-1);
            return;
        }

        // 이분 탐색 범위 설정
        // left를 0으로 해도 되지만, 어차피 S < max(L_i)인 경우는 전부 불가능하므로
        // 조금이라도 연산을 줄이려면 left = min(L_i) 또는 max(L_i)를 잡기도 합니다.
        // 여기서는 간단히 0 ~ maxR 로 진행
        int left = 0;
        int right = maxR;
        int answer = -1;

        while (left <= right) {
            int mid = (left + right) / 2;  // 후보 S

            // 1) mid < 어떤 사람의 L_i -> 불가능
            long sumMin = 0;
            long sumMax = 0;
            boolean possible = true;

            for (Person p : people) {
                if (p.l > mid) {
                    // 이 경우 mid로는 절대 L_i 이상을 줄 수 없음 -> 불가능
                    possible = false;
                    break;
                }
                sumMin += p.l;
                sumMax += Math.min(p.r, mid);
            }

            if (!possible) {
                // mid가 너무 작아서 불가능 -> 더 키워야 함
                left = mid + 1;
                continue;
            }

            // 2) sumMin <= t <= sumMax 체크
            if (sumMin <= t && t <= sumMax) {
                // mid로 가능 -> 더 작은 값이 가능한지 확인
                answer = mid;
                right = mid - 1;
            } else {
                // sumMin > t -> 이미 최소로 줘도 T 초과 -> S 줄여야 하지만...
                // 하지만 sumMin 계산에서 mid < L_i일 땐 위에서 걸러짐.
                // 어쨌든 여기서는 T에 못 맞추므로 더 큰 S가 필요
                left = mid + 1;
            }
        }

        System.out.println(answer);
    }
}