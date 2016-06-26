## lower_bound
### 説明
ソート済みの配列から、a_i>=k となるような最小のiを求める。

### 計算量
O(logn)

### コード
```java
// find minimum i (k <= a[i])
int lower_bound(int a[], int k) {
	int l = -1;
	int r = a.length;
	while (r - l > 1) {
		int mid = (l + r) / 2;
		if (k <= a[mid]) r = mid;
		else l = mid;
	}
	// r = l + 1
	return r;
}
```
