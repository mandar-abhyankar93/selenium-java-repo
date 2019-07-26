package samples;

import java.util.HashSet;
import java.util.Set;

public class SecondMostFrequentChar {

	public static void main(String[] args) {

		String str = "succcesses";
		char hchars = mostFreq(str);
		System.out.println(hchars);
		str = str.replaceAll(String.valueOf(hchars), "");
		System.out.println(str);
		char schars = mostFreq(str);
		System.out.println(schars);
		
	}
	
	public static char mostFreq(String strng) {
		Set<Character> chr = new HashSet<Character>();
		for(char c : strng.toCharArray()) {
			chr.add(c);
		}
		int high=0;
		char hchar='\0';
		for(char c : chr) {
			int len=strng.length()-strng.replaceAll(String.valueOf(c),"").length();
			if(len>high) {
				high=len;
				hchar=c;
			}
		}
		return hchar;
	}

}
