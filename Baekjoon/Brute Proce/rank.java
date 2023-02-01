package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
 
public class rank {
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
 
		int[][] arr = new int[N][2];
 
		String[] heightAndWeight;
		for(int i = 0; i < N; i++) {
			heightAndWeight = br.readLine().split(" ");			
			arr[i][0] = Integer.parseInt(heightAndWeight[0]);	
			arr[i][1] = Integer.parseInt(heightAndWeight[1]);	
		}
		
				
		for(int i = 0; i < N; i++) {
			int rank = 1;
			
			for(int j = 0; j < N; j++) {
				if(i == j) continue;
				if (arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]) {
					rank++;
				}
			}
 
			System.out.print(rank + " ");
		}
 
	}
}
