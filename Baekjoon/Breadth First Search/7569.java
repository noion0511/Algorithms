package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, H;
	static int[][][] box;
	// 위, 아래, 왼쪽, 오른쪽, 앞, 뒤
	static int[] dx = { 0, 0, -1, 1, 0, 0 };
	static int[] dy = { 0, 0, 0, 0, 1, -1 };
	static int[] dz = { 1, -1, 0, 0, 0, 0 };

	/*
	 * 최소 일수 1. 3중for문 
	 * 2. ...
	 */

	static class Position {
		int x, y, z;

		Position(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		box = new int[H][M][N];

		for (int i = 0; i < H; i++) {
			for (int j = 0; j < M; j++) {
				st = new StringTokenizer(br.readLine());
				for (int j2 = 0; j2 < N; j2++) {
					box[i][j][j2] = Integer.parseInt(st.nextToken());
				}
			}
		}

		bfs();
	}

	static private void bfs() {
		Queue<Position> q = new LinkedList<Position>();
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < M; j++) {
				for (int j2 = 0; j2 < N; j2++) {
					if (box[i][j][j2] == 1) {
						q.add(new Position(j2, j, i));
					}
				}
			}
		}

		while (!q.isEmpty()) {
			Position p = q.poll();

			for (int j = 0; j < 6; j++) {
				int nx = dx[j] + p.x;
				int ny = dy[j] + p.y;
				int nz = dz[j] + p.z;

				if (nx < 0 || ny < 0 || nz < 0 || nx >= N || ny >= M || nz >= H)
					continue;
				if (box[nz][ny][nx] != 0)
					continue;

				box[nz][ny][nx] = box[p.z][p.y][p.x] + 1;
				q.add(new Position(nx, ny, nz));
			}
		}
		int count = 0;

		for (int i = 0; i < H; i++) {
			for (int j = 0; j < M; j++) {
				for (int j2 = 0; j2 < N; j2++) {
					if (box[i][j][j2] == 1 || box[i][j][j2] == -1)
						count++;
				}
			}
		}

		if (count == N * M * H) {
			System.out.println(0);
			return;
		}

		int max = 0;

		for (int i = 0; i < H; i++) {
			for (int j = 0; j < M; j++) {
				for (int j2 = 0; j2 < N; j2++) {
					if (box[i][j][j2] == 0) {
						System.out.println(-1);
						return;
					}
					max = Math.max(max, box[i][j][j2]);
				}
			}
		}

		System.out.println(max - 1);
	}
}