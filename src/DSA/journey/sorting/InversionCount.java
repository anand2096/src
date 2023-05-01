package DSA.journey.sorting;

public class InversionCount {

    int mod = (int) Math.pow(10, 9) + 7;

    public int solve(int[] A) {
        int ans = mergeSort(A, 0, A.length - 1);
        return ans % mod;
    }

    public int mergeSort(int a[], int s, int e) {
        int invCount = 0;

        if (e > s) {
            int m = (s + e) / 2;
            invCount += mergeSort(a, s, m);
            invCount += mergeSort(a, m + 1, e);
            invCount += merge(a, s, m, e);
        }
        return invCount;

    }

    public int merge(int a[], int s, int m, int e) {
        int invCount = 0;
        int c[] = new int[e - s + 1];
        int p1 = s;
        int p2 = m + 1;
        int p3 = 0;
        while (p1 <= m && p2 <= e) {
            if (a[p1] <= a[p2]) {
                c[p3] = a[p1];
                p1++;
                p3++;
            } else {
                c[p3] = a[p2];
                p2++;
                p3++;

                invCount = (invCount % mod + (m - p1 + 1) % mod) % mod;
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
        return invCount;
    }
}
