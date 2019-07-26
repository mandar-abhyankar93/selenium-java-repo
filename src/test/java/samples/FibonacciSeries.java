package samples;

public class FibonacciSeries {
	
	public static void main(String[] args) {
		
		int upto=200;
		int f=1;
		int s=1;
		int temp;
		System.out.print(f+" "+s+" ");
		for(int i=0;i<upto;i++) {
			temp = f+s;
			if(temp<upto) {
			System.out.print(temp+" ");
			f=s;
			s=temp;
		}
		}
		
	}

}
