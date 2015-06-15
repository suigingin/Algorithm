import java.util.Scanner;
import java.util.TreeSet;

public class D {
	Scanner sc = new Scanner(System.in);

	void run() {
		int n = sc.nextInt();

		// sort and unique
		TreeSet<Integer> set = new TreeSet<Integer>();
		for (int i = 0; i < n; i++) set.add(sc.nextInt());
		int[] a = new int[set.size()];
		int index = 0;
		for (int ele : set) a[index++] = ele;

		// set lower number
		int[] neerMax = new int[2000001];
		int pre = -1; index = 0;
		for (int value : a) {
			while (index <= value) neerMax[index++] = pre;
			pre = value;
		}
		for (int i = pre + 1; i <= 2000000; i++) neerMax[i] = pre;

		// check multiple of a[i] % near number
		int max = 0;
		for (int i = 0; i < a.length; i++) {
			for (int j = a[i] * 2; j <= 2000000; j += a[i]) {
				max = Math.max(max, neerMax[j] % a[i]);
			}
		}
		System.out.println(max);
	}

	public static void main(String[] args) {
		new D().run();
	}
}
