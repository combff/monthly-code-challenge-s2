package Solution.April;

import java.util.Stack;

public class April2 {

	public int solution(String s) { // s 최대 길이 1000, 다행히 범위가 크지않아서 시간 초과에는 벗어난다.
		int answer = 0;
		String s2 = s;

		// "]]))])[])))[]}])])}()(){([([{(((([(([[";
		// 조건1 : 여는 괄호가 닫는 괄호보다 항상 먼저다.
		// 조건2 : 여는 괄호와 닫는 괄호의 1대1 매칭 (s의 길이 짝수)
		// 조건3 : 괄호를 닫을 때 안에 있는 내용이 완벽해야 한다. **** [(]) : fail

		if (s.length() % 2 != 0) // 조건 2 체크
			return 0;

		Stack<String> st = new Stack<>();
		for (int i = 0; i < s.length(); i++) { // s길이만큼 회전한다.

			boolean check = true; // 조건 1 체크
			for (int j = 0; j < s2.length(); j++) {

				if (s2.charAt(j) == '(' || s2.charAt(j) == '[' || s2.charAt(j) == '{') {
					st.push(s2.substring(j, j + 1));
				} else if (s2.charAt(j) == ')') {
					int k = st.search("(");
					if (k < 0) {
						check = false;
						break;
					}

					for (int ii = 0; ii < k; ii++)
						st.pop();

				} else if (s2.charAt(j) == ']') {
					int k = st.search("[");
					if (k < 0) {
						check = false;
						break;
					}
					for (int ii = 0; ii < k; ii++)
						st.pop();

				} else if (s2.charAt(j) == '}') {
					int k = st.search("{");
					if (k < 0) {
						check = false;
						break;
					}
					for (int ii = 0; ii < k; ii++)
						st.pop();
				}

			}

			if (check && st.empty())
				answer++;
			st.clear();

			s2 = turn(s2);
		} // for i

		return answer;
	}

	public String turn(String s) { // 문자열 왼쪽 1씩 shift
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			if (i + 1 >= s.length())
				sb.append(s.charAt(s.length() - (i + 1)));
			else
				sb.append(s.charAt(i + 1));
		}
		return sb.toString();
	}
}
