import java.math.BigInteger;
import java.util.Scanner;

public class C {
	Scanner sc = new Scanner(System.in);

	void run() {
		BigInteger t = new BigInteger(sc.next());
		BigInteger w = new BigInteger(sc.next());
		BigInteger b = new BigInteger(sc.next());
	
		BigInteger gcd = w.gcd(b);
		BigInteger lcm = (w.multiply(b)).divide(gcd);
		
		// Math.min(w,b) - 1
		BigInteger fall = w.min(b).subtract(BigInteger.ONE);
		BigInteger tieCnt = BigInteger.ZERO;
		
		// お互い止まれる場所は同点になる
		BigInteger twoStop = t.divide(lcm);
		tieCnt = tieCnt.add(twoStop);

		// お互い止まれる位置からfall離れたところまでは両者が落ちるため同点となる
		// スタート時を含むため1を足す
		// tieCnt += (twoStop + 1)  * fall
		tieCnt = tieCnt.add(twoStop.add(BigInteger.ONE).multiply(fall));
		
		// はみ出た分を引く
		BigInteger mod = t.mod(lcm);
		if(fall.compareTo(mod) > 0) {
			tieCnt = tieCnt.subtract((fall.subtract(mod)));
		}
		
		gcd = tieCnt.gcd(t);
		System.out.println(tieCnt.divide(gcd) +"/"+t.divide(gcd));
	}

	public static void main(String[] args) {
		new C().run();
	}
}
