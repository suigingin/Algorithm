public class InfiniteString {

	public String equal(String s, String t) {
		int sl = s.length();
		int tl = t.length();
		String makeS = "";
		String makeT = "";
		for (int i = 0; i < tl; i++) {
			makeS += s;
		}
		for (int i = 0; i < sl; i++) {
			makeT += t;
		}
		return makeS.equals(makeT) ? "Equal" : "Not equal";
	}
}
