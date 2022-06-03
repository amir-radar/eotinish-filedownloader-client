package leetCode.algorithms.one;

public class ReverseString2 {

    public static void main(String[] args) {
        String s = "Ratatui epti";
        ReverseString2 rs2 = new ReverseString2();
        System.out.println(rs2.reverseWords(s));
    }

    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        String[] strs = s.split(" ");
        for (int x = 0; x < strs.length; x++){
            sb.append(reverseString(strs[x]));
            if (x != strs.length - 1){
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    private String reverseString(String s){
        StringBuilder sb = new StringBuilder();
        for(int x = 0; x < s.length(); x ++){
            char c = s.charAt(x);
            sb.append(s.charAt(s.length() - 1 -x));
        }
        return sb.toString();
    }
}
