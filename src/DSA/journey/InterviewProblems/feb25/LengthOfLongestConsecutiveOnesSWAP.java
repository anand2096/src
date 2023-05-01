package DSA.journey.InterviewProblems.feb25;

public class LengthOfLongestConsecutiveOnesSWAP {
    public static void main(String[] args) {
        String A = "111111";
        System.out.println(new LengthOfLongestConsecutiveOnesSWAP().solve(A));
    }

    public int solve(String s) {
        int ans = Integer.MIN_VALUE;
        int oneCount=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1'){
                oneCount++;
            }
        }
        if(oneCount==s.length()){
            return s.length();
        }
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                int left = 0;
                int right = 0;
                //calculate left one's
                for (int j = i - 1; j >= 0; j--) {
                    if (s.charAt(j) == '1') {
                        left++;
                    } else {
                        break;
                    }
                }
                //calculate right one's
                for (int k = i + 1; k < s.length(); k++) {
                    if (s.charAt(k) == '1') {
                        right++;
                    } else {
                        break;
                    }
                }
                //calculate max by adding left and right
                if(left+right==oneCount){
                    ans = Math.max(ans, left + right);
                }
                else{
                ans = Math.max(ans, left + right + 1);}
            }
        }

        return ans;
    }


}
