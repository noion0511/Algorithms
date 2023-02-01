package algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int N, M, B;
	static int[][] ground;
	static int[] result = new int[3];
	static int time = Integer.MAX_VALUE;
	static int height = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());

		ground = new int[N][M];
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				ground[i][j] = Integer.parseInt(st.nextToken());

				max = Math.max(max, ground[i][j]);
				min = Math.min(min, ground[i][j]);
			}
		}

		brute_force(min, max);

		bw.write(Integer.toString(time) + " " + Integer.toString(height));

		bw.flush();
		bw.close();
		br.close();
	}

	private static void brute_force(int min, int max) {
		for (int i = min; i <= max; i++) {
			result = countTime(i);
			
			if (result[2] > 0) {
				if (time > result[0]) {
					time = result[0];
					height = result[1];
				} else if (time == result[0] && height < result[1]) {
					time = result[0];
					height = result[1];
				}
			}

//			System.out.println(result[0] + " " + result[1]);
		}
	}

	private static int[] countTime(int height) { // 63, 64
		int time = 0;
		int block = B;

		for (int j = 0; j < N; j++) {
			for (int j2 = 0; j2 < M; j2++) {
				int value = ground[j][j2];

				if (value == height) {
					continue;
				}

				if (value > height) {
					time += (value - height) * 2;
					block += value - height;
//					System.out.println("1 -> time : " + time + " block : " + block + " height : " + height);
				} else {
					time += height - value;
					block -= height - value;
//					System.out.println("2 -> time : " + time + " block : " + block);
				}
			}
		}

		if (block < 0) {
			result[0] = Integer.MAX_VALUE;
			return result;
		}

		result[0] = time;
		result[1] = height;
		result[2] = block;

		return result;
	}
}
