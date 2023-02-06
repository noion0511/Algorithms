package algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	// 구하는 것 : 아기 상어가 몇초동안 엄마 상어에게 도움을 요청하지 않고 물고기를 먹을 수 있는지
	// 먹는 시간은 들지 않고, 이동시간은 1칸당 1초
	// 자기와 같은 크기와 같은 수의 물고기를 먹을 떄 마다 크기가 1 증가한다.
	// 거리가 가장 가까운 물고기 순서대로 먹고, 같다면 젤 위, 그다음 젤 왼쪽

	// 상어의 상하좌우를 검색하며, 목표 물고기 쪽으로 이동, 이동 거리 ++
	static int[][] sea, arr;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static int N, sharkX, sharkY, size = 2, result;
	static int minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE, minDistance = Integer.MAX_VALUE;

	static class Position {
		int x, y;

		public Position(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int count = 0;

		N = Integer.parseInt(st.nextToken());
		arr = new int[N + 1][N + 1];
		sea = new int[N + 1][N + 1];

		for (int i = 1; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < N + 1; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());

				if (arr[i][j] == 9) {
					sharkX = i;
					sharkY = j;
					arr[i][j] = 0;
				}
			}
		}

		while (true) {
			minX = Integer.MAX_VALUE;
			minY = Integer.MAX_VALUE;
			minDistance = Integer.MAX_VALUE;

			for (int i = 1; i < N + 1; i++) {
				for (int j = 1; j < N + 1; j++) {
					sea[i][j] = -1;
				}
			}

			bfs(sharkX, sharkY);
			
			if (minX != Integer.MAX_VALUE) {
				result += sea[minX][minY];
				count++;

				if (count == size) {
					size++;
					count = 0;
				}

				arr[minX][minY] = 0;
				sharkX = minX;
				sharkY = minY;
			} else {
				break;
			}
		}

		System.out.println(result);
	}

	private static void bfs(int x, int y) {
		Queue<Position> p = new LinkedList<>();
		p.add(new Position(x, y));
		sea[x][y] = 0;

		while (!p.isEmpty()) {
			Position current = p.poll();
			x = current.x;
			y = current.y;

			for (int i = 0; i < 4; i++) {
				int nx = dx[i] + x;
				int ny = dy[i] + y;

				if (nx < 1 || nx > N || ny < 1 || ny > N)
					continue;
				if (sea[nx][ny] != -1 || arr[nx][ny] > size)
					continue;

				sea[nx][ny] = sea[x][y] + 1;

				if (arr[nx][ny] != 0 && arr[nx][ny] < size) {
					if (minDistance > sea[nx][ny]) {
						minDistance = sea[nx][ny];
						minX = nx;
						minY = ny;
					} else if (minDistance == sea[nx][ny]) {
						if (minX == nx) {
							if (minY > ny) {
								minX = nx;
								minY = ny;
							}
						} else if (minX > nx) {
							minX = nx;
							minY = ny;
						}
					}
				}

				p.add(new Position(nx, ny));
			}
		}
	}

}