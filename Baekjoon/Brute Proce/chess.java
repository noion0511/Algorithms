package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class chess {
	public static boolean[][] arr;
	public static int min = 64;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		arr = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			String s = br.readLine();

			for (int j = 0; j < M; j++) {
				if (s.charAt(j) == 'W') {
					arr[i][j] = true;
				} else {
					arr[i][j] = false;
				}
			}
		}

		int startRow = N - 7;
		int startCol = M - 7;

		for (int i = 0; i < startRow; i++) {
			for (int j = 0; j < startCol; j++) {
				findMinValue(i, j);
			}
		}

		System.out.println(min);
	}

	private static void findMinValue(int x, int y) {
		int endX = x + 8;
		int endY = y + 8;
		int count = 0;

		boolean boardColor = arr[x][y];

		for (int i = x; i < endX; i++) {
			for (int j = y; j < endY; j++) {
				if (arr[i][j] != boardColor) {
					++count;
				}

				boardColor = !boardColor;
			}

			boardColor = !boardColor;
		}

		count = Math.min(count, 64 - count);
		min = Math.min(min, count);
	}
}
