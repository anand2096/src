package DSA.Graph;

import java.util.HashMap;
import java.util.Map;

public class JumpGameIV {
    int ans = Integer.MAX_VALUE;

    public static void main(String[] args) {
        int arr[] = {7,7,2,1,7,7,7,3,4,1};
        System.out.println(new JumpGameIV().minJumps(arr));
    }

    public int minJumps(int[] arr) {
        if (arr.length == 1)
            return 0;
        int lastElement = arr[arr.length - 1];
        Map<Integer, Integer> map = new HashMap<>();
        boolean vis[] = new boolean[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], Math.max(map.get(arr[i]), i));
            } else {
                map.put(arr[i], -1);
            }
        }
       int a= rec(0, arr, lastElement, 0, map, vis);
        return a;

    }

    private int rec(int index, int[] arr, int lastElement, int jump, Map<Integer, Integer> map, boolean vis[]) {
        vis[index] = true;

        if (arr[index] == lastElement) {
            if (index != arr.length - 1) {
                ans = Math.min(ans, jump + 1);
            } else {
                ans = Math.min(ans, jump);
            }
            return ans;
        }
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;
        int third = Integer.MAX_VALUE;
        if (map.get(arr[index]) != -1 && map.get(arr[index]) != index) {
            if (!vis[map.get(arr[index])])
                first = rec(map.get(arr[index]), arr, lastElement, jump + 1, map, vis);
        }

        if (!vis[index + 1])
            second = rec(index + 1, arr, lastElement, jump + 1, map, vis);
        if (index > 0 && !vis[index - 1]) {
            third = rec(index - 1, arr, lastElement, jump + 1, map, vis);
        }

        return  Math.min(first,Math.min(second,third));
    }
}
