## 三角形の最大周長

### 説明
```n``` 本の棒があり、それらの棒から3本を選んで作る事ができる三角形の  
最も周長の長い長さを返す。  
三角形が作れない時は0を返す。

### 計算量
O(nlongn)

### コード
```java
int maxLength(int[] a) {
	Arrays.sort(a);
	for (int i = a.length - 1; i >= 2; i--) {
		int maxLen = a[i];
		int twoLen = a[i - 1] + a[i - 2];
		if(twoLen > maxLen) {
			return maxLen + twoLen;
		}
	}
	return 0;
}

```
