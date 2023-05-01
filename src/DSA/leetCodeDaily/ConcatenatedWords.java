package DSA.leetCodeDaily;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ConcatenatedWords {
    HashSet<String> set;

    public static void main(String[] args) {
      String[]  words = {"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"};
        System.out.println(new ConcatenatedWords().findAllConcatenatedWOrdsInADict(words));

    }

    public List<String> findAllConcatenatedWOrdsInADict(String[] words) {
        List<String> res = new ArrayList<>();
        if (words.length == 0) return res;
        set = new HashSet<>();
        for (int i = 0; i < words.length; i++)
            set.add(words[i]);
        for (String word : words) {
            if (isConcat(word)) res.add(word);
        }
        return res;
    }
    public boolean isConcat(String word){
        int len=word.length();
        for(int i=1;i<len;i++){
            String prefix=word.substring(0,i);
            String suffix=word.substring(i);
            if(set.contains(prefix)&&(set.contains(suffix)||isConcat(suffix))){
                return true;
            }
        }
        return false;
    }


}
