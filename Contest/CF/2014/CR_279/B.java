import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class B {
	Scanner sc = new Scanner(System.in);

	void run() {
		int n = sc.nextInt();
		HashMap<Integer, Integer> head = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> last = new HashMap<Integer, Integer>();
		for (int i = 0; i < n; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			head.put(a, b);
			last.put(b, a);
		}

		int first = 0;
		int second = 0;
		for (int key : head.keySet()) {
			if (!last.containsKey(key)) first = key;
		}

		ArrayList<Integer> r1 = new ArrayList<Integer>();
		ArrayList<Integer> r2 = new ArrayList<Integer>();
		r1.add(first);
		while (head.containsKey(first)) {
			first = head.get(first);
			if (first == 0) break;
			r1.add(first);
		}
		while (head.containsKey(second)) {
			second = head.get(second);
			if (second == 0) break;
			r2.add(second);
		}

		int[] ans = new int[r1.size() + r2.size()];
		for (int i = 0; i < r1.size(); i++) ans[i * 2] = r1.get(i);
		for (int i = 0; i < r2.size(); i++) ans[i * 2 + 1] = r2.get(i);

		StringBuilder out = new StringBuilder();
		for (int i = 0; i < ans.length; i++) out.append(ans[i]+" ");
		System.out.println(out);
	}

	public static void main(String[] args) {
		new B().run();
	}
}
