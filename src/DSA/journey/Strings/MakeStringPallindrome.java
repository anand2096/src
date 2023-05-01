package DSA.journey.Strings;

public class MakeStringPallindrome {

    public static void main(String[] args) {
              String s="aaaa";
        //i f x d f l n l y a e m u h g q g h u m e a y l n l f d x f i
        System.out.println();
        System.out.println(new MakeStringPallindrome().solve(s));

    }
// total even then -1
    public int solve(String s) {
        s=s+"$"+new StringBuilder(s).reverse().toString();
        //  System.out.println(s);
        int n=s.length();
        int z[]=new int[n];
        z[0]=-1;
        int l=0;
        int r=0;
        for(int i=1;i<n;i++){
            if(i>r){
                l=i;
                r=i;
                while(r<n && s.charAt(r)==s.charAt(r-l)){
                    r++;
                }
                z[i]=r-l;
                r--;
            }
            else{
                int k=i-l;
                if(z[k]<r-i+1){
                    z[i]=z[k];
                }
                else{
                    l=i;
                    while(r<n&&s.charAt(r)==s.charAt(r-l)){
                        r++;
                    }
                    z[i]=r-l;
                    r--;
                }
            }
        }
        int count=0;
        int start=0;
        for(int i=0;i<z.length;i++){
            if(s.charAt(i)=='$') start=i; //find the dollar position
            else if(start!=0){

                if(((i-start+z[i]))*2>=s.length()) // if greater than array length return count
                    return count;
                count++;
            }
        }
        return -1;

//        for(int i=0;i<n;i++){
//            System.out.print(z[i]+" ");
//        }
//        int ans=0;
//        for(int i=1;i<n;i++){
//            if(z[i]==0){
//                ans++;
//            }
//        }
//        if(ans==0)return 0;
//        return (n+ans)/2;

    }




    public int solveWrong(String s) {
        StringBuilder sb=new StringBuilder(s);
        int count=0;
        int i=0;
        int n=s.length()-1;
        int j=n;
        int t=0;
        while(i<=j){
            if(sb.charAt(i)!=sb.charAt(j)){
             //   s=s.charAt(j)+s;
                sb.insert(i,sb.charAt(j));
                count++;
                i++;

            }
            else{
                i++;
                j--;
            }

        }
        //i   f  x  d  f  l   n   l  y  a   e  m   u   h    g   q   g    h    u   m   e   a   y   l   n   l  f  d  x f   i
        System.out.println(sb.toString());
        return count;
    }
}
