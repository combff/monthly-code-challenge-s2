package Solution.May;

import java.util.Stack;

public class May3 {
	public String[] solution(String[] s) {
		String[] answer = new String[s.length];

		for (int i = 0; i < s.length; i++) {

			String s2 = s[i];
			Stack<String> st = new Stack<>();
			StringBuilder res = new StringBuilder();
			StringBuilder sb = new StringBuilder();
			int cnt = 0; //110 횟수
			// stack을 이용하여 110 이 나올수있는 모든 경우를 뺀다
			for (int j = 0; j < s2.length(); j++) { // 1110 => 1  (110 빼기)
				st.push(s2.substring(j, j + 1));
				if (st.size() >= 3 && s2.substring(j, j + 1).equals("0")) { 
					String str1 = st.pop(); // 0
					String str2 = st.pop(); // 1
					String str3 = st.pop(); // 1
					if (str1.equals("0") && str2.equals("1") && str3.equals("1")) //101
						cnt++;
					else {
						st.push(str3);
						st.push(str2);
						st.push(str1);
					}
				}
			}//for j

			for (String ss : st) {
				sb.append(ss);	
			}
			s2 = sb.toString();
			boolean check = true;
			for(int j=0; j<s2.length();j++) {
				if (s2.charAt(j) == '1') { // 110을 제외한 나머지 문자열중에서 1 다음에 어떤 숫자가 오는지 체크한다.
					if (j+1 >= s2.length() || s2.charAt(j+1) != '0') { 
						// 110 사전순이 높으려면 111 연속이 되면 안된다. 즉 1 다음에 110이 오면 1110 이 되기 때문에
						// 1 다음에 0 -> 10110 인 경우만 제외  ****
						// 그 나머지는 1보다 앞에 110이 온다 -> 1101
						for (int jj = 0; jj < cnt; jj++) // 110 횟수만큼
							res.append("110");
						check = false;
						res.append(s2.substring(j));
						break;
					}
					res.append("1");
				}else
					res.append(s2.substring(j,j+1));
			}
			
			if (check) {
				for (int jj = 0; jj < cnt; jj++)
					res.append("110");
			}
			answer[i] = res.toString();
		} // for i

		return answer;
	}

}
