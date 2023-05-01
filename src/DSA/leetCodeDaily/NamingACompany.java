package DSA.leetCodeDaily;

import java.util.*;

public class NamingACompany {
    public static void main(String[] args) {
        String[] ideas = {"lack","back"};
        System.out.println(new NamingACompany().distinctNames(ideas));
    }

    public long distinctNames(String[] ideas) {
        Set<String>[] suffixesByLetter=new Set[26];
        for(int i=0;i<26;i++){
            suffixesByLetter[i]=new HashSet<>();
        }
        for(String idea:ideas){
            suffixesByLetter[idea.charAt(0)-'a'].add(idea.substring(1));
        }
        long pairs=0;
        for(int i=0;i<26;i++){
            for(int j=i+1;j<26;j++){
                int overlapping=0;
                for(String suffix:suffixesByLetter[i]){
                    if(suffixesByLetter[j].contains(suffix)){
                        overlapping++;
                    }
                }
                pairs+=(suffixesByLetter[i].size()-overlapping)*(suffixesByLetter[j].size()-overlapping)*2;
            }

        }
        return pairs;

    }

    public long distinctNamesTLE(String[] ideas) {
        long count = 0;
        List<String> ideaList = Arrays.asList(ideas);
        for (int i = 0; i < ideas.length-1; i++) {
            for(int j=i+1;j<ideas.length;j++) {
                String prev = ideas[i];
                String curr = ideas[j];
                String newPrev = curr.charAt(0) + prev.substring(1);
                String newCurr = prev.charAt(0) + curr.substring(1);
                if (!ideaList.contains(newPrev) && !ideaList.contains(newCurr)) {
                    count = count + 2;
                }
            }
        }
        return count;

    }
}
