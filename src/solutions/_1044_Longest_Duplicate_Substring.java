package solutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _1044_Longest_Duplicate_Substring {

    public static void main(String[] args) {
        String str = "ABRACADABRA";
        int len = str.length();
        List<String> suffixArr = new ArrayList<>();
        for(int index = 0; index < len; index++) {
            suffixArr.add(str.substring(index));
        }
        Collections.sort(suffixArr);
        len = suffixArr.size();
        int maxLength = Integer.MIN_VALUE;
        String output = null;
        for(int index = 0; index < len - 1; index++) {
            String str1 = suffixArr.get(index);
            String str2 = suffixArr.get(index + 1);
            String prefixMatch = lcp(str1, str2);
            if(prefixMatch.length() > maxLength) {
                maxLength = prefixMatch.length();
                output = prefixMatch;
            }
        }
        System.out.println("Longest duplicate substring = " + output);
    }

    private static String lcp(String a, String b) {
        int i = 0, j = 0;
        StringBuilder res = new StringBuilder();
        while(i < a.length() && j < b.length()) {
            if(a.charAt(i) != b.charAt(j)) {
                break;
            }
            res.append(a.charAt(i));
            i++;
            j++;
        }
        return res.toString();
    }

}
