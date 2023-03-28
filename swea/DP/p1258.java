package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int t, n, num;
	static int[][] arr;
	static boolean[][] visited;
	static int[] dx = { 1, 0 };
	static int[] dy = { 0, 1 };
	static ArrayList<Position> list;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc < t + 1; tc++) {
			n = Integer.parseInt(br.readLine());
			num = 0;
			arr = new int[n][n];
			visited = new boolean[n][n];
			list = new ArrayList<Position>();

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					bfs(i, j);
				}
			}

			Collections.sort(list);
			
			System.out.print("#" + tc + " " + list.size() + " ");
			for (Position p : list) {
				System.out.print(p.y + " " + p.x + " ");
			}
			System.out.println();
		}
	}

	public static void bfs(int x, int y) {
		Queue<Position> q = new LinkedList<Position>();
		q.add(new Position(x,y));
		
		while(!q.isEmpty()) {
			Position p = q.poll();
			
			for (int i = 0; i < 2; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				
				if(nx >= n || ny >= n || nx < 0 || ny < 0 || arr[ny][nx] == 0 || arr[y][x] == 0) continue;
				
				if(visited[ny][nx] == true) continue;
				
				q.add(new Position(nx, ny));
				visited[ny][nx] = true;
			}
			
			if(q.isEmpty() && ((p.x != x) || (p.y != y))) {
				list.add(new Position(p.x - x + 1,p.y - y + 1));
			}
		}
	}

	public static class Position implements Comparable<Position>{
		int x, y;

		public Position(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		public Position() {
			super();
		}

		@Override
		public String toString() {
			return "Position [x=" + x + ", y=" + y + "]";
		}

		@Override
		public int compareTo(Position o) {
			if(x*y == o.x*o.y) 
				return y-o.y;
			else 
				return x*y - o.x*o.y;
		}
	}
}
