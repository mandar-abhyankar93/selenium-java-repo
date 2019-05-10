package samples;

class testMultiReturn {

	int add;
	double div;
	int sub;
	
	public testMultiReturn(int a,double d,int s) {
		add = a;
		div = d;
		sub = s;
	}
	
}

class ReturnMoreThanOneValue{
	static int a = 10;
	static int b = 7;
	
	public static void main(String[] args) {
		
		testMultiReturn rm = new testMultiReturn(a+b, a/b, a-b);
		System.out.println(rm.add);
	}
	
}
