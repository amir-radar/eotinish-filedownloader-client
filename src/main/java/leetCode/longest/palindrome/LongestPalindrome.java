package leetCode.longest.palindrome;

import java.util.ArrayList;
import java.util.List;

public class LongestPalindrome {

    public static void main(String[] args) {
        LongestPalindrome palindrome = new LongestPalindrome();
        String str = "cbbd"; //aacakdbacaa //aaaaaaaaaabcaaaaaaaaaaa //abb //cbbd
        System.out.println(palindrome.getLongestPalindrome(str));
    }

    public String getLongestPalindrome(String s){
        String revStr = reverseString(s);
        if (s.equals(revStr)){
            return s;
        }
        for (int i = 1; i < s.length(); i++) {
            List<String> allSubStrings = getAllSubStrings(s, i);
            for (String subStr : allSubStrings) {
                if (revStr.contains(subStr)){
                    if (isPalindrome(subStr)){
                        return subStr;
                    }
                }
            }
        }
        return null;
    }

    public List<String> getAllSubStrings(String str, int drawLength){
        //aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabcaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
        List<String> subStrings = new ArrayList<>();
        for (int i = 0; i <= drawLength; i++) {
            subStrings.add(str.substring(i, str.length() - (drawLength - i)));
        }
        return subStrings;
    }

    public boolean isPalindrome(String str){
        String revStr = reverseString(str);
        return str.equals(revStr);
    }


    public String reverseString(String str){
        char[] chars = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = chars.length - 1; i >= 0; i--) {
            sb.append(chars[i]);
        }
        return sb.toString();
    }
}
