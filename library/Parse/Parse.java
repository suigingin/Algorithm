public class Parse {
	int index = 0;

	int expression(String sb) {
		int res = term(sb);
		for (; index < sb.length();) {
			if (sb.charAt(index) == '+') {
				index++;
				res += term(sb);
			} else if (sb.charAt(index) == '-') {
				index++;
				res -= term(sb);
			} else {
				break;
			}
		}
		return res;
	}

	int term(String sb) {
		int res = factor(sb);
		for (; index < sb.length();) {
			if (sb.charAt(index) == '*') {
				index++;
				res *= factor(sb);
			} else if (sb.charAt(index) == '/') {
				index++;
				res /= factor(sb);
			} else {
				break;
			}
		}
		return res;
	}

	int factor(String sb) {
		int res = 0;
		if (index < sb.length() && sb.charAt(index) == '(') {
			index++;
			res = expression(sb);
			index++;
		} else {
			res = number(sb);
		}
		return res;
	}

	int number(String sb) {
		int res = 0;
		while (index < sb.length() && Character.isDigit(sb.charAt(index))) {
			res *= 10;
			res += sb.charAt(index) - '0';
			index++;
		}
		return res;
	}
}

