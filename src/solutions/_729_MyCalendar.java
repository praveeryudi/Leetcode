package solutions;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Map;
import java.util.TreeMap;

class _729_MyCalendar {

    private TreeMap<Integer, Integer> map;

    public _729_MyCalendar() {
        this.map = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        Map.Entry<Integer, Integer> entry = map.lowerEntry(end);
        System.out.println(entry);
        if(entry == null || entry.getValue() <= start){
            map.put(start, end);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        _729_MyCalendar obj = new _729_MyCalendar();
        /*System.out.println(obj.book(10, 20));
        System.out.println(obj.book(15, 25));
        System.out.println(obj.book(20, 30));*/

        String input = "To be converted to bytes";
        byte[] byteArr = input.getBytes(StandardCharsets.UTF_8);
        for(int i=0; i< byteArr.length ; i++) {
            System.out.print(byteArr[i] +" ");
        }
        System.out.println("First byte: " + byteArr[0]);
        byte x = 0x7f; //0111_1111
        // Perform logical AND operation on the first byte
        byteArr[0] &= x;
        System.out.println("First byte after: " + byteArr[0]);
    }
}
