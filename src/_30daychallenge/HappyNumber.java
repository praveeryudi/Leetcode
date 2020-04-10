package _30daychallenge;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

    public static void main(String[] args) {
        int num = 19;
        System.out.println("Is Happy Number = " + isHappyNumber(num, new HashSet<>()));
    }

    private static boolean isHappyNumber(int N, Set<Integer> cache) {
        if(N == 0) return false;
        if(N == 1) return true;

        int res = getSum(N);
        if(res == 1)
            return true;
        if(cache.contains(res))
            return false;
        cache.add(res);
        return isHappyNumber(res, cache);
    }

    private static int getSum(int num) {
        int sum = 0;
        while(num > 0) {
            int digit = num % 10;
            sum += digit * digit;
            num = num / 10;
        }
        return sum;
    }
}