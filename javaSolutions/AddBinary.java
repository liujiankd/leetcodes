/*
Given two binary strings, return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100".
*/

public class AddBinary {
    public String addBinary(String a, String b) {
        int alen = a.length();
        int blen = b.length();
        java.util.List<Integer> res = new java.util.LinkedList<Integer>();
        int carry = 0;
        for(alen--, blen--; alen > -1 && blen > -1; alen--, blen--) {
            int cha = a.charAt(alen) - '0';
            int chb = b.charAt(blen) - '0';
            int sum = carry + cha + chb;
            carry = sum / 2;
            res.add(sum % 2);
        }
        while(alen > -1) {
            int sum = carry + a.charAt(alen) - '0';
            carry = sum / 2;
            res.add(sum % 2);
            alen--;
        }
        while(blen > -1) {
            int sum = carry + b.charAt(blen) - '0';
            carry = sum / 2;
            res.add(sum % 2);
            blen--;
        }
        StringBuffer sb = new StringBuffer();
        if(carry == 1) {
            sb.append(1);
        }
        for(int i = res.size() - 1; i > -1; i--) {
            sb.append(res.get(i));
        }
        return sb.toString();
    }
}
