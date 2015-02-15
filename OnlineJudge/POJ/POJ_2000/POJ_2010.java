import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class POJ_2010 {
	MyScanner sc = new MyScanner();

	void run() {
		int N = sc.nextInt();
		int C = sc.nextInt();
		int F = sc.nextInt();
		Data[] data = new Data[C];
		for (int i = 0; i < C; i++) {
			data[i] = new Data(sc.nextLong(), sc.nextLong());
		}
		Arrays.sort(data);
		int half = N / 2;
		long[] lower = new long[C];
		long[] upper = new long[C];
		PriorityQueue<Long> que = new PriorityQueue<Long>(1, new ComparatorQue());
		int costSum = 0;
		for (int i = C - 1; i >= 0; i--) {
			upper[i] = (que.size() == half) ? costSum : Integer.MAX_VALUE;
			costSum += data[i].cost;
			if (que.size() == half) {
				que.add(data[i].cost);
				costSum -= que.poll();
			} else {
				que.add(data[i].cost);
			}
		}
		que.clear();
		costSum = 0;
		for (int i = 0; i < C; i++) {
			lower[i] = (que.size() == half) ? costSum : Integer.MAX_VALUE;
			costSum += data[i].cost;
			if (que.size() == half) {
				que.add(data[i].cost);
				costSum -= que.poll();
			} else {
				que.add(data[i].cost);
			}
		}
		for (int i = C - 1; i >= 0; i--) {
			if (lower[i] + upper[i] + data[i].cost <= F) {
				System.out.println(data[i].score);
				return;
			}
		}
		System.out.println(-1);
	}

	class Data implements Comparable<Data> {
		long score;
		long cost;

		public Data(long score, long cost) {
			super();
			this.score = score;
			this.cost = cost;
		}

		@Override
		public int compareTo(Data o) {
			return (int) (this.score - o.score);
		}
	}

	class ComparatorQue implements Comparator<Long> {
		@Override
		public int compare(Long o1, Long o2) {
			return (int) (o2 - o1);
		}
	}

	public static void main(String[] args) {
		new POJ_2010().run();
	}

	class MyScanner {
		int nextInt() {
			try {
				int c = System.in.read();
				while (c != '-' && (c < '0' || '9' < c))
					c = System.in.read();
				if (c == '-')
					return -nextInt();
				int res = 0;
				do {
					res *= 10;
					res += c - '0';
					c = System.in.read();
				} while ('0' <= c && c <= '9');
				return res;
			} catch (Exception e) {
				return -1;
			}
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		String next() {
			try {
				StringBuilder res = new StringBuilder("");
				int c = System.in.read();
				while (Character.isWhitespace(c))
					c = System.in.read();
				do {
					res.append((char) c);
				} while (!Character.isWhitespace(c = System.in.read()));
				return res.toString();
			} catch (Exception e) {
				return null;
			}
		}
	}
}
