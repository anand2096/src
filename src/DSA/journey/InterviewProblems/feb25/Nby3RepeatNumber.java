package DSA.journey.InterviewProblems.feb25;

import DSA.CommonFun;

import java.util.List;

public class Nby3RepeatNumber {
    public static void main(String[] args) {
        int arr[] = {1, 1, 1, 2, 3, 5, 7};
        System.out.println(new Nby3RepeatNumber().repeatedNumber(CommonFun.createInput(arr)));
    }

    public int repeatedNumber(final List<Integer> list) {
        int n = list.size();
        int num1 = -1;
        int num2 = -1;
        int count1 = 0;
        int count2 = 0;
        for (int i = 0; i < n; i++) {
            if (list.get(i) == num1) {
                count1++;
            } else if (list.get(i) == num2) {
                count2++;
            } else if (count1 == 0) {
                num1 = list.get(i);
                count1 = 1;
            } else if (count2 == 0) {
                num2 = list.get(i);
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        int cnt1 = 0;
        int cnt2 = 0;
        for (int i = 0; i < n; i++) {
            if (list.get(i) == num1) {
                cnt1++;
            } else if (list.get(i) == num2) {
                cnt2++;
            }
        }
        if (cnt1 > n / 3)
            return num1;
        else if (cnt2 > n / 3)
            return num2;
        else return -1;
    }
}
