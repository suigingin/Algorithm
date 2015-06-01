import java.util.Scanner;

public class A {
	Scanner sc = new Scanner(System.in);

	void run() {
		int n = sc.nextInt();
		String[] s = { 
				"+------------------------+",
				"|O.O.O.#.#.#.#.#.#.#.#.|D|)",
				"|O.O.O.#.#.#.#.#.#.#.#.|.|",
				"|O.......................|",
				"|O.O.#.#.#.#.#.#.#.#.#.|.|)",
				"+------------------------+" };
		char[][] c = new char[s.length][];
		for (int i = 0; i < c.length; i++) {
			c[i] = s[i].replaceAll("O", "#").toCharArray();
		}
		for (int i = 0; i < c[0].length; i++) {
			for (int j = 0; j < c.length; j++) {
				if (c[j][i] == '#') {
					c[j][i] = 'O';
					n--;
				}
				if (n == 0) {
					out(c);
					return;
				}
			}
		}
	}

	public static void main(String[] args) {
		new A().run();
	}

	void out(char[][] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				System.out.print(array[i][j]);
			}
			System.out.println();
		}
	}
}
