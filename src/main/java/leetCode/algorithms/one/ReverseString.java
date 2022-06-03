package leetCode.algorithms.one;

import java.util.ArrayList;
import java.util.List;

public class ReverseString {

    public static void main(String[] args) {
        char[] s = new char[]{'h', 'e', 'l', 'l', 'o'};

        ReverseString rs = new ReverseString();
        rs.reverseString(s);
    }

    public void reverseString(char[] s) {
        char[] ch = new char[s.length];
        List<Character> chars = new ArrayList<>();
        for(int x = s.length - 1; x >= 0; x--){
            chars.add(s[x]);
        }
        for(int y = 0; y < ch.length; y++){
            ch[y] = chars.get(y);
        }
        s = ch;
    }
}
