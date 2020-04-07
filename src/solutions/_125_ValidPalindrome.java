package solutions;

public class _125_ValidPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str = "A man, a plan, a canal: Panama";
		
		boolean isValid = isValidPalindrome(str);
		System.out.println("Is Valid Palindrome = " + isValid);
	}
	
	private static boolean isValidPalindrome(String str) {
		
		if(null == str || str.isEmpty())
			return true;
		
		int left = 0;
		int right = str.length() - 1;
		char[] arr = str.toCharArray();
		
		while(left < right) {
			
			while(left < right && !Character.isLetterOrDigit(arr[left])) {
				left++;
			}
			
			while(left < right && !Character.isLetterOrDigit(arr[right])) {
				right--;
			}
			
			if(Character.toLowerCase(arr[left]) != Character.toLowerCase(arr[right]))
				return false;
			
			left++;
			right--;
		}
		
		return true; 
	}

}
