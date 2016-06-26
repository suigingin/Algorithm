## 平均最大化
重さと価値がそれぞれ```w_i,v_i```であるような品物が**n**個ある。  
この中から丁度**k**個選んだ時の単位重さあたりの価値を最大化させたい。

単位重さあたりの価値が高いものから貪欲に選んでも上手くいかないため、  
単位重さあたりの価値が**x**以上に選ぶことができるか で二分探索を行う。

### sample input
```
3 2
2 5 2
2 3 1
```
### sample output
```
0.75
```

### 計算量
O(nlogn)

### コード
```java
int n, k;
int[] w, v;

void run() {
	n = sc.nextInt();
	k = sc.nextInt();
	w = new int[n];
	v = new int[n];
	for (int i = 0; i < n; i++) w[i] = sc.nextInt();
	for (int i = 0; i < n; i++) v[i] = sc.nextInt();
	double l = 0;
	double r = Integer.MAX_VALUE / 2;
	for (int i = 0; i < 100; i++) {
		double mid = (l + r) / 2;
		if (check(mid)) l = mid;
		else r = mid;
	}
	System.out.printf("%.2f\n", l);
}

boolean check(double x) {
	double[] y = new double[n];
	for (int i = 0; i < n; i++) y[i] = v[i] - x * w[i];
	Arrays.sort(y);
	double sum = 0;
	for (int i = 0; i < k; i++) sum += y[n - 1 - i];
	return sum >= 0;
}
```

### verify
未
