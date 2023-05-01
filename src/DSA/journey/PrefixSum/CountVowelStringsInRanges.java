package DSA.journey.PrefixSum;

public class CountVowelStringsInRanges {
    public static void main(String[] args) {
        String []words = {"aba","bcb","ece","aa","e"};
        int [][]queries = {{0,2},{1,4},{1,1}};
    //    String []words = {"a","e","i"};
      //  int [][]queries = {{0,2},{0,1},{2,2}};
        int ans[]=new CountVowelStringsInRanges().vowelStrings(words,queries);
        for(int i=0;i<ans.length;i++){
            System.out.print(ans[i]+ " ");
        }
    }
    public int[] vowelStrings(String[] words, int[][] queries) {
        int ans[]=new int[queries.length];
        int prefix[]=new int [words.length];
        if(isVowel(words[0].charAt(0))&& isVowel(words[0].charAt(words[0].length()-1))){
            prefix[0]=1;
        }
        else{
            prefix[0]=0;

        }
        for(int i=1;i<words.length;i++){
            if(isVowel(words[i].charAt(0))&& isVowel(words[i].charAt(words[i].length()-1))){
                prefix[i]=prefix[i]+prefix[i-1]+1;
            }
            else{
                prefix[i]=prefix[i]+prefix[i-1];
            }
        }
        for(int i=0;i<queries.length;i++){
            int start=queries[i][0];
            int end=queries[i][1];
            if(start==end){
                String word=words[start];
                if(isVowel(word.charAt(0))&& isVowel(word.charAt(word.length()-1))) {
                    ans[i]=1;
                }
                else{
                ans[i]=0;
                }
            }
            else if(start==0){
                ans[i]=prefix[end];
            }
            else{
                ans[i]=prefix[end]-prefix[start-1];
            }
        }


return ans;
    }

    public boolean isVowel(char c){
        return c=='a'|| c=='e'||c=='i'||c=='o'||c=='u';
    }
}
