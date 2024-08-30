import java.io.*;
import java.util.*;

public class Solution {

	static int n;
	static int[][] graph;
	static List<Person> persons;
	static List<Stair> stairs;
	static PriorityQueue<Integer> stair1, stair2;

	static class Person {
		int x;
		int y;
		int dist = 0;

		Person(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static class Stair {
		int x;
		int y;
		int time;

		Stair(int x, int y, int time) {
			this.x = x;
			this.y = y;
			this.time = time;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			n = Integer.parseInt(br.readLine());
			graph = new int[n][n];
			persons = new ArrayList<>();
			stairs = new ArrayList<>();

			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					int num = Integer.parseInt(st.nextToken());
					if (num == 1) {
						persons.add(new Person(i, j));
					} else if (num > 1) {
						stairs.add(new Stair(i, j, num));
					}
				}
			}

			int minTime = Integer.MAX_VALUE;
			stair1 = new PriorityQueue<>();
			stair2 = new PriorityQueue<>();
			// 비트 마스킹을 사용해서 사람들이 계단을 선택하는 모든 부분집합을 구함
			for (int i = 0; i < (1 << persons.size()); i++) {
				int[] dist = new int[persons.size()]; // 사람과 계단 사이 거리 구한 배열
				for (int j = 0; j < persons.size(); j++) {
					Person p = persons.get(j);
					if ((i & (1 << j)) == 0) {
						stair1.add(Math.abs(p.x - stairs.get(0).x) + Math.abs(p.y - stairs.get(0).y));
					} else {
						stair2.add(Math.abs(p.x - stairs.get(1).x) + Math.abs(p.y - stairs.get(1).y));
					}
				}

				int time = simulate();
				minTime = Math.min(minTime, time);
			}

			System.out.println("#" + tc + " " + minTime);
		}
	}

	// 모든 사람이 계단을 내려가는데 걸리는 시간 시뮬 돌리며 계산
	static int simulate() {
		int stair1Time = 0;
		int stair2Time = 0;
		Deque<Integer> deq = new ArrayDeque<>();
		int cost = stairs.get(0).time;
		while (!stair1.isEmpty()) {
			int in = stair1.poll() + 1; // 계단에 들어가는데 걸리는 시간
			if (deq.size() < 3) {
				deq.addLast(in + cost);
			} else {
				int front = deq.pollFirst();
				if (front <= in) { // 4번째 사람이 도착하기 전에 1번째 사람이 계단을 다 내려갔으면
					deq.addLast(in + cost); // 4번째 사람이 걸리는 시간이 새로운 기준이 됨
				} else {	// 아직 계단을 다 내려가지 못했으면
					deq.addLast(front + cost);	// 앞사람이 탈출한 시간 + 계단 내려가는시간
				}
			}
		}
		
		if (!deq.isEmpty()) {
			stair1Time = deq.peekLast();	
		}
		
		deq = new ArrayDeque<>();
		cost = stairs.get(1).time;
		while (!stair2.isEmpty()) {
			int in = stair2.poll() + 1;	// 계단에 도착시간 + 대기시간
			if (deq.size() < 3) {	// 계단 이용중인 사람이 3명 미만이면
				deq.addLast(in+cost);	// 큐에 추가
			}else {
				int front = deq.pollFirst();	// 계단 이용중인 사람이 3명 이상이면
				// 계단 이용중인 사람 중 맨 앞사람이걸린 시간이랑 다음 사람이 계단에 오는 시간이랑 비교
				if (front <= in) { 		// 이미 내려갔으면
					deq.addLast(in+cost);	// 다음 사람이 탈출하는데 걸리는 시간이 새로운 기준이 됨
				} else {	// 아직 계단을 다 내려가지 못했으면 
					deq.addLast(front+cost);	// 계단 이용중인 사람 중 맨 앞 사람이 탈출하는데 걸린 시간 + 계단 이용할 사람이 대기하다가 계단을 이용해 내려가는데 걸리는 시간
				}
				
			}
		}
		
		
		if (!deq.isEmpty()) {
			stair2Time = deq.peekLast();	
		}
		
		return Math.max(stair1Time, stair2Time);
	}
	
}
