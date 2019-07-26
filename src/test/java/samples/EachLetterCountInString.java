package samples;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class EachLetterCountInString {
	
	public static void main(String[] args) {
		String str = "honorificabilitudinitatibus";
		char[] chr = str.toCharArray();
		HashMap<Character,Integer> count = new HashMap<Character,Integer>();
		for(char c : chr) {
			if(!count.containsKey(c)) {
				count.put(c, 1);
			}
			else {
				count.put(c, count.get(c)+1);
			}
		}
		System.out.println(count.keySet().toString());
		System.out.println(count.values().toString());
		int[] ints = new int[count.values().size()];
		int i = 0;
		for(int x : count.values()) {
			ints[i] = x;
			i = i+1;
		}
		System.out.println(Arrays.toString(ints));
		Arrays.sort(ints);
		System.out.println(Arrays.toString(ints));
	}

}
