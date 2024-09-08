import java.util.*;
import java.io.*;

public class Main {

    static int n,m, card;
    static int[] cards;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        cards = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(cards);

        m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            card =  Integer.parseInt(st.nextToken());
            int count = upperBound(card) - lowerBound(card);
            sb.append(count).append(" ");

        }

        System.out.println(sb.toString());
    }

    private static int lowerBound(int num) {
        int left = 0;
        int right = cards.length;

        while (left < right) {
            int mid = (left + right) / 2;
            if (cards[mid] < num) {
                left = mid + 1;
            }else {
                right = mid;
            }
        }

        return left;
    }

    private static int upperBound(int num) {
        int left = 0;
        int right = cards.length;

        while (left < right) {
            int mid = (left + right) / 2;
            if (cards[mid] <= num) {
                left = mid + 1;
            }else {
                right = mid;
            }
        }

        return left;
    }
}
