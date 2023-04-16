import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p2447 {
	/*
	 * 재귀적인 패턴으로 별찍기 n이 3의 거듭제곱, n의 패턴의 크기는 n*n의 정사각형 크기 3의 패턴은 가운데에 공백이 있고, 가운데를
	 * 제외한 모든 칸에 별이 하나씩 있는 패턴
	 */

	static int n;
	static char[][] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new char[n][n];

		draw(0, 0, n, false);

		/*
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		*/
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				sb.append(arr[i][j]);
			}
			sb.append('\n');
		}
		
		System.out.println(sb);
	}

	public static void draw(int x, int y, int depth, boolean blank) {
		if (blank) {
			for (int i = x; i < x + depth; i++) {
				for (int j = y; j < y + depth; j++) {
					arr[i][j] = ' ';
				}
			}

			return;
		}

		if (depth == 1) {
			arr[x][y] = '*';
			return;
		}

		int size = depth / 3;
		int count = 0;

		for (int i = x; i < x + depth; i+=size) {
			for (int j = y; j < y + depth; j+=size) {
				count++;
				if (count == 5) {
					draw(i, j, size, true);
				} else {
					draw(i, j, size, false);
				}
			}
		}
	}
}
