package DSA.journey.sorting;

public class ReversePairs {


//    Given an array of integers A. If i < j and A[i] > A[j],
//    then the pair (i, j) is called an inversion of A. Find the total number of inversions of A modulo (109 + 7).

//
//    Given an array of integers A, we call (i, j) an important reverse pair if i < j and A[i] > 2*A[j].
//    Return the number of important reverse pairs in the given array A.


    int swaps = 0;
    int mod = (int) Math.pow(10, 9) + 7;

    public static void main(String[] args) {
        //     int [] A = {14046, 57239, 78362, 99387, 27609, 55100, 65536, 62099, 40820, 33056, 88380, 78549, 57512, 33137, 81212, 32365, 42276, 65368, 52459, 74924, 25355, 76044, 78056, 45190, 94365, 58869, 20611};
//
        int A[] = {1, 3, 2, 3, 1};

        System.out.println(new ReversePairs().solve(A));
//        for(int i=0;i<A.length;i++){
//            System.out.print(A[i]);
//        }
    }

    public int solve(int[] A) {
        mergeSort(A, 0, A.length - 1);
        return swaps % mod;
    }

    public void mergeSort(int a[], int s, int e) {

        if (s == e) {
            return;
        }
        int m = (s + e) / 2;
        mergeSort(a, s, m);
        mergeSort(a, m + 1, e);
        merge(a, s, m, e);

    }

    public void merge(int a[], int s, int m, int e) {
        int c[] = new int[e - s + 1];
        int p1 = s;
        int p2 = m + 1;
        int p3 = 0;
        int j = m + 1;
        for (int i = s; i <= m; i++) {
            while (j <= e && a[i] > (2 * (long) a[j])) {
                j++;
            }
            swaps = swaps + (j - (m + 1));
        }
        while (p1 <= m && p2 <= e) {

            if (a[p1] <= a[p2]) {
                c[p3] = a[p1];
                p1++;
                p3++;
            } else {
                c[p3] = a[p2];
                p2++;
                p3++;


            }
        }

        while (p1 <= m) {
            c[p3] = a[p1];
            p3++;
            p1++;

        }
        while (p2 <= e) {
            c[p3] = a[p2];
            p2++;
            p3++;

        }
        for (int i = 0; i <= (e - s); i++) {
            a[s + i] = c[i];
        }

    }
}
