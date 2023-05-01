package DSA.journey.Strings;

public class CyclicPermutations {

    public static void main(String[] args) {
        String A = "0011000010";
        String B = "0101000001";
        System.out.println(new CyclicPermutations().solve(A,B));
    }
    public int solve1(String A, String B) {
        if(B.length()==0)return 0;
        int ans=0;
        String temp=B;
       // int a=Integer.parseInt(A);
        for(int i=1;i<=B.length();i++){
            String firstChar=String.valueOf(temp.charAt(0));
            String lastPart=temp.substring(1);
            temp=lastPart+firstChar;
            // int b=Integer.parseInt(temp);
            //int xor=b^a;
            if(temp.equals(A)){
                ans++;
            }
        }
        return ans;
    }


    public int solve11(String A, String B) {
        if(B.length()==0)return 0;
        int ans=0;
        String temp=B;

        // int a=Integer.parseInt(A);
        for(int i=1;i<=B.length();i++){
            String firstChar=String.valueOf(temp.charAt(0));
            String lastPart=temp.substring(1);
            temp=lastPart+firstChar;
            // int b=Integer.parseInt(temp);
            //int xor=b^a;
            if(temp.equals(A)){
                ans++;
            }
        }
        return ans;
    }

    public int solve(String A, String B) {
        String s=A+B;
      //  System.out.println(s);
//        for(int i=0;i<s.length();i++){
//            System.out.print(s.charAt(i)+" ");
//        }
    //    System.out.println("");
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

//        for(int i=0;i<n;i++){
//            System.out.print(z[i]+" ");
//        }
        int ans=0;
        for(int i=1;i<n;i++){
            if(z[i]>=A.length()){
                ans++;
            }
        }
        if(ans==0)return 1;
        return ans;

    }

}
