import java.util.Scanner;

public class D {
	Scanner sc = new Scanner(System.in);
	void run() {
		int n = sc.nextInt();
		if(n % 2 == 0) System.out.println("white\n1 2");
		else System.out.println("black");
	}

	public static void main(String[] args) {
		new D().run();
	}
}
