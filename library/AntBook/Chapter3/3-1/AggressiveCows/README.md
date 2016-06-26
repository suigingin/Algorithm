## 最小値の最大化
条件を```C(mid)```と置き、  
```C(mid)``` を満たすような最大のmidを二分探索で求める。

### 計算量
O(nlogn)

### コード
```java
import java.util.Arrays;
import java.util.Scanner;

public class POJ_2456 {
	Scanner sc = new Scanner(System.in);

	int N, C;
	int[] P;

	void run() {
		N = sc.nextInt();
		C = sc.nextInt();
		P = new int[N];
		for (int i = 0; i < N; i++) P[i] = sc.nextInt();
		Arrays.sort(P);
		int l = 0;
		int r = Integer.MAX_VALUE / 2;
		while (r - l > 1) {
			int mid = (l + r) / 2;
			if (check(mid)) l = mid;
			else r = mid;
		}
		System.out.println(l);
	}

	boolean check(int dis) {
		int c = 1;
		int pre = P[0];
		for (int i = 1; i < N; i++) {
			if (P[i] - pre >= dis) {
				c++;
				pre = P[i];
			}
		}
		return c >= C;
	}

	public static void main(String[] args) {
		new POJ_2456().run();
	}
}
```

### verify
http://poj.org/problem?id=2456
