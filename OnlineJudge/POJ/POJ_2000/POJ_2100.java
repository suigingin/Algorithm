import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class POJ_2100 {
	Scanner sc = new Scanner(System.in);

	void run() {
		long n = sc.nextLong();
		List<Long> l = new ArrayList<Long>();
		List<Long> r = new ArrayList<Long>();

		long sum = 0;
		for (long s = 1, t = 1; t * t <= n; t++) {
			sum += t * t;
			while (s <= t && sum >= n) {
				if (sum == n) {
					l.add(s);
					r.add(t);
				}
				sum -= s * s;
				s++;
			}
		}
		StringBuilder o = new StringBuilder();
		o.append(l.size() + "\n");
		for (int i = 0; i < l.size(); i++) {
			long ll = l.get(i);
			long rr = r.get(i);
			o.append(rr - ll + 1);
			for (long j = ll; j <= rr; j++) o.append(" " + j);
			o.append("\n");
		}
		System.out.print(o);
	}

	public static void main(String[] args) {
		new POJ_2100().run();
	}
}
