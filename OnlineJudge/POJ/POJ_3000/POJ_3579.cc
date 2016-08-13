#include <cstdio>
#include <algorithm>
using namespace std;

#define ll long long

int upper_bound(int a[], int k, int N) {
	int l = -1;
	int r = N;
	while (r - l > 1) {
		int mid = (l + r) / 2;
		if (k < a[mid]) r = mid;
		else l = mid;
	}
	return r;
}

bool check(int a[], int n, int k, int N) {
	ll cnt = 0;
	for(int i = 0; i < N; i++) cnt += upper_bound(a, a[i] + n, N) - 1 - i;
	return cnt >= k;
}

int main() {
	ll N;
	while(scanf("%lld", &N)!=EOF) {
		ll A = (N * (N - 1)) / 2;
		ll K = (A % 2 == 1) ? (A / 2 + 1) : (A / 2);
		int a[N];
		for(int i = 0; i < N; i++) scanf("%d", a + i);
		sort(a, a + N);

		int l = 0;
		int r = 1000000000;
		while(r - l > 1) {
			int mid = (l + r) / 2;
			if(check(a, mid, K, N)) r = mid;
			else l = mid;
		}
		printf("%d\n", r);
	}
}
