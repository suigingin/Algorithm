import java.util.Scanner;

public class BubbleSortCnt {
	Scanner sc = new Scanner(System.in);
	int cnt;

	void run() {
		int n = sc.nextInt();
		int[] array = new int[n];
		for (int i = 0; i < n; i++) array[i] = sc.nextInt();
		cnt = 0;
		mergeSort(array, 0, n);
		System.out.println(cnt);
	}

	void mergeSort(int a[], int left, int right) {
		if (right - left <= 1) return;
		int mid = (left + right) / 2;
		mergeSort(a, left, mid);
		mergeSort(a, mid, right);
		merge(a, left, mid, right);
	}

	void merge(int[] a, int left, int mid, int right) {
		int[] L = new int[mid - left];
		int[] R = new int[right - mid];
		int li = 0;
		int ri = 0;
		for (int i = 0; i < L.length; i++) L[i] = a[left + i];
		for (int i = 0; i < R.length; i++) R[i] = a[mid + i];
		for (int i = left; i < right; i++) {
			if (li < L.length && (ri == R.length || L[li] <= R[ri])) {
				a[i] = L[li++];
			} else {
				cnt += (mid - li - left);
				a[i] = R[ri++];
			}
		}
	}

	public static void main(String[] args) {
		new BubbleSortCnt().run();
	}
}
