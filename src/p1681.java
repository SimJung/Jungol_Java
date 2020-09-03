import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p1681 {
	static int N, ans;
	static int arr[][];
	static int[] perm; 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());
		arr = new int[N][N];
		perm = new int[N+1];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=1; i<N; i++) perm[i] = i;
		ans = Integer.MAX_VALUE;
		
		do {
			dfs(0, 0);
		}while(np());
		
		System.out.println((ans == Integer.MAX_VALUE ? "0" : ans));
	}
	
	public static void dfs(int cnt, int cost) {
		if(arr[perm[cnt]][perm[cnt+1]] > 0) {
			if(perm[cnt+1] == 0) {
				if(ans > cost + arr[perm[cnt]][perm[cnt+1]]) {
					ans = cost + arr[perm[cnt]][perm[cnt+1]];
				}
			}else {
				dfs(cnt+1, cost + arr[perm[cnt]][perm[cnt+1]]);
			}
		}
		
	}
	
	public static boolean np() {
		int i = N-1;
		while(i > 1 && perm[i-1] >= perm[i]) i--;
		
		if(i == 1) return false;
		
		int j = N-1;
		while(perm[i-1] >= perm[j]) j--;
		
		swap(i-1, j);
		
		int k = N-1;
		while(k > i) swap(i++, k--);
		
		return true;
	}
	
	public static void swap(int i, int j) {
		int temp = perm[i];
		perm[i] = perm[j];
		perm[j] = temp;
	}
}
