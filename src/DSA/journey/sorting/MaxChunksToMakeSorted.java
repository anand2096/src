package DSA.journey.sorting;

public class MaxChunksToMakeSorted {

    public static void main(String[] args) {
        int arr[] = { 1, 0, 2, 3, 4};
        System.out.println(new MaxChunksToMakeSorted().solve(arr));

    }
    public int solve(int[] arr) {
        int maxele = Integer.MIN_VALUE, n = arr.length;
        int chunksCount = 0;
        for(int i = 0; i < n; i++){
            maxele = Math.max(maxele, arr[i]);
            if(maxele == i)
                chunksCount++;
        }
        return chunksCount;

    }
}
