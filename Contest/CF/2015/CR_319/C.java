import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class C {
	Scanner sc = new Scanner(System.in);

	void run() {
		int n = sc.nextInt();
		boolean[] isPrime = new boolean[n + 1];
		Arrays.fill(isPrime, true);
		isPrime[0] = isPrime[1] = false;
		for (int i = 2; i * i <= n; i++) {
			if (!isPrime[i]) continue;
			for (int j = i * 2; j <= n; j += i) isPrime[j] = false;
		}

		ArrayList<Integer> pList = new ArrayList<Integer>();
		for (int i = 0; i <= n; i++) if (isPrime[i]) pList.add(i);

		StringBuilder out = new StringBuilder();
		int cnt = 0;
		for (int i = 0; i < pList.size(); i++) {
			int primeNum = pList.get(i);
			for (int j = primeNum; j <= n; j *= primeNum) {
				out.append(j + " ");
				cnt++;
			}
		}
		System.out.println(cnt);
		System.out.println(out);
	}

	public static void main(String[] args) {
		new C().run();
	}
}
