import java.util.Scanner;

public class B {
	Scanner sc = new Scanner(System.in);

	void run() {
		StringBuilder s = new StringBuilder(sc.next());
		StringBuilder t = new StringBuilder(s);
		System.out.println(t.append(s.reverse()));
	}

	public static void main(String[] args) {
		new B().run();
	}
}
