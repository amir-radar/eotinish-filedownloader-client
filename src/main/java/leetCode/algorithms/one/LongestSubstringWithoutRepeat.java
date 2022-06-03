package leetCode.algorithms.one;

import java.util.ArrayList;
import java.util.List;

public class LongestSubstringWithoutRepeat {

    public static void main(String[] args) {
        LongestSubstringWithoutRepeat longestSubstr = new LongestSubstringWithoutRepeat();
        String str = "abcabcbb";
        System.out.println(longestSubstr.lengthOfLongestSubstring(str));
        //System.out.println(str.c);
    }

    public int lengthOfLongestSubstring(String s){
        List<String> strs = new ArrayList<>();
        int maxLength = 0;
        if (s.length() > 0){
            String str = s;
            for (int x = 0; x < s.length(); x++){
                str = s.substring(x, s.length());
                int temp = 0;
                String newStr = String.valueOf(str.charAt(0));
                while (temp < str.length() - 1 && !newStr.contains(String.valueOf(str.charAt(temp + 1)))){
                    newStr = newStr + str.charAt(temp + 1);
                    temp++;
                }
                if (newStr.length() > maxLength){
                    maxLength = newStr.length();
                }
            }
        }
        return maxLength;
    }
}
