public class SimilarUserDetection {
	public String haveSimilar(String[] handles) {

		int n = handles.length;
		for (int i = 0; i < n; i++) {
			char[] c = handles[i].toCharArray();
			for (int j = 0; j < c.length; j++) {
				if (c[j] == '0') c[j] = 'O';
				if (c[j] == '1' || c[j] == 'l') c[j] = 'I';
			}
			handles[i] = String.valueOf(c);
		}
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (handles[i].equals(handles[j])) {
					return "Similar handles found";
				}
			}
		}
		return "Similar handles not found";
	}
}
