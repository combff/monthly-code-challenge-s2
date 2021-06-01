package Solution.May;

public class May1 {
    public int solution(int left, int right) {
    	
    	int answer = 0;
    	for(int val = left; val<= right; val++) {
    		int k = (int)Math.sqrt(val); //약수의 개수가 홀수인 경우는 제곱일 때 ***
    		if (Math.sqrt(val)-k == 0.0) //그러므로 제곱근을 통해 조건 체크 
    			answer += (val * -1); 
    		else
    			answer += val;
    	}
        
        return answer;
    }
}
