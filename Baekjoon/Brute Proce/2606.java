package algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static ArrayList<Pair> graph;
	static boolean[] visited;

	static class Pair {
		int x, y;

		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		graph = new ArrayList<>();
		visited = new boolean[N + 1];

		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			graph.add(new Pair(x, y));
			graph.add(new Pair(y, x));
		}

		int answer = bfs();
		System.out.println("answer : " + answer);
		bw.write(answer);
		bw.flush();
		bw.close();
	}

	private static int bfs() {
		int count = 0;
		Queue<Integer> q = new LinkedList<>();
		q.add(1);
		visited[1] = true;

		while (!q.isEmpty()) {
			int target = q.poll();
			count++;

			for (Pair i : graph) {
				if (!visited[i.x] && (i.x == target || i.y == target)) {
					q.add(i.x);
					visited[i.x] = true;
				}
			}
		}
		System.out.println("count : " + count);
		return count - 1;
	}
}