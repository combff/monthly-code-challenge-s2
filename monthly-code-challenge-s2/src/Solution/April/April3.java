package Solution.April;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;


public class April3 {
	public long solution(int[] a, int[][] edges) { // 모두 0으로 만들기

		// 그리디(탐욕) 알고리즘 : 그 상황에서 최고의 선택하기
		// 리프노드부터 0으로 만들기
		// 리프노드란 엣지가 한 개인 경우 ***

		long sum = 0;
		boolean zero = true;
		long[] aa = new long[a.length]; // int -> long ***
		// a 배열의 값이 각각 -1,000,000 이상 1,000,000 이하이므로 연산을 하다보면 int를 넘어감 
		// 그러므로 꼭 long으로 바꿔야 돼
		for (int i = 0; i < a.length; i++) {
			sum += a[i];
			aa[i] = a[i];
			if (a[i] != 0)
				zero = false;
		}

		if (sum != 0)
			return -1;
		//값을 옮겨서 0으로 만든다는 말은 해당 값을 다 더하면 0이라는 뜻 ( + 와 - )

		if (zero)
			return 0;
		//a의 값이 모두 0이면 return도 0

		ArrayList<Integer>[] node = new ArrayList[aa.length]; //-1,000,000 이상 1,000,000 이하
		for (int i = 0; i < aa.length; i++) {
			node[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < edges.length ; i++) {
			node[edges[i][0]].add(edges[i][1]);
			node[edges[i][1]].add(edges[i][0]);
		}
		
		
		long answer = 0;
		int[] leaf = new int[aa.length];
		int index = 0;
		for (int i = 0; i < aa.length; i++) {
			Collections.sort(node[i]); //*** 정렬을 해야 array에서 값을 찾을 때 시간이 덜 든다 indexof
			if (aa[i] != 0 && node[i].size() == 1) {  
				leaf[index] = i; //leaf 노드에 대한 index 저장하기
				index++;
			}				
		}
		
		
		for (int jj = 0; jj < aa.length/2; jj++) { // 2 이상 300,000	=> max 인 경우 : leaf 가 2개일때
		
			HashSet<Integer> set = new HashSet<>(); // 그 다음 leaf 노드 후보들을 담기. set으로 해야 중복이 안됨 
			for (int j = 0; j < index; j++) { 
				
				int i = leaf[j];
				if (aa[i] == 0 || node[i].size() != 1 ) { 
					set.remove(i);
					continue;
				}
					
				
				answer += Math.abs(aa[i]);
				int k = node[i].get(0); //leaf 노드이므로 index 무조건 0 이다
				aa[k] += aa[i]; 
				aa[i] = 0;
				int ii = node[k].indexOf(i); //sort를 안하면 이 부분에서 시간초과가 뜸
				node[k].remove(ii); //값을 계산한 edge 지우기
				node[i].remove(0);
				if (aa[k] != 0 && node[k].size() == 1)
					set.add(k);
			}//for j

			if (set.size() == 0) 
				break;

			index = 0;
			for(int i : set) { 
				if (aa[i] != 0 && node[i].size() == 1) {
					leaf[index] = i;
					index++;
				}				
			}	
		}// for jj

		return answer;
	}

}
