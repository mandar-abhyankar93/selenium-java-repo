package samples;

import java.util.Arrays;

public class SecondHighestNumInArray {
	
	public static void main(String[] args) {
		int[] arry = {1,2,4,5,9,11,0,4,2,1,9,11,12};
		Arrays.sort(arry);
		int highest = arry[arry.length-1];
		for(int x=arry.length-1;x>=0;x--) {
			if(arry[x]!=highest) {
				System.out.println("The second highest is: "+arry[x]);
				break;
			}
			
		}
	}

}
