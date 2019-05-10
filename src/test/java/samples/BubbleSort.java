package samples;

public class BubbleSort {

	public static void main(String[] args) {

		BubbleSort br1 = new BubbleSort();
		br1.bsort(new int[] { 1, 4, 5, 2, 8, 9, 0 });

	}

	public void bsort(int[] ary) {

		int length = ary.length;
		System.out.println(length);
		int temp;
		for (int a = 0; a < length; a++) {
			for(int b=a+1;b<length-1;b++)
			if(ary[a]>ary[b]) {
				temp = ary[b];
				ary[b] = ary[a];
				ary[a] = temp;
			}
		}
		for (int x : ary) {
			System.out.print(x + " ");
		}

	}

}
