package DSA.leetCodeDaily;

public class MaximizeConfustionExam {

    public static void main(String[] args) {
        String answerKey = "FFTFTTTFFTTTTFTTFFTFTTFTFTTFFFTTTTFFFTFFFFTTFTFTTFFFFTFTFTFTTFFTFFTFFFFFFTTFFTFFTFFTFFFFFTFTTFFTTFTT";
        int k = 10;
        System.out.println(new MaximizeConfustionExam().maxConsecutiveAnswers(answerKey,k));
    }

    public int maxConsecutiveAnswers(String s, int k) {

        int n=s.length();
        int i=0;
        int j=0;
        int tCnt=0;
        int fCnt=0;
        int max1=Integer.MIN_VALUE;
        int max2=Integer.MIN_VALUE;
        while(j<n){

            if(s.charAt(j)=='T'){
                j++;
            }
            else{
                if(fCnt<=k){
                    max1=Math.max(max1,j-i);
                }
                fCnt++;

                while(fCnt>k){
                    if(s.charAt(i)=='F'){
                        fCnt--;
                    }
                    i++;
                }

                j++;

            }

        }

        while(i<n&& fCnt>k){
            if(s.charAt(i)=='F'){
                fCnt--;
            }
            i++;
        }

        if(fCnt<=k){
            max1=Math.max(max1,j-i);
        }
        j=0;
        i=0;
        while(j<n){

            if(s.charAt(j)=='F'){
                j++;
            }
            else{
                if(tCnt<=k){
                    max2=Math.max(max2,j-i);
                }
                tCnt++;

                while(tCnt>k){
                    if(s.charAt(i)=='T'){
                        tCnt--;
                    }
                    i++;
                }
                j++;

            }

        }
        while(i<n&&fCnt>k){
            if(s.charAt(i)=='T'){
                tCnt--;
            }
            i++;
        }
        if(tCnt<=k){
            max2=Math.max(max2,j-i);
        }
        if(max1>max2)return max1;
        return max2;

    }
}
