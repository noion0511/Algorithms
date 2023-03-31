package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p2117 {

	/*
	 * 비용 -> f(n) = f(n-1) + 4*(n-1) 최대한 많은 집의 수에 서비스를 제공해야하기 때문에 현재 보안회사의 이익을 계산하고,
	 * 이익이면 저장 -> 다음 n으로 넘어가서 다시
	 * 
	 */

	static int t, n, m, count, answer;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc < t + 1; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			map = new int[n][n];
			answer = 0;

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					visited = new boolean[n][n];
					findHouse(j, i);
				}
			}

			System.out.println("#" + tc + " " + answer);
		}
	}

	public static void findHouse(int x, int y) {
		Queue<Position> q = new LinkedList<>();
		q.add(new Position(x, y));
		visited[y][x] = true;

		int k = 1;
		count = map[y][x] == 1 ? 1 : 0;

		if (calculation(k) <= count * m)
			answer = k > answer ? k : answer;

		while (!q.isEmpty()) {
			int size = q.size();
			k++;

			for (int j = 0; j < size; j++) {
				Position p = q.poll();

				for (int i = 0; i < 4; i++) {
					int nx = dx[i] + p.x;
					int ny = dy[i] + p.y;

					if (nx >= n || ny >= n || nx < 0 || ny < 0 || visited[ny][nx])
						continue;

					if (map[ny][nx] == 1)
						count += 1;

					q.add(new Position(nx, ny));
					visited[ny][nx] = true;
				}
			}

			if (calculation(k) <= count * m)
				answer = count > answer ? count : answer;
		}
	}

	public static int calculation(int k) {
		return k * k + (k - 1) * (k - 1);
	}

	public static class Position {
		int x, y;

		public Position(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
}
