package p2252;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class p1005 {
	static int t, n, k, target;
	static int[] price, map, degree;
	static List<Integer>[] input;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		t = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc < t; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			map = new int[n+1];
			price = new int[n+1];
			degree = new int[n+1];
			input = new ArrayList[n+1];
			
			for (int i = 1; i < n+1; i++) {
				input[i] = new ArrayList<Integer>();
			}
			
			for (int i = 1; i < n+1; i++) {
				price[i] = Integer.parseInt(st.nextToken());
				map[i] = price[i];
			}
			
			for (int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				input[x].add(y);
				degree[y]++;
			}
			
			target = Integer.parseInt(br.readLine());
			
			Queue<Integer> q = new LinkedList<>();
			
			for (int i = 1; i < n+1; i++) {
				if(degree[i] == 0) {
					q.add(i);
					degree[i] = -1;
				}
			}
			
			while(!q.isEmpty()) {
				int num = q.poll();
				
				for (int in : input[num]) {
					degree[in] -= 1;
					map[in] = Math.max(map[in], map[num] + price[in]);
				}
				
				for (int i = 1; i < n+1; i++) {
					if(degree[i] == 0) {
						q.add(i);
						degree[i] = -1;
					}
				}
			}
			
			System.out.println(map[target]);
		}
	}
}
