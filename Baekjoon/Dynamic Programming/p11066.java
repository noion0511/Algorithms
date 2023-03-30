import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class p11066 {

	static int t, n;
	static int[] sum, novel;
	static int[][] dp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		t = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < t; tc++) {
			n = Integer.parseInt(br.readLine());
			novel = new int[n + 1];
			sum = new int[n + 1];
			dp = new int[n + 1][n + 1];

			st = new StringTokenizer(br.readLine());
			for (int i = 1; i < n+1; i++) {
				novel[i] = Integer.parseInt(st.nextToken());
				sum[i] = sum[i - 1] + novel[i];
			}
			
			for (int i = 1; i <= n; i++) {
				for (int from = 1; from + i <= n; from++) {
					int to = from + i;
					dp[from][to] = Integer.MAX_VALUE;
					for (int d = from; d < to; d++) {
						dp[from][to] = Math.min(dp[from][to], dp[from][d] + dp[d+1][to] + sum[to] - sum[from-1]);
					}
				}
			}
			System.out.println(dp[1][n]);
			
//			for (int i = 0; i < n+1; i++) {
//				for (int j = 0; j < n+1; j++) {
//					System.out.print(dp[i][j] + "\t");
//				}
//				System.out.println();
//			}
		}
	}
}
