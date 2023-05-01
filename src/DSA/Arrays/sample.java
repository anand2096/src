package DSA.Arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class sample {
    public static void main(String[] args) {


        sample.countWords("This.has.words,letters....separated.by.delimeters");
        //sample.reverse("This34#is@&special");

    }
    public static void reverse(String s){
        List<Character> ch=new ArrayList<>();
        ch.add('#');ch.add('@');ch.add('&');ch.add('$');
       int i=0;int j=s.length()-1;
       char[] c=s.toCharArray();

      while(i<j){
          if(ch.contains(s.charAt(i))){
              i++;
          }
          if(ch.contains(s.charAt(j))){
              j--;
          }else
          {char temp=c[i];
              c[i]=c[j];
              c[j]=temp;
              i++;j--;

          }
      }
        System.out.println(c.toString());
       for(int k=0;k<c.length;k++){
           System.out.print(c[k]+"");
       }
    }
    public static int countWords(String input1 ){
        int ans=0;
        int wcount=0;
        int dcount=0;
        int pindex=0;
        System.out.println(input1.split(",|\\.").length);
        StringTokenizer tokens = new StringTokenizer(input1);
        System.out.println(tokens.countTokens());
        for(int i=0;i<input1.length();i++){
            if(input1.charAt(i)=='.'||input1.charAt(i)==',')
            {
                dcount++;

                if(i!=0&&!(input1.charAt(i-1)=='.'||input1.charAt(i-1)==',')){
                    wcount++;

            }

            }

        }

        return wcount+dcount;
    }
}
