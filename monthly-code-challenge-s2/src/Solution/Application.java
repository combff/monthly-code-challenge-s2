package Solution;

import Solution.April.April2;

public class Application {
	   public static void main(String[] args) {

		   StringBuilder sb = new StringBuilder();
		   while(true) {
//			   if ( (int)(Math.random()*5) == 0)
				   sb.append(")(");
//			   else if ( (int)(Math.random()*5) == 1)
				   sb.append(")");
//			   else if ( (int)(Math.random()*5) == 2)
				   sb.append("{(");
//			   else if ( (int)(Math.random()*5) == 3)
				   sb.append("}");
//			   else if ( (int)(Math.random()*5) == 4)
				   sb.append("{");
//			   else if ( (int)(Math.random()*5) == 5)
				   sb.append("}(");
			   if(sb.length() == 90)
				   break;
			   
		   }
		   
//		   System.out.println("len : "+ sb.length());
//		   System.out.println(sb.toString());
		   April2 a2 = new April2();
		   String tmp = "()(){([([{(((([(([[]]))])[])))[]}])])}"; 
		   System.out.println("tmp len : "+ tmp.length());
//		   System.out.println(a2.solution(sb.toString())); 
		   System.out.println(a2.solution(tmp)); 
		   
	   }
}
