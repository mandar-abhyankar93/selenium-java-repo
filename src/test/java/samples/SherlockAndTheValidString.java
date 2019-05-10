package samples;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SherlockAndTheValidString {

	public static void main(String[] args) {

		String s = "aabbccddeefghia";
		Set<Integer> st = new HashSet<Integer>();
		Set<Character> chlist = new HashSet<Character>();
		Map<Character, Integer> chm = new HashMap<Character, Integer>();
		char[] ch = s.toCharArray();
		for (char c : ch) {
			chlist.add(c);
			if (chm.get(c) == null) {
				chm.put(c, 1);
			} else {
				chm.put(c, chm.get(c) + 1);
			}
		}
		System.out.println(chm.toString());
		Collection<Integer> obj = chm.values();
		for (Integer i : obj) {
			st.add(i);
		}
		System.out.println(st.toString());
		
		
	}

}
