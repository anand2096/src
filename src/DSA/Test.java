package DSA;

import java.util.*;


//1 2 3



public class Test {
    public static void main(String[] args) {

        System.out.println(new Test().solve("ccdbaeeceecabaacebcaebdceaacdcdcbbadcebcaaceaebcdacccaedcbccacedaacdbaaeacdbeedccceeabececcc"));

    }

    public int solve(String s) {




        return rec(0,s,"");



    }
    public int rec(int i,String s,String curr){

        if(i>=s.length()){
            if(isPallindrome(curr)){
                return curr.length();
            }
            else{
                return 0;
            }
        }

        int choice1=0;
        int choice2=0;


        choice1=rec(i+1,s,curr+s.charAt(i));

        choice2=rec(i+1,s,curr);

        return Math.max(choice1,choice2);



    }

    public boolean isPallindrome(String s){
        int i=0;
        int j=s.length()-1;
        while(i<=j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }


}