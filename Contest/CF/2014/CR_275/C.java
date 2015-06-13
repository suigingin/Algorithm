import java.util.ArrayList;
import java.util.Scanner;

public class C {
	Scanner sc = new Scanner(System.in);

	void run() {
		int n = sc.nextInt();
		int k = sc.nextInt();
		int kk = k;

		ArrayList<Integer> l = new ArrayList<Integer>();
		l.add(1);
		for (int i = 1; i <= k; i++) {
			l.add(i % 2 == 0 ? l.get(i - 1) - kk : l.get(i - 1) + kk);
			kk--;
		}

		for (int i = k + 2; i <= n; i++) l.add(i);

		StringBuilder out = new StringBuilder();
		for (int i = 0; i < l.size(); i++) out.append(l.get(i) +" ");
		System.out.println(out);
	}

	public static void main(String[] args) {
		new C().run();
	}
}
