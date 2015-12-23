import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeMap;

public class Edu03_C {
	Scanner sc = new Scanner(System.in);

	void run() {
		int n = sc.nextInt();
		int[] m = new int[n];
		for(int i = 0; i < n; i++) m[i] = sc.nextInt();
		Arrays.sort(m);
		int sum = 0;
		for (int i = 0; i < n; i++) sum += m[i];
		int ave = sum / n;
		int rem = sum % n;
		int act = 0;
		int[] fin = new int[n];
		Arrays.fill(fin, ave);
		for (int i = n - 1; i >= n - rem; i--) fin[i]++;
		for (int i = 0; i < n; i++) act += Math.abs(fin[i] - m[i]);
		System.out.println(act / 2);
	}

	void tle() {
		int n = sc.nextInt();
		TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
		for (int i = 0; i < n; i++) {
			int m = sc.nextInt();
			map.put(m, map.containsKey(m) ? map.get(m) + 1 : 1);
		}
		int cnt = 0;
		while (true) {
			int fKey = map.firstKey();
			int lKey = map.lastKey();
			if (lKey - fKey <= 1) break;
			cnt++;
			int fCnt = map.get(fKey) - 1;
			int lCnt = map.get(lKey) - 1;
			map.put(fKey, fCnt);
			map.put(lKey, lCnt);
			if (fCnt == 0) map.remove(fKey);
			if (lCnt == 0) map.remove(lKey);
			map.put(fKey + 1, map.containsKey(fKey + 1) ? map.get(fKey + 1) + 1 : 1);
			map.put(lKey - 1, map.containsKey(lKey - 1) ? map.get(lKey - 1) + 1 : 1);
		}
		System.out.println(cnt);
	}

	public static void main(String[] args) {
		new Edu03_C().run();
	}
}
