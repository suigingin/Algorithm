class Pair implements Comparable<Pair> {

	int a;
	int b;

	public Pair() {
		super();
		this.a = 0;
		this.b = 0;
	}

	public Pair(int a, int b) {
		super();
		this.a = a;
		this.b = b;
	}

	@Override
	public int compareTo(Pair arg0) {
		if (this.a == arg0.a) {
			return this.b - arg0.b;
		}
		return this.a - arg0.a;
	}

	void show() {
		System.out.println("a = " + this.a + " b = " + this.b);
	}
}
