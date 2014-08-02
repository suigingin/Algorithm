package library;

class Dice {
	String top;
	String front;
	String right;
	String back;
	String left;
	String reverse;

	public Dice(String top, String front, String right, String back,
			String left, String reverse) {
		super();
		this.top = top;
		this.front = front;
		this.right = right;
		this.back = back;
		this.left = left;
		this.reverse = reverse;
	}

	void disp() {
		System.out.print(this.top + " " + this.front + " " + this.right + " "
				+ this.back + " " + this.left + " " + this.reverse);
		System.out.println();
	}

	void rotate_parallel() {
		String tmp = this.back;
		this.back = this.right;
		this.right = this.front;
		this.front = this.left;
		this.left = tmp;
	}

	void roll_back() {
		String tmp = this.top;
		this.top = this.front;
		this.front = this.reverse;
		this.reverse = this.back;
		this.back = tmp;
	}

	void roll_front() {
		String tmp = this.top;
		this.top = this.back;
		this.back = this.reverse;
		this.reverse = this.front;
		this.front = tmp;
	}

	void roll_right() {
		String tmp = this.top;
		this.top = this.left;
		this.left = this.reverse;
		this.reverse = this.right;
		this.right = tmp;
	}

	void roll_left() {
		String tmp = this.top;
		this.top = this.right;
		this.right = this.reverse;
		this.reverse = this.left;
		this.left = tmp;
	}

	boolean coincide(Dice cmp) {
		if (this.front.equals(cmp.front) && this.top.equals(cmp.top)
				&& this.back.equals(cmp.back) && this.right.equals(cmp.right)
				&& this.left.equals(cmp.left)
				&& this.reverse.equals(cmp.reverse)) {
			return true;
		} else {
			return false;
		}
	}
}
