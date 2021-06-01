package Solution.May;

public class May2 {
	public long[] solution(long[] numbers) {
		long[] answer = new long[numbers.length];

		long[] change = {};
		for (int ii = 0; ii < numbers.length; ii++) {

			change = bit(numbers[ii]);

			for (int i = 0; i < change.length - 1; i++) {
				if (change[i] == 0 && change[i + 1] == 0) { // 00 => 01
					change[i] = 1;
					break;
				} else if (change[i] == 0 && change[i + 1] == 1) { // 01 => 10
					change[i] = 1;
					break;
				} else if (change[i] == 1 && change[i + 1] == 0) {// 10 => 01
					change[i + 1] = 1;
					change[i] = 0;
					break;
				}
			}
			answer[ii] = ten(change);
		}

		return answer;
	}

	public long[] bit(long n) {

		int index = 0;
		long[] bi = new long[50];
		while (true) {

			if (n == 1 || n == 0) {
				bi[index] = n;
				index++;
				break;
			}

			bi[index] = n % 2;
			n = n / 2;
			index++;

		}
		return bi;
	}
	public long ten(long[] n) {
		long res = 0;
		for(int i = 0; i<n.length;i++) {
			res += (Math.pow(2, i) * n[i]); 
		}
		return res;
	}
}
