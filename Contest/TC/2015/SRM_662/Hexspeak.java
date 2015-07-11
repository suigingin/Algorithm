public class Hexspeak {

	public String decode(long ciphertext) {
		String str = Long.toHexString(ciphertext);
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (Character.isDigit(c)) {
				if ('2' <= c && c <= '9') return "Error!";
			}
		}
		return str.toUpperCase().replaceAll("0", "O").replace("1", "I");
	}
}
