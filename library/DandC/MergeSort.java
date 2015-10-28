import java.util.Scanner;

public class MergeSort {
	Scanner sc = new Scanner(System.in);

	void run() {
		int n = sc.nextInt();
		int[] array = new int[n];
		for (int i = 0; i < n; i++) array[i] = sc.nextInt();
		mergeSort(array, 0, n);
	}

	void mergeSort(int a[], int left, int right) {
		if (right - left <= 1) return;
		int mid = (left + right) / 2;
		mergeSort(a, left, mid);
		mergeSort(a, mid, right);
		// この段階でleft-mid, mid-rightのそれぞれの区間はソート済み
		merge(a, left, mid, right);
	}

	// ソート済みの区間をまとめる
	void merge(int[] a, int left, int mid, int right) {
		int[] L = new int[mid - left + 1];
		int[] R = new int[right - mid + 1];
		int li = 0;
		int ri = 0;
		for (int i = 0; i < L.length - 1; i++) L[i] = a[left + i];
		for (int i = 0; i < R.length - 1; i++) R[i] = a[mid + i];
		L[L.length - 1] = R[R.length - 1] = Integer.MAX_VALUE / 2;
		for (int i = left; i < right; i++) {
			if (L[li] < R[ri]) a[i] = L[li++];
			else a[i] = R[ri++];
		}
	}

	public static void main(String[] args) {
		new MergeSort().run();
	}
}
