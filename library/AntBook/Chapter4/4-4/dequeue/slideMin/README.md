## スライド最小値
### 説明
長さ```n```の数列```a```と数```k```(k<=n)が与えられる。  
```b_i = min{a_i,a_i+1,...a_i+k-1}```として定義される数列```b```を返す。

### 計算量
O(n)

### コード
```java
import java.util.Deque;
import java.util.LinkedList;

public class SlideMinMax {

	int[] getSlideMin(int[] a, int n, int k) {
		int[] b = new int[n - k + 1];
		Deque<Integer> deq = new LinkedList<Integer>();
		for (int i = 0; i < n; i++) {
			if (deq.isEmpty()) {
				deq.add(i);
			} else {
				while (!deq.isEmpty() && a[deq.peekLast()] >= a[i]) deq.pollLast();
				deq.addLast(i);
			}
			if (i - k + 1 >= 0) {
				b[i - k + 1] = a[deq.peekFirst()];
				if (deq.peekFirst() == i - k + 1) deq.pollFirst();
			}
		}
		return b;
	}

	int[] getSlideMax(int[] a, int n, int k) {
		int[] b = new int[n - k + 1];
		Deque<Integer> deq = new LinkedList<Integer>();
		for (int i = 0; i < n; i++) {
			if (deq.isEmpty()) {
				deq.add(i);
			} else {
				while (!deq.isEmpty() && a[deq.peekLast()] <= a[i]) deq.pollLast();
				deq.addLast(i);
			}
			if (i - k + 1 >= 0) {
				b[i - k + 1] = a[deq.peekFirst()];
				if (deq.peekFirst() == i - k + 1) deq.pollFirst();
			}
		}
		return b;
	}
}
```

### verify
http://poj.org/problem?id=2823
