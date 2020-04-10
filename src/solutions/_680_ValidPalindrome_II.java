package solutions;

public class _680_ValidPalindrome_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "abca";
		System.out.println("Is Valid = " + isValidPalindrome(str));
	}
	
	private static boolean isValidPalindrome(String input) {
		
		int start = 0;
		int end = input.length() - 1;
		
		while(start < end) {
			if(input.charAt(start) != input.charAt(end))
				return isPalindrome(input, start + 1, end) || isPalindrome(input, start, end - 1);
			
			start++;
			end--;
		}
		return false;
	}
	
	private static boolean isPalindrome(String input, int left, int right) {
		while(left <= right) {
			if(input.charAt(left) != input.charAt(right))
				return false;
			left++;
			right--;
		}
		return true;
	}

}
