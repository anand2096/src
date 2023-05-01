package DSA.leetCodeDaily;


//https://leetcode.com/problems/restore-ip-addresses/

import java.util.ArrayList;
import java.util.List;

public class RestoreIpAddresses {
    List<String> ans=new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        checkIp(s,"",0,0);
        return ans;

    }

    public void checkIp(String s,String path,int index, int dots){

        if(dots==4 && index==s.length()){
            ans.add(path.substring(0,path.length()-1));
            return;
        }
        for(int i=1;i<=3&&index+i<=s.length();i++){
            String part=s.substring(index,index+i);
            if(part.charAt(0)=='0' && part.length()!=1)
                break;
            else if(Integer.parseInt(part)<=255){
                checkIp(s,path+part+".",index+i,dots+1);
            }
        }

    }

}