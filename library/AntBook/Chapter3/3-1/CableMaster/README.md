## 解を仮定し可能か判定
条件を```C(mid)```を置き、  
```C(mid)```を満たすような最大のmidを二分探索で求める。

### 計算量
O(nlogn)

### コード
```java
import java.util.Scanner;

public class POJ_1064 {
	Scanner sc = new Scanner(System.in);
	int N, K;
	double[] C;

	void run() {
		N = sc.nextInt();
		K = sc.nextInt();
		C = new double[N];
		for (int i = 0; i < N; i++) C[i] = sc.nextDouble();

		double l = 0;
		double r = 100001;
		for (int i = 0; i < 100; i++) {
			double mid = (l + r) / 2;
			if (check(mid)) l = mid;
			else r = mid;
		}
		System.out.printf("%.2f\n", Math.floor(l * 100) / 100);
	}

	boolean check(double len) {
		int cnt = 0;
		for (int i = 0; i < N; i++) cnt += C[i] / len;
		return cnt >= K;
	}

	public static void main(String[] args) {
		new POJ_1064().run();
	}
}
```

### verify
http://poj.org/problem?id=1064
