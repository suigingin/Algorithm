import java.math.BigInteger;
import java.util.Scanner;

public class B1 {
	Scanner sc = new Scanner(System.in);

	void run() {
		BigInteger in = new BigInteger(sc.next());
		System.out.println(in.mod(new BigInteger("4")).equals(BigInteger.ZERO) ? 4 : 0);
	}

	public static void main(String[] args) {
		new B1().run();
	}
}
