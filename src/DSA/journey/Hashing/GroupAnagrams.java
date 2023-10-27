package DSA.journey.Hashing;

import java.util.ArrayList;
import java.util.List;

public class GroupAnagrams {
    public static void main(String[] args) {

   //     String [] strs = {"eat","tea","tan","ate","nat","bat"};
        String [] strs = {"","",""};
        System.out.println(new GroupAnagrams().groupAnagrams(strs));
    }
    public List<List<String>> groupAnagrams(String[] arr) {
        List<String> inp=new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            inp.add(arr[i]);
        }
        List<List<String>> ans=new ArrayList<>();
        while(inp.size()>0){
            int i=0;
            String is=inp.get(i);
            List<String> temp=new ArrayList<>();
            for(int j=i+1;j<inp.size();j++){
                String js=inp.get(j);
                boolean compare=compare(is,js);
                if(compare){
                    temp.add(js);
                    inp.remove(js);
                }
            }
            temp.add(is);
            inp.remove(is);
            ans.add(temp);
        }

        return ans;
    }

    private boolean compare(String s1, String s2) {
        int arr[]=new int[26];
        for(int i=0;i<s1.length();i++){
            arr[s1.charAt(i)-'a']++;
        }
        for(int i=0;i<s2.length();i++){
            arr[s2.charAt(i)-'a']--;
        }
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=0)
                return false;
        }
        return true;
    }
}
