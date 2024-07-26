import java.util.*;
import java.io.*;

public class Main {

    static int t,n,m;
    static long answer;
    static int[] a,b;
    static List<Long> aSum,bSum;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        t = Integer.parseInt(br.readLine());
        n = Integer.parseInt(br.readLine());
        a = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        m = Integer.parseInt(br.readLine());
        b = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

//		// 누적합
//		for (int i = 1; i < n; i++) {
//			a[i] += a[i-1];
//		}
//		for (int i = 1; i < m; i++) {
//			b[i] += b[i-1];
//		}
//
        // 부분 배열의 합 저장
//		int aSize = n*(n+1)/2;
//		int bSize = m*(m+1)/2;
//		aSum = new long[aSize];
//		bSum = new long[bSize];
//		for (int i = 0; i < n; i++) {
//			for (int j = i; j < n; j++) {}
//			int
//		}

        // 부분 배열의 합 저장
        aSum = new ArrayList<>();
        bSum = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            long sum = 0;
            for (int j = i; j < n; j++) {
                sum += a[j];
                aSum.add(sum);
            }
        }

        for (int i = 0; i < m; i++) {
            long sum = 0;
            for (int j = i; j < m; j++) {
                sum += b[j];
                bSum.add(sum);
            }
        }

        // 부분배열의 합 저장한 리스트 정렬
        Collections.sort(aSum);
        Collections.sort(bSum);

        answer = 0;

        int left = 0;
        int right = bSum.size()-1;

        while(left<aSum.size() && right>-1) {
            long a = aSum.get(left);
            long b = bSum.get(right);
            long sum = a+b;

            if (sum < t) {
                left += 1;
            } else if (sum > t) {
                right -= 1;
            } else {
                //sum == t, 중복되는 값 카운트
                long aCnt = 0;
                while (left < aSum.size() && a == aSum.get(left)) {
                    left += 1;
                    aCnt += 1;
                }

                long bCnt = 0;
                while (right > -1 && b == bSum.get(right)) {
                    right -= 1;
                    bCnt += 1;
                }

                answer += aCnt * bCnt;
            }
        }
        System.out.println(answer);
    }

}
