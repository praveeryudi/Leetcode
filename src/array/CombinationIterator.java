package array;

import java.util.*;

public class CombinationIterator {

    private char[] input;
    private int size;
    private Queue<String> combinations;

    private CombinationIterator(String input, int size) {
        this.input = input.toCharArray();
        this.size = size;
        this.combinations = new LinkedList<>();
    }

    private void permute(int start, int end) {
        if(start > end)
            return;
        if(start == end) {
            char[] res = String.valueOf(input).substring(0, size).toCharArray();
            Arrays.sort(res);
            if(!combinations.contains(String.valueOf(res)))
                combinations.add(String.valueOf(res));
        }
        for(int index = start; index <= end; index++) {
            swap(input, start, index);
            permute(start + 1, end);
            swap(input, start, index);
        }
    }

    private void swap(char[] input, int index1, int index2) {
        char temp = input[index1];
        input[index1] = input[index2];
        input[index2] = temp;
    }

    public static void main(String[] args) {
        CombinationIterator iterator = new CombinationIterator("aceghjlmnqsu", 2); // creates the iterator.
        iterator.permute(0, iterator.input.length - 1);
        System.out.println(iterator.combinations);

        System.out.println(iterator.next()); // returns "ab"
        System.out.println(iterator.hasNext()); // returns true
        System.out.println(iterator.next()); // returns "ac"
        System.out.println(iterator.hasNext()); // returns true
        System.out.println(iterator.next()); // returns "bc"
        System.out.println(iterator.hasNext()); // returns false
    }

    private boolean hasNext() {
        return !combinations.isEmpty();
    }

    private String next() {
        if(hasNext()) {
            return combinations.poll();
        }
        return null;
    }

}
