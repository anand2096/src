package DSA.leetCodeDaily;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FruitIntoBaskets {

    public static void main(String[] args) {
        int[] fruits = {1, 2, 3, 2, 2};

        System.out.println(new FruitIntoBaskets().totalFruit(fruits));
    }

    public int totalFruit(int[] fruits) {
        //   Arrays.sort(fruits);
        int maxCount = Integer.MIN_VALUE;
        Map<Integer, Integer> map = new HashMap<>();
        int i = 0, j = 0;
        int cnt = 0;
        while (j < fruits.length) {
            if (map.size() < 2) {
                map.put(fruits[j], map.getOrDefault(fruits[j], 0) + 1);
            } else {
                if (map.size() == 2 && map.containsKey(fruits[j])) {
                    map.put(fruits[j], map.get(fruits[j]) + 1);
                } else {
                    while (map.size() >= 2) {
                        int temp = map.get(fruits[i]);
                        if (temp == 1) {
                            map.remove(fruits[i]);
                        } else {
                            map.put(fruits[i], map.get(fruits[i]) - 1);
                        }
                        i++;
                        cnt--;
                    }
                    map.put(fruits[j], map.getOrDefault(fruits[j], 0) + 1);
                }
            }
            cnt++;
            j++;
            if (maxCount < cnt) {
                maxCount = cnt;
            }
        }
        return maxCount;
    }

}
