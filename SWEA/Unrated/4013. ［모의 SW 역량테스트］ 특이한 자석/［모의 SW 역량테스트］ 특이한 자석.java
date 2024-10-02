import java.io.*;
import java.util.*;

public class Solution {

	static int k;
	static Deque<Integer>[] deq;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc < t+1; tc++) {
			k = Integer.parseInt(br.readLine());
			
			deq = new ArrayDeque[4];
			for (int i = 0; i< 4; i++) {
				deq[i] = new ArrayDeque<>();
			}
			
			for (int i = 0; i < 4; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 8; j++) {
					deq[i].addLast(Integer.parseInt(st.nextToken()));
				}
			}
			
			for (int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine());
				int idx = Integer.parseInt(st.nextToken())-1;
				int dir = Integer.parseInt(st.nextToken());
				
				List<Integer> lst = new ArrayList<>(deq[idx]);
				
				left(lst.get(6), idx-1, -dir);
				right(lst.get(2), idx+1, -dir);
				
				rotate(idx,dir);
			}
			
			int result = 0;
			
			if (deq[0].peekFirst() == 1) result += 1;
            if (deq[1].peekFirst() == 1) result += 2;
            if (deq[2].peekFirst() == 1) result += 4;
            if (deq[3].peekFirst() == 1) result += 8;

            System.out.println("#" + tc + " " + result);
			
		}
		
		
	}
	
	private static void rotate(int idx, int dir) {
		if (dir == 1) {
			deq[idx].addFirst(deq[idx].pollLast());
		} else {
			deq[idx].addLast(deq[idx].pollFirst());
		}
	}
	
	private static void left(int num, int idx, int dir) {
		if (idx < 0) return;
		
		List<Integer> lst = new ArrayList<>(deq[idx]);
		if (lst.get(2) != num) {
			left(lst.get(6), idx-1, -dir);
			rotate(idx,dir);
		}
	}
	
	private static void right(int num, int idx, int dir) {
        if (idx > 3) return;

        List<Integer> lst = new ArrayList<>(deq[idx]);
        if (lst.get(6) != num) {
            right(lst.get(2), idx + 1, -dir);
            rotate(idx, dir);
        }
    }

}
