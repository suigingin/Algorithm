import java.util.Arrays;

public class FilipTheFrog {

	public int countReachableIslands(int[] positions, int L) {
		int start = positions[0];
		Arrays.sort(positions);
		int startIndex = Arrays.binarySearch(positions, start);

		int cnt = 1;
		for (int i = startIndex; i < positions.length - 1; i++) {
			if (positions[i + 1] - positions[i] <= L) cnt++;
			else break;
		}
		for (int i = startIndex; i >= 1; i--) {
			if (positions[i] - positions[i - 1] <= L) cnt++;
			else break;
		}
		return cnt;
	}
}
