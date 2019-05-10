package samples;

public class StringToInteger {

	public static void main(String[] args) {

		String num = "123";
		int temp = 0;
		int n;
		int loc = 1;
		char[] x = num.toCharArray();
		for (int i=x.length-1;i>=0;i--) {

			switch (x[i]) {

			case '0':
				n = 0;
				temp = temp + (n * loc);
				loc = loc * 10;
				break;
			case '1':
				n = 1;
				temp = temp + (n * loc);
				loc = loc * 10;
				break;
			case '2':
				n = 2;
				temp = temp + (n * loc);
				loc = loc * 10;
				break;
			case '3':
				n = 3;
				temp = temp + (n * loc);
				loc = loc * 10;
				break;
			case '4':
				n = 4;
				temp = temp + (n * loc);
				loc = loc * 10;
				break;
			case '5':
				n = 5;
				temp = temp + (n * loc);
				loc = loc * 10;
				break;
			case '6':
				n = 6;
				temp = temp + (n * loc);
				loc = loc * 10;
				break;
			case '7':
				n = 7;
				temp = temp + (n * loc);
				loc = loc * 10;
				break;
			case '8':
				n = 8;
				temp = temp + (n * loc);
				loc = loc * 10;
				break;
			case '9':
				n = 9;
				temp = temp + (n * loc);
				loc = loc * 10;
				break;
			default:
				System.out.println("Error");

			}

		}
		
		System.out.println("The integer value is "+temp);

	}

}
