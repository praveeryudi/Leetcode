package solutions;

import java.util.*;

public class RandomizedSet {

    private Map<Integer, Integer> dataHash;
    private List<Integer> dataArr;

    /** Initialize your data structure here. */
    private RandomizedSet() {
        dataHash = new HashMap<>();
        dataArr = new ArrayList<>();
    }

    public static void main(String[] args) {
        RandomizedSet obj = new RandomizedSet();
        boolean param_1 = obj.remove(0);
        System.out.println(param_1);
        boolean param_2 = obj.remove(0);
        System.out.println(param_2);
        boolean param_3 = obj.insert(0);
        System.out.println(param_3);
        int param_4 = obj.getRandom();
        System.out.println(param_4);
        boolean param_5 = obj.remove(0);
        System.out.println(param_5);
        boolean param_6 = obj.insert(0);
        System.out.println(param_6);
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    private boolean insert(int val) {
        if(dataHash.containsKey(val))
            return false;
        dataArr.add(val);
        dataHash.put(val, dataArr.size()-1);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    private boolean remove(int val) {
        if(!dataHash.containsKey(val))
            return false;
        int index = dataHash.get(val);
        int size = dataArr.size();
        Collections.swap(dataArr, index, size-1);

        dataHash.put(dataArr.get(index), index);
        dataArr.remove(size-1);
        dataHash.remove(val);
        return true;
    }

    /** Get a random element from the set. */
    private int getRandom() {
        Random random = new Random();
        int randIndex = random.nextInt(dataArr.size());
        return dataArr.get(randIndex);
    }
}
