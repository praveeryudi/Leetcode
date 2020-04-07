package solutions;

import java.util.HashMap;
import java.util.Map;

public class _70_ClimbingStairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int steps = 10;
		int ways = numberOfWays(steps, new HashMap<Integer,Integer>());
		System.out.println("Total Ways = " + ways);
	}
	
	private static int numberOfWays(int n, Map<Integer,Integer> cache) {
		
		if(n < 0)
			return 0;
		
		if(n == 0)
			return 1;
		
		if(cache.containsKey(n))
			return cache.get(n);
		
		return numberOfWays(n-2, cache) + numberOfWays(n-1, cache);
	}

}
