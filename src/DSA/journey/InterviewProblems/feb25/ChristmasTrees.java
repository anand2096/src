package DSA.journey.InterviewProblems.feb25;

import DSA.CommonFun;

import java.util.ArrayList;

public class ChristmasTrees {

    public static void main(String[] args) {
        int a[] = {5, 9, 10, 4, 7, 8};
        int b[] = { 5, 6, 4, 7, 2, 5};

        System.out.println(new ChristmasTrees().solve(CommonFun.createInput(a), CommonFun.createInput(b)));
    }
    public int solve(ArrayList<Integer> height, ArrayList<Integer> cost) {
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i < height.size() - 1; i++) {
            int currentHeight = height.get(i);
            int currentCost = cost.get(i);
            int minIndex = -1;
            int maxIndex = -1;
            int tempLeftCost=Integer.MAX_VALUE;
            for (int j = i - 1; j >= 0; j--) {
                if ((height.get(j) < currentHeight )&& (cost.get(j)<tempLeftCost)) {
                    minIndex = j;
                    tempLeftCost=cost.get(j);
                }
            }
            int tempRightCost=Integer.MAX_VALUE;
            for (int k = i + 1; k < height.size(); k++) {
                if ((height.get(k) > currentHeight) && (cost.get(k)<tempRightCost)) {
                    maxIndex = k;
                    tempRightCost=cost.get(k);
                }
            }
            if(minIndex!=-1 && maxIndex!=-1) {
                currentCost = currentCost + cost.get(maxIndex)+cost.get(minIndex);
                ans = Math.min(ans, currentCost);
            }
        }

        if(ans==Integer.MAX_VALUE)return -1;
        else
            return  ans;
    }
}
