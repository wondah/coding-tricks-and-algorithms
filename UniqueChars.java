import java.util.HashMap;

public class UniqueChars {

	/*
	 * Implement an algorithm to determine if a string has all unique characters.
	 */
	
	/*
	 * Solutions bellow assume string is only made out of 128 element ASCII
	 * table.
	 */
	
	/*
	 *  N - length of the string
	 * Time Complexity:		O(N)
	 * Space Complexity:	O(N)	(HashMap storage)
	 */
	public static boolean hasUniqueChars1(String s) {
		if(s.length() > 128) {
			return false;
		}
		HashMap<Character, Boolean> map = new HashMap<Character, Boolean>();
		for(int i = 0; i < s.length(); i++) {
			if(map.get(s.charAt(i)) != null) {
				return false;
			}
			map.put(s.charAt(i), true);
		}
		return true;
	}
	
	/*
	 *  N - length of the string
	 * Time Complexity:		O(N)
	 * Space Complexity:	O(1)
	 */
	public static boolean hasUniqueChars2(String s) {
		if(s.length() > 128) { // 128 - size of ASCII chart
			return false;
		}
		boolean[] uniqueChars = new boolean[256];
		for(int i = 0; i < s.length(); i++) {
			char curr = s.charAt(i);
			if(uniqueChars[curr]) {
				return false;
			}
			uniqueChars[curr] = true;
		}
		return true;
	
	/*
	 *  N - length of the string
	 * Time Complexity:		O(N)
	 * Space Complexity:	O(1)	(reduced by a factor of 8)
	 */
	public static boolean hasUniqueChars3(String s) {
		if(s.length() > 128) { // 128 - size of ASCII chart
			return false;
		}
		int bitvector = 0;
		for(int i = 0; i < s.length(); i++) {
			int asciiVal = (int) s.charAt(i);
			if((bitvector & (1 << asciiVal)) != 0) {
				return false;
			}
			bitvector |= (1 << asciiVal);
		}
		return true;
	}
}
