package level2.enroutesalute;

public class Solution {
    public static String answer(String s){
        int nSalutes = 0;
        for (int i = 0; i < s.length(); i++) {
            char token = s.charAt(i);
            if(token == '>') nSalutes += s.substring(i).chars().filter(ch -> ch == '<').count();
        }
        return String.valueOf(nSalutes*2);
    }
}
