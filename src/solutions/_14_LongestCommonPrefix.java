package solutions;

public class _14_LongestCommonPrefix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] input = new String[] {"flower","flow","flight"};
		System.out.println(findLCP(input, 0, input.length - 1));
	}
	
	private static String findLCP(String[] arr, int start, int end) {
		if(start == end)
			return arr[start];
		
		int mid = (start + end)/ 2;
		String left = findLCP(arr, start, mid);
		String right = findLCP(arr, mid + 1, end);
		return findLCP(left,right);
	}
	
	private static String findLCP(String s1, String s2) {
		String res = "";
		int i = 0, j = 0;
		while(i < s1.length() && j < s2.length()) {
			if(s1.charAt(i) != s2.charAt(j)) {
				break;
			}
			res = res + s1.charAt(i);
			i++;
			j++;
		}
		return res;
	}

}
