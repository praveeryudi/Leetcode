package solutions;

public class _7_ReverseInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = 45;
		System.out.println(reverse(N));
	}
	
	private static int reverse(int n) {
		int reversed = 0;
		while(n > 0) {
			reversed = (reversed * 10) + (n % 10);
			n = n/10;
		}
		if(reversed > Integer.MAX_VALUE)
			return 0;
		return reversed;
	}

}
