import java.util.Arrays;

public class LostCharacter {
	public int[] getmins(String[] str) {
		int L = str.length;
		int[] res = new int[L];
		for (int i = 0; i < L; i++) {
			String[] tmp = new String[L];
			for (int j = 0; j < L; j++) tmp[j] = str[j];
			for (int j = 0; j < L; j++) tmp[j] = tmp[j].replace('?', i == j ? 'a' : 'z');
			String obj = tmp[i];
			Arrays.sort(tmp);
			for (int j = 0; j < L; j++) {
				if (tmp[j].equals(obj)) {
					res[i] = j;
					break;
				}
			}
		}
		return res;
	}
}
