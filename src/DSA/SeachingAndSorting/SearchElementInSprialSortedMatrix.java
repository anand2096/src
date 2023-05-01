package DSA.SeachingAndSorting;

public class SearchElementInSprialSortedMatrix {
    final static int n =5;

    // Function to return the ring,
// the number x belongs to.
    static int findRing(int arr[][], int x)
    {
        // Returns -1 if number x is
        // smaller than least element of arr
        if (arr[0][0] > x)
            return -1;

        // l and r represent the diagonal
        // elements to search in
        int l = 0, r = (n + 1) / 2 - 1;

        // Returns -1 if number x is greater
        // than the largest element of arr
        if (n % 2 == 1 && arr[r][r] < x)
            return -1;
        if (n % 2 == 0 && arr[r + 1][r] < x)
            return -1;

        while (l < r)
        {
            int mid = (l + r) / 2;
            if (arr[mid][mid] <= x)
                if (mid == (n + 1) / 2 - 1
                        || arr[mid + 1][mid + 1] > x)
                    return mid;
                else
                    l = mid + 1;
            else
                r = mid - 1;
        }
        return r;
    }

    // Function to perform binary search
// on an array sorted in increasing order
// l and r represent the left and right
// index of the row to be searched
    static int binarySearchRowInc(int arr[][], int row,
                                  int l, int r, int x)
    {
        while (l <= r)
        {
            int mid = (l + r) / 2;

            if (arr[row][mid] == x)
                return mid;

            if (arr[row][mid] < x)
                l = mid + 1;
            else
                r = mid - 1;
        }
        return -1;
    }

    // Function to perform binary search on
// a particular column of the 2D array
// t and b represent top and
// bottom rows
    static int binarySearchColumnInc(int arr[][], int col,
                                     int t, int b, int x)
    {
        while (t <= b)
        {
            int mid = (t + b) / 2;

            if (arr[mid][col] == x)
                return mid;

            if (arr[mid][col] < x)
                t = mid + 1;
            else
                b = mid - 1;
        }
        return -1;
    }

    // Function to perform binary search on
// an array sorted in decreasing order
    static int binarySearchRowDec(int arr[][], int row,
                                  int l, int r, int x)
    {
        while (l <= r) {

            int mid = (l + r) / 2;

            if (arr[row][mid] == x)
                return mid;

            if (arr[row][mid] < x)
                r = mid - 1;
            else
                l = mid + 1;
        }
        return -1;
    }

    // Function to perform binary search on a
// particular column of the 2D array
    static int binarySearchColumnDec(int arr[][], int col,
                                     int t, int b, int x)
    {
        while (t <= b)
        {
            int mid = (t + b) / 2;

            if (arr[mid][col] == x)
                return mid;

            if (arr[mid][col] < x)
                b = mid - 1;
            else
                t = mid + 1;
        }
        return -1;
    }

    // Function to find the position of the number x
    static void spiralBinary(int arr[][], int x)
    {

        // Finding the ring
        int f1 = findRing(arr, x);

        // To store row and column
        int r, c;

        if (f1 == -1)
        {
            System.out.print("-1");
            return;
        }

        // Edge case if n is odd
        if (n % 2 == 1 && f1 == (n + 1) / 2 - 1)
        {
            System.out.println(f1+" "+f1);
            return;
        }

        // Check which of the 4 sides, the number x
        // lies in
        if (x < arr[f1][n - f1 - 1])
        {
            c = binarySearchRowInc(arr, f1, f1,
                    n - f1 - 2, x);
            r = f1;
        }
        else if (x < arr[n - f1 - 1][n - f1 - 1])
        {
            c = n - f1 - 1;

            r = binarySearchColumnInc(arr, n - f1 - 1, f1,
                    n - f1 - 2, x);
        }
        else if (x < arr[n - f1 - 1][f1])
        {
            c = binarySearchRowDec(arr, n - f1 - 1, f1 + 1,
                    n - f1 - 1, x);
            r = n - f1 - 1;
        }
        else
        {
            r = binarySearchColumnDec(arr, f1, f1 + 1,
                    n - f1 - 1, x);
            c = f1;
        }

        // Printing the position
        if (c == -1 || r == -1)
            System.out.print("-1");
        else
            System.out.print(r+" "+c);

        return;
    }

    // Driver code
    public static void main(String[] args)
    {
        int arr[][] = {
                  { 1, 2, 3, 4 ,5},
                { 16, 17, 18, 19 ,6},
                { 15, 24, 25, 20,7},
                { 14, 23, 22, 21,8 },
                { 13, 12, 11, 10,9}
        };

        spiralBinary(arr, 25);
    }
}

// This code is contributed by 29AjayKumar