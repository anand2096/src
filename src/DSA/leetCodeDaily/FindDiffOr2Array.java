package DSA.leetCodeDaily;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindDiffOr2Array {

    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> flist1=new ArrayList<>();
        List<Integer> flist2=new ArrayList<>();
        Set<Integer> set1=new HashSet<>();
        Set<Integer> set2=new HashSet<>();
        for(int i=0;i<nums1.length;i++){
            set1.add(nums1[i]);

        }
        for(int i=0;i<nums2.length;i++){
            set2.add(nums2[i]);
        }


        for(int s:set1){
        if(!set2.contains(s)){
            flist1.add(s);
        }
    }
        for(int s:set2){
        if(!set1.contains(s)){
            flist2.add(s);
        }
    }
    //  flist1= set2.stream().collect(Collectors.toList());
    // flist2=set1.stream().collect(Collectors.toList());
        ans.add(flist1);
        ans.add(flist2);
        return ans;

}
}
