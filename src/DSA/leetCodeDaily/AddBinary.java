package DSA.leetCodeDaily;

public class AddBinary {

    public static void main(String[] args) {
        String a = "11";
        String b = "1001";
        System.out.println(new AddBinary().addBinary(a, b));
    }

    public String addBinary(String a, String b) {
        int carry = 0;
        int al = a.length() - 1;
        int bl = b.length() - 1;
        String ans = "";
        while (al >= 0 && bl >= 0) {
            if (a.charAt(al) == '1' && b.charAt(bl) == '1') {
                if (carry == 1) {
                    ans = ans + "1";
                } else {
                    ans = ans + "0";
                    carry = 1;
                }
            }
            else if (a.charAt(al) == '0' && b.charAt(bl) == '0') {
                if (carry == 1) {
                    ans = ans + "1";
                    carry=0;
                } else {
                    ans = ans + "0";
                }
            }
            else if (a.charAt(al) == '1' && b.charAt(bl) == '0') {
                if (carry == 1) {
                    ans = ans + "0";

                } else {
                    ans = ans + "1";
                }
            }
            else if (a.charAt(al) == '0' && b.charAt(bl) == '1') {
                if (carry == 1) {
                    ans = ans + "0";
                } else {
                    ans = ans + "1";
                }
            }

            al--;
            bl--;
        }
        while (al >= 0) {
            if (a.charAt(al) == '1') {
                if (carry == 1)
                    ans = ans + "0";
                else
                    ans = ans + "1";
            } else {
                if (carry == 1) {
                    ans = ans + "1";
                    carry=0;
                }

                else
                    ans = ans + "0";
            }
            al--;
        }


        while (bl >= 0) {
            if (b.charAt(bl) == '1') {
                if (carry == 1)
                    ans = ans + "0";
                else
                    ans = ans + "1";
            } else {
                if (carry == 1)
                {ans = ans + "1";
                carry=0;}
                else
                    ans = ans + "0";
            }
            bl--;
        }

        if(carry==1)
            ans=ans+"1";
StringBuilder sb=new StringBuilder(ans);
        return sb.reverse().toString();
    }


}
