package DSA.leetCodeDaily;

import java.util.ArrayList;

public class LongestPalindromicSubsequence {
    int max=Integer.MIN_VALUE;
    public static void main(String[] args) {
        String s="euazbipzncptldueeuechubrcourfpftcebikrxhybkymimgvldiwqvkszfycvqyvtiwfckexmowcxztkfyzqovbtmzpxojfofbvwnncajvrvdbvjhcrameamcfmcoxryjukhpljwszknhiypvyskmsujkuggpztltpgoczafmfelahqwjbhxtjmebnymdyxoeodqmvkxittxjnlltmoobsgzdfhismogqfpfhvqnxeuosjqqalvwhsidgiavcatjjgeztrjuoixxxoznklcxolgpuktirmduxdywwlbikaqkqajzbsjvdgjcnbtfksqhquiwnwflkldgdrqrnwmshdpykicozfowmumzeuznolmgjlltypyufpzjpuvucmesnnrwppheizkapovoloneaxpfinaontwtdqsdvzmqlgkdxlbeguackbdkftzbnynmcejtwudocemcfnuzbttcoew";
        System.out.println( new LongestPalindromicSubsequence().longestPalindromeSubseq(s));
    }

    public int longestPalindromeSubseq(String s) {


        rec(0,s.toCharArray(),new ArrayList<Character>());
        return max;
    }

    private void rec(int index,char[] arr, ArrayList<Character> list) {

        if(index>=arr.length){

            if(isPallindrome(list)){
                int size=list.size();
              max=Math.max(max,size);
            }
            return;
        }

        list.add(arr[index]);
        rec(index+1,arr,list);
        list.remove(list.size()-1);
        rec(index+1,arr,list);

    }

    private boolean isPallindrome(ArrayList<Character> arr) {
        for(int i=0;i<arr.size()/2;i++){
            if(arr.get(i)!=arr.get(arr.size()-1-i)){
             return false;
            }
        }
        return true;
    }
}
