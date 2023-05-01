package DSA.leetCodeDaily;

import java.util.*;

public class PallindromePartitioning {
    List<List<String>> ans = new ArrayList<>();
    List<String> path = new ArrayList<>();

    public static void main(String[] args) {
        String s = "aabb";
        System.out.println(new PallindromePartitioning().partition(s));
    }


    public List<List<String>> partition(String s) {
        if (s.length() == 1) {
            List<String> tans = new ArrayList<>();
            tans.add(s);
            ans.add(tans);
            return ans;
        }

        int len = s.length() - 1;
        func(0,s,path,ans);
        return ans;

    }

    public void func(int index,String s, List<String> path , List<List<String>> res){

        if(index==s.length()){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i=index;i<s.length();i++){
            if(isPallindrome(s.substring(index,i+1))){
                path.add(s.substring(index,i+1));
                func(i+1,s,path,res);
                path.remove(path.size()-1);
            }
        }



    }

//    public void partitionRec(String s, String path, int index, int len) {
//        if (index >= s.length()) {
//            if (isPallindromeList(path)) {
//                List<String> al = Arrays.asList(path.split(","));
//                ans.add(al);
//            }
//              tempList=new ArrayList<>();
//            return;
//        }
//        for (int i = 1; i <= len && index + i <= s.length(); i++) {
//            String temp = s.substring(index, index + i);
//            tempList.add(temp);
//            String tempStr="";
//            if (!path.isEmpty())
//             tempStr=path + "," + temp;
//            else tempStr =temp;
//
//            partitionRec(s, tempStr, index + i, len);
//
//           tempList.remove(temp);
//
//        }
//    }

//    public boolean isPallindromeList(List<String> strList){
//        boolean isPal=true;
//        for(String str:strList){
//
//            if(!isPallindrome(str)){
//                isPal=false;
//                break;
//            }
//        }
//        return  isPal;
//    }

//    public boolean isPallindromeList(String strList) {
//        boolean isPal = true;
//        List<String> al = Arrays.asList(strList.split(","));
//        for (String str : al) {
//            if (!isPallindrome(str)) {
//                isPal = false;
//                break;
//            }
//        }
//        return isPal;
//    }

    public boolean isPallindrome(String s) {
        String rev = "";
        for (int i = s.length() - 1; i >= 0; i--)
            rev = rev + s.charAt(i);

        if (s.equals(rev))
            return true;
        else
            return false;
    }


}
