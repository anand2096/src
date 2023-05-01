package DSA.Arrays;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FirstNegativeInWindowK {
    public static void main(String[] args) {
        int n = 5;
        long a[] = {-8, 2, 3, -6, 10};
        int k = 2;

        System.out.println(printFirstNegativeInteger(a, n, k));

    }

    public static long[] printFirstNegativeInteger(long a[], int n, int k) {
        List<Long> ans = new ArrayList<>();
        Queue<Long> q = new LinkedList<>();
        int i = 0, j = 0;
        while (j < n) {
         //   long a[] = {-8, 2, 3, -6, 10};
            if (a[j] < 0) q.add(a[j]);

            if (j - i + 1 < k) j++;

            else if (j - i + 1 == k) {

                if (q.size() == 0) ans.add(0L);
                else {
                    ans.add(q.peek());
                    if (q.peek() == a[i]) {
                        q.poll();
                    }


                }
                i++;
                j++;
            }



        }


        return ans.stream().mapToLong(l->l).toArray();
    }
}
