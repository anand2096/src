package DSA.leetCodeDaily;

public class VerifyingAnAlienDictionary {


    public static void main(String[] args) {
        String [] words = {"apple","app"};
        String order = "abcdefghijklmnopqrstuvwxyz";
        System.out.println(new VerifyingAnAlienDictionary().isAlienSorted(words,order));
    }

    public boolean isAlienSorted(String[] words, String order) {
        if(words.length==1) return true;
        boolean ans = true;
        for (int i = 0; i < words.length-1; i++) {
            char[] first = words[i].toCharArray();
            char[] second = words[i+1].toCharArray();
            if (!checkOrder(first, second, order))
                return false;
        }
        return ans;
    }

    public boolean checkOrder(char[] s1, char[] s2, String order) {
        int len1 = s1.length;
        int len2 = s2.length;

        for (int i = 0; i < len1 && i < len2; i++) {
            if (order.indexOf(s1[i]) == order.indexOf(s2[i])) {
                continue;
            } else if (order.indexOf(s1[i]) < order.indexOf(s2[i]))
                return true;
            else
                return false;
        }

        if (len1 > len2) return false;
        else return true;

    }
}
