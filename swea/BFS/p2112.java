package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	/*
	 * 보호 필름 1. 가로, 세로, 기준 두께가 들어오면 세로로 모든 칸이 기준 두께를 준수하는지 확인 2. 만약 k만큼 연속되는 부분이 없는
	 * 칸이 있다면, 0과 1을 인식하여, 세로 칸을 모두 하나씩 번갈아가면서 0이라면 1로 1이라면 0으로 바꿔본다. 3. 바꾼 상태에서 기준을
	 * 통과하면 리턴 바꾼 상태에서 기준을 통과하지 않으면 다음칸으로 넘어가서 검사한다. 모든 칸을 돌았지만 기준을 통과하지 못하면, cnt+1
	 */

	static int t, d, w, k, ans;
	static int[][] numbers;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc < t + 1; tc++) {
			ans = Integer.MAX_VALUE;
			st = new StringTokenizer(br.readLine());
			d = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());

			numbers = new int[d][w];

			for (int i = 0; i < d; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					numbers[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			find(0, 0);

			System.out.println("#" + tc + " " + ans);
		}
	}

	public static void find(int cnt, int idx) {
		int[] temp = new int[w];
		
		if(check()) {
			ans = Math.min(ans, cnt);
			return;
		}
		
		if(cnt > ans) return;
		if(idx == d) return;
		
		
		for (int i = 0; i < w; i++) {
			temp[i] = numbers[idx][i];
		}
		
		find(cnt, idx + 1);

		for (int i = 0; i < w; i++) {
			numbers[idx][i] = 0;
		}
		
		find(cnt + 1, idx + 1);
		
		for (int i = 0; i < w; i++) {
			numbers[idx][i] = 1;
		}
		
		find(cnt + 1, idx + 1);
		
		for (int i = 0; i < w; i++) {
			numbers[idx][i] = temp[i];
		}
	}
	
	public static boolean check() {
		for (int i = 0; i < w; i++) {
			int count = 1;
			boolean flag = false;
			
			for (int j = 1; j < d; j++) {
				if(numbers[j][i] == numbers[j-1][i]) count++;
				else count = 1;
				
				if(count == k) {
					flag = true;
					break;
				}
			}
			
			if(!flag) return false;
		}
		
		return true;
	}
}
