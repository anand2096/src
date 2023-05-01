package DSA.journey.BinarySearch;

public class SingleElementInSortedArray {

    public static void main(String[] args) {
        int arr[] = {106, 106, 248, 248, 286, 286, 344, 357, 357};
        // 0 1 2
        System.out.println(new SingleElementInSortedArray().solve(arr));
    }


    public int solve(int arr[]) {
        int n = arr.length;
        if (arr.length == 1) return arr[0];
        if (arr[0] != arr[1]) {
            return arr[0];
        }
        if (arr[n - 1] != arr[n - 2]) {
            return arr[n - 2];
        }
        int low = 1;
        int high = n - 2;
        int mid=0;
        while (low <= high) {

            mid= (low + (high - low) / 2);
            if (arr[mid] != arr[mid - 1] && arr[mid] != arr[mid + 1]) {
                return arr[mid];
            } else {
                if (arr[mid] == arr[mid - 1]) {
                    mid = mid - 1;
                }

                if (mid % 2 == 0) {
                    low = mid + 2;
                } else {
                    high = mid - 1;
                }
            }
        }
        return arr[mid];
    }

    public int solveBetter(int[] arr) {
        int n = arr.length;
        int low = 0;
        int high = arr.length - 1;
        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (mid % 2 != 0) {
                if (arr[mid] == arr[mid - 1]) {
                    low = mid + 1;
                } else {

                    high = mid - 1;

                }
            } else {

                if (mid + 1 < n && arr[mid] == arr[mid + 1]) {
                    low = mid + 2;
                } else {
                    if (mid - 1 >= 0 && arr[mid] == arr[mid - 1]) {
                        high = mid - 1;
                    } else {
                        return arr[mid];
                    }
                }
            }
        }
        return ans;

    }
}
