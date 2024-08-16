import java.util.*;
import java.io.*;

public class Main {
	
	static int s,p,answer;
	static String dna;
	static int[] acgt;
	static int[] acgtCnt, currentCnt;
	
	public static void main(String[] args) throws Exception {
		//1. 백트래킹으로 모든 부분집합을 구하면서 조건에 맞으면 더하기 -> 개느림
		//2. 부분집합을 구하는 문제가 아니라 부분문자열을 구하는 문제이다. 문자열의 순서 유지
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		//문자열 길이, 부분문자열 길이 입력 받기
		st = new StringTokenizer(br.readLine());
		s = Integer.parseInt(st.nextToken());
		p = Integer.parseInt(st.nextToken());
		// 문자열 입력 받기
		dna = br.readLine();
		// 부분 문자열 입력 받기
		acgt = new int[4];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < 4; i++) {
			acgt[i] = Integer.parseInt(st.nextToken());
		}
		
		// A,C,G,T의 개수를 저장할 배열 초기화
		acgtCnt = new int[4];
		// 첫 윈도우값(부분문자열) 중 acgt개수 확인
		for (int i = 0; i < p; i++) {
			addAcgt(dna.charAt(i));
		}
		
		// window(부분문자열)가 조건을 만족하는지  확인
		if (checkCurrentAcgt()) {
			answer++;
		}
		// 슬라이딩 윈도우로 만들수 있는 부분문자열 탐색
		for (int i = 0; i < s-p;i++) {
			removeAcgt(dna.charAt(i));
			addAcgt(dna.charAt(i+p));
			if (checkCurrentAcgt()) {
				answer++;
			}
		}
		
		System.out.println(answer);
	}
	
	private static void addAcgt(char alphabet) {
		if (alphabet == 'A') {
			acgtCnt[0]++;
		} else if (alphabet == 'C') {
			acgtCnt[1]++;
		} else if (alphabet == 'G') {
			acgtCnt[2]++;
		} else if (alphabet == 'T') {
			acgtCnt[3]++;
		}
	}
	
	private static void removeAcgt(char alphabet) {
		if (alphabet == 'A') {
			acgtCnt[0]--;
		} else if (alphabet == 'C') {
			acgtCnt[1]--;
		} else if (alphabet == 'G') {
			acgtCnt[2]--;
		} else if (alphabet == 'T') {
			acgtCnt[3]--;
		}
	}
	
	private static boolean checkCurrentAcgt() {
		for (int i = 0; i < 4; i++) {
			if (acgtCnt[i] < acgt[i]) {
				return false;
			}
		}
		return true;
	}

}
