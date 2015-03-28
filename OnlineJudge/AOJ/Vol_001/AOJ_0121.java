import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class AOJ_0121 {
	Scanner sc = new Scanner(System.in);

	HashMap<String, Integer> map;
	LinkedList<String> que;

	void run() {
		map = new HashMap<String, Integer>();
		que = new LinkedList<String>();
		int cnt = 0;
		que.add("01234567");
		map.put("01234567", cnt);
		while (!que.isEmpty()) {
			cnt++;
			int size = que.size();
			for (int i = 0; i < size; i++) {
				String now = que.poll();
				int zero = now.indexOf('0');
				if (zero != 0 && zero != 4) {
					char[] next = now.toCharArray();
					char t = next[zero - 1];
					next[zero] = t;
					next[zero - 1] = '0';
					setParam(next, cnt);
				}
				if (zero != 3 && zero != 7) {
					char[] next = now.toCharArray();
					char t = next[zero + 1];
					next[zero] = t;
					next[zero + 1] = '0';
					setParam(next, cnt);
				}
				char[] next = now.toCharArray();
				char t = next[(zero + 4) % 8];
				next[zero] = t;
				next[(zero + 4) % 8] = '0';
				setParam(next, cnt);
			}
		}
		while (sc.hasNext()) {
			String key = "";
			for (int i = 0; i < 8; i++) {
				key += sc.nextInt();
			}
			System.out.println(map.get(key));
		}
	}

	void setParam(char[] next, int cnt) {
		String nextS = String.valueOf(next);
		if (!map.containsKey(nextS)) {
			map.put(nextS, cnt);
			que.add(nextS);
		}
	}

	public static void main(String[] args) {
		new AOJ_0121().run();
	}
}
