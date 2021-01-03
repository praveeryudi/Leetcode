package solutions;

public class _67_Add_Binary {

    private static String getSum(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        int sum = 0, carry = 0;

        StringBuilder sb = new StringBuilder();
        while(i >= 0 || j >= 0) {
            sum = carry;
            if(i >= 0) {
                sum += a.charAt(i) - '0';
                i--;
            }
            if(j >= 0){
                sum += b.charAt(j) - '0';
                j--;
            }
            sb.append(sum % 2);
            carry = sum / 2;
        }
        if (carry != 0)
            sb.append(carry);
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String a = "1010";
        String b = "1011";
        String result = getSum(a, b);
        System.out.println("Sum = " + result);
    }
}
